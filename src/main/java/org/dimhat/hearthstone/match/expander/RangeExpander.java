package org.dimhat.hearthstone.match.expander;

import org.dimhat.hearthstone.match.MatchTask;

/**
 * 范围扩大器接口
 */
public interface RangeExpander {

    /**
     * 是否匹配困难
     */
    boolean isDifficultMatch(MatchTask task);

    /**
     * 扩大匹配范围
     */
    void expandMatchRange(MatchTask task);
}
