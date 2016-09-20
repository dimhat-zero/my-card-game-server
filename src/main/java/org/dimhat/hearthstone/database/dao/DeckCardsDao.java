package org.dimhat.hearthstone.database.dao;

import org.dimhat.hearthstone.database.entity.TdeckCards;

import java.util.List;

/**
 * 卡组里面的卡牌
 */
public interface DeckCardsDao {

    int save(TdeckCards tdeckCards);

    int delete(TdeckCards tdeckCards);

    /**
     * 根据卡组id查找卡牌id集合
     * @param deckId
     * @return
     */
    List<Long> findCardIdsByDeckId(Long deckId);

    /**
     * 根据卡组id删除相关卡
     */
    void deleteCardsByDeckId(Long deckId);
}
