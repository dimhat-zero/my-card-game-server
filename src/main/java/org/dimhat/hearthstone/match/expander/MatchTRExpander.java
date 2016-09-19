package org.dimhat.hearthstone.match.expander;

import org.dimhat.hearthstone.match.MatchTask;

/**
 * 匹配范围扩大器
 */
public class MatchTRExpander implements RangeExpander {

    private int minMatchDifficultTimes;

    private int expandMatchRangeScore;

    public MatchTRExpander(MatchExpandConfig matchExpandConfig) {
        super();
        this.minMatchDifficultTimes = matchExpandConfig.getMinMatchDifficultTimes();
        this.expandMatchRangeScore = matchExpandConfig.getExpandMatchRangeScore();
    }

    private static int rank = 25;//25分

    /**
     * 判断匹配是否困难
     */
    @Override
    public boolean isDifficultMatch(MatchTask task) {
        if(task.getMatchCount()>=minMatchDifficultTimes) return true;
        return false;
    }

    @Override
    public void expandMatchRange(MatchTask task) {
        task.addMatchRangeRecords(expandMatchRangeScore);
    }


}
