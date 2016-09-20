package org.dimhat.hearthstone.match;

import org.dimhat.hearthstone.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * 匹配任务（单用户，没有组队）
 */
public class MatchTask {
    private long startTime;//开始时间
    private int matchCount=0;//已经匹配次数
    private List<Integer> matchRangeRecords = new ArrayList<>();//匹配范围区域
    private int mmr;//匹配分
    private boolean isActive=true;//是否可用

    private Player player;//玩家

    public Player getPlayer() {
        return player;
    }

    public MatchTask(Player player) {
        this.player = player;
        this.mmr = player.getMmr();
    }

    public int compareTo(MatchTask task) {
        return mmr - task.getMmr();
    }

    public int getMmr() {
        return mmr;
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
        int maxRecord = score;
        if(size!=0){
            maxRecord += matchRangeRecords.get(size-1);
        }
        matchRangeRecords.add(maxRecord);
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


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MatchTask{");
        sb.append("startTime=").append(startTime);
        sb.append(", matchCount=").append(matchCount);
        sb.append(", matchRangeRecords=").append(matchRangeRecords);
        sb.append(", mmr=").append(mmr);
        sb.append(", player=").append(player.getId());
        sb.append('}');
        return sb.toString();
    }

    public String simple(){
        return "{player="+player.getId()+",mmr="+mmr+",count="+matchCount+"}";
    }
}
