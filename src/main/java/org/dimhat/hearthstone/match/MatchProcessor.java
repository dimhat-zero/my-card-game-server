package org.dimhat.hearthstone.match;

import org.dimhat.hearthstone.match.expander.MatchTRExpander;
import org.dimhat.hearthstone.match.expander.RangeExpander;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * 匹配进程
 */
public class MatchProcessor implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(MatchProcessor.class);

    //任务队列
    private LinkedBlockingQueue<MatchTask> taskQueue = new LinkedBlockingQueue<MatchTask>();
    //等待增加任务队列
    private LinkedBlockingQueue<MatchTask> waitAddTaskQueue = new LinkedBlockingQueue<MatchTask>();
    //匹配算法配置对象
    private MatchConfig config;
    //预定执行服务
    private ScheduledExecutorService scheduledExecutor = Executors
            .newSingleThreadScheduledExecutor(new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setName("Match-Processor");
                    return t;
                };
            });
    //范围增大器
    private RangeExpander matchRangeExpander;
    //匹配进程通知
    private MatchProcessorNotifier notifier;
    //当前线程
    private Thread workThread = null;
    //总共匹配数
    private int totalMatched = 0;

    public MatchProcessor(MatchConfig config) {
        this.config = config;
        if (config.getMatchExpandConfig() != null) {
            matchRangeExpander = new MatchTRExpander(
                    config.getMatchExpandConfig());
        }
    }

    public MatchConfig getMatchConfig() {
        return config;
    }

    /**
     * 提交匹配任务 在方法中会设置匹配开始时间，在task提交进来之前必须设置好匹配范围
     */
    public void submitMatch(MatchTask task) {
        try {
            task.setStartTime(System.currentTimeMillis());
            logger.debug("匹配器收到任务：{}",task.simple());
            waitAddTaskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取消匹配任务，从匹配队列中移除
     */
    public void cancelMatch(MatchTask task) {
        waitAddTaskQueue.remove(task);
        taskQueue.remove(task);
    }

    public LinkedBlockingQueue<MatchTask> getTaskQueue() {
        return taskQueue;
    }

    public LinkedBlockingQueue<MatchTask> getWaitAddTaskQueue() {
        return waitAddTaskQueue;
    }

    /**
     * 将待处理的匹配任务填充到taskQueue中,下次执行匹配遍历时就会计算这些任务
     */
    protected void fillTaskQueue() {
        if (!getWaitAddTaskQueue().isEmpty()) {
            Iterator<MatchTask> iterator = getWaitAddTaskQueue().iterator();
            while (iterator.hasNext()) {
                getTaskQueue().add(iterator.next());
                iterator.remove();
            }
        }
    }

    /**
     * 回到匹配队列尾部
     */
    protected void headToTail() throws InterruptedException {
        MatchTask t = taskQueue.remove();
        taskQueue.put(t);
    }

    /**
     * 用当前任务匹配一遍其他任务
     * 返回匹配成功的任务
     */
    protected MatchTask matchTask(MatchTask task) {
        logger.debug("匹配器开始匹配任务{}",task);
        task.incrementMatchCount();
        expandMatchRange(task);
        List<Integer> matchRangeRecords = task.getMatchRangeRecords();
        //优先匹配范围小接近的
        for (int record : matchRangeRecords) {
            Iterator<MatchTask> iterator = getTaskQueue().iterator();
            while (iterator.hasNext()) {
                MatchTask position = iterator.next();
                if (!position.isActive()) {
                    iterator.remove();
                    continue;
                }
                if (position != task) {
                    int cpr = position.compareTo(task);
                    if (Math.abs(cpr) <= record) {// 找到合适的队伍
                        task.completed();
                        notifier.completed(task, position);
                        totalMatched = totalMatched + 2;
                        getTaskQueue().remove();// 匹配成功则移除头（task）并且移除position（匹配成功对象）
                        iterator.remove();
                        logger.debug("匹配成功，出队列成功。cpr：{} record:{}",Math.abs(cpr),record);
                        return position;
                    }
                }
            }
        }
        return null;
    }

    private void expandMatchRange(MatchTask task) {
        if (matchRangeExpander != null) {
            if (matchRangeExpander.isDifficultMatch(task)) {
                matchRangeExpander.expandMatchRange(task);
            }
        }
    }

    public void start() {
        scheduledExecutor.scheduleWithFixedDelay(this, 0, config.getMatchExecutePeriod(), TimeUnit.MILLISECONDS);
    }

    protected MatchProcessorNotifier getNotifier() {
        return notifier;
    }

    public void setNotifier(MatchProcessorNotifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void run() {
        try {
            this.workThread = Thread.currentThread();
            //填充匹配队列
            fillTaskQueue();
            MatchTask task = getTaskQueue().peek();//山峰不出队列
            if (task == null) {
                return;
            }
            if (!task.isActive()) {// 判断task是否失效
                getTaskQueue().remove();//山峰出队列
                return;
            }

            MatchTask result = matchTask(task);
            if (result == null) {
                // 未匹配成功，则将头移到尾部
                headToTail();
            } else {
                logger.debug("Complete a team match ( remain = {} ,totalMatched = {} )",getTaskQueue().size(),totalMatched);
            }

        } catch (Exception e) {
            logger.error("匹配异常", e);
        }

    }

    public Thread workThread() {
        return workThread;
    }
}
