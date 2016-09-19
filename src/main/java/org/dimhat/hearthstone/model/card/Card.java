package org.dimhat.hearthstone.model.card;

import org.dimhat.hearthstone.lang.MInt;
import org.dimhat.hearthstone.lang.Nameable;

/**
 * 卡牌基类
 */
public abstract class Card extends Nameable {

    /*卡牌费用：水晶数*/
    private MInt cost;

    public Card(Integer id, String title, String description, String explain, Integer patternId,MInt cost) {
        super(id, title, description, explain, patternId);
        this.cost = cost;
    }

    abstract CardType getCardType();
}
