package org.dimhat.hearthstone.match;

import java.util.List;

/**
 * 匹配任务（单用户，没有组队）
 */
public class MatchTask {
    private long startTime;//开始时间
    private int matchCount=0;//已经匹配次数
    private List<Integer> matchRangeRecords;//匹配范围区域
    private int mmr;//匹配分
    private boolean isActive=true;//是否可用

    public int compareTo(MatchTask task) {
        return mmr - task.getMmr();
    }

    public int getMmr() {
        return mmr;
    }

    public void setMmr(int mmr) {
        this.mmr = mmr;
    }


    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void incrementMatchCount() {
        matchCount++;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public List<Integer> getMatchRangeRecords() {
        return matchRangeRecords;
    }

    /**
     * 在原来的范围基础上加一个匹配分差距
     */
    public void addMatchRangeRecords(int score) {
        int size = matchRangeRecords.size();
        matchRangeRecords.add(matchRangeRecords.get(size-1)+score);
    }

    /**
     * 是否可用
     */
    public boolean isActive() {
        return isActive;
    }

    public void completed() {
        isActive = false;
    }

}
