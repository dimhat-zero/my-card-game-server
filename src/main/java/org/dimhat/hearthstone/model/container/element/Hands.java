package org.dimhat.hearthstone.model.container.element;


import org.dimhat.hearthstone.model.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 对战时：手牌
 */
public class Hands {

    private List<Card> list = new ArrayList<Card>();

    public boolean add(Card card){
        return list.add(card);
    }

    public void remove(Card card){
        list.remove(card);
    }

}
