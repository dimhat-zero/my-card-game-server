package org.dimhat.hearthstone.match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 匹配进程通知者
 */
public class MatchProcessorNotifier {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     * 成功匹配到2个任务
     * @param task
     * @param position
     */
    public void completed(MatchTask task, MatchTask position) {
        logger.debug("成功匹配到两个玩家：{} 和 {}",task,position);
    }
}
