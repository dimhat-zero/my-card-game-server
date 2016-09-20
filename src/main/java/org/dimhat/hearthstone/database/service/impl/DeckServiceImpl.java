package org.dimhat.hearthstone.database.service.impl;

import org.dimhat.hearthstone.database.dao.DeckCardsDao;
import org.dimhat.hearthstone.database.dao.DeckDao;
import org.dimhat.hearthstone.database.entity.Tdeck;
import org.dimhat.hearthstone.database.entity.TdeckCards;
import org.dimhat.hearthstone.database.exception.BizException;
import org.dimhat.hearthstone.database.service.DeckService;
import org.dimhat.hearthstone.model.Hero;
import org.dimhat.hearthstone.model.container.Deck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 卡组服务
 */
@Service
@Transactional
public class DeckServiceImpl implements DeckService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DeckDao deckDao;

    @Autowired
    private DeckCardsDao deckCardsDao;

    @Override
    public Deck createDeck(Hero hero, Long playId) {
        Tdeck tdeck = new Tdeck();
        tdeck.setHeroId(hero.getId());
        tdeck.setName("未命名");
        tdeck.setPlayerId(playId);
        int insertCount = deckDao.save(tdeck);
        if(insertCount<=0){
            throw new BizException("创建卡组失败");
        }
        return null;
    }

    @Override
    public Deck updateDeck(Long id, String name) {
        Tdeck tdeck = deckDao.getById(id);
        tdeck.setName(name);
        deckDao.update(tdeck);
        return null;
    }

    @Override
    public Deck updateDeck(Long id, List<Integer> cardIds) {
        deckCardsDao.deleteCardsByDeckId(id);
        for (Integer cardId : cardIds) {
            TdeckCards tdeckCards = new TdeckCards();
            tdeckCards.setDeckId(id);
            tdeckCards.setCardId(cardId);
            deckCardsDao.save(tdeckCards);
        }
        return null;
    }

    @Override
    public Deck getDeckById(Long id){
        Tdeck tdeck = deckDao.getById(id);
        List<Long> cardIds = deckCardsDao.findCardIdsByDeckId(id);
        // FIXME: 2016/9/20
        return null;
    }

    @Override
    public List<Deck> findDeckByPlayId(Long playId){
        List<Tdeck> byPlayId = deckDao.findByPlayId(playId);
        // FIXME: 2016/9/20 
        return null;
    }

    @Override
    public void deleteDeck(Long deckId){
        Tdeck tdeck = deckDao.getById(deckId);
        deckDao.delete(tdeck);

        deckCardsDao.deleteCardsByDeckId(deckId);
    }
}
