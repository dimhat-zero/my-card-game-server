package org.dimhat.hearthstone.match;

import org.dimhat.hearthstone.match.expander.MatchExpandConfig;

/**
 * 没有阵营
 */
public class MatchConfig {
    private MatchExpandConfig matchExpandConfig;
    private long matchExecutePeriod;

    public MatchExpandConfig getMatchExpandConfig() {
        return matchExpandConfig;
    }

    public long getMatchExecutePeriod() {
        return matchExecutePeriod;
    }
}
