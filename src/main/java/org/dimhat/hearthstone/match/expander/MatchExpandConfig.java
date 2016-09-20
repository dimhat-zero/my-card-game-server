package org.dimhat.hearthstone.match.expander;

/**
 * 匹配范围扩大配置
 */
public class MatchExpandConfig {

    /**
     * 最小匹配困难次数，大于等于即是匹配困难
     */
    private int minMatchDifficultTimes;

    /**
     * 每次扩大匹配范围递增分数
     */
    private int expandMatchRangeScore;

    public MatchExpandConfig(int minMatchDifficultTimes, int expandMatchRangeScore) {
        this.minMatchDifficultTimes = minMatchDifficultTimes;
        this.expandMatchRangeScore = expandMatchRangeScore;
    }

    public int getMinMatchDifficultTimes() {
        return minMatchDifficultTimes;
    }

    public void setMinMatchDifficultTimes(int minMatchDifficultTimes) {
        this.minMatchDifficultTimes = minMatchDifficultTimes;
    }

    public int getExpandMatchRangeScore() {
        return expandMatchRangeScore;
    }

    public void setExpandMatchRangeScore(int expandMatchRangeScore) {
        this.expandMatchRangeScore = expandMatchRangeScore;
    }
}
