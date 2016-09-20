package org.dimhat.hearthstone.database.service;

import org.dimhat.hearthstone.model.Hero;
import org.dimhat.hearthstone.model.container.Deck;

import java.util.List;

/**
 * 卡组服务
 */
public interface DeckService {

    /**
     * 选择英雄后，用户创建卡组
     * @param hero
     * @param playId
     * @return
     */
    Deck createDeck(Hero hero,Long playId);

    /**
     * 更新卡组名称
     * @param name
     * @return
     */
    Deck updateDeck(Long id,String name);

    /**
     * 更新卡组的卡牌组成
     * @param cardIds
     * @return
     */
    Deck updateDeck(Long id, List<Integer> cardIds);

    Deck getDeckById(Long id);

    List<Deck> findDeckByPlayId(Long playId);

    void deleteDeck(Long deckId);
}
