package org.dimhat.hearthstone.match;

import org.dimhat.hearthstone.match.expander.MatchExpandConfig;

/**
 * 没有阵营
 */
public class MatchConfig {
    private MatchExpandConfig matchExpandConfig;
    private long matchExecutePeriod;

    public MatchConfig(long matchExecutePeriod) {
        this.matchExecutePeriod = matchExecutePeriod;
    }

    public MatchConfig(MatchExpandConfig matchExpandConfig, long matchExecutePeriod) {
        this.matchExpandConfig = matchExpandConfig;
        this.matchExecutePeriod = matchExecutePeriod;
    }

    public MatchExpandConfig getMatchExpandConfig() {
        return matchExpandConfig;
    }

    public long getMatchExecutePeriod() {
        return matchExecutePeriod;
    }
}
