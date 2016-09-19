package org.dimhat.hearthstone.model.card;

import org.dimhat.hearthstone.lang.MInt;

/**
 * 法术卡
 */
public class Spell extends Card {


    public Spell(Integer id, String title, String description, String explain, Integer patternId, MInt cost) {
        super(id, title, description, explain, patternId, cost);
    }

    @Override
    CardType getCardType() {
        return CardType.SPELL;
    }
}
