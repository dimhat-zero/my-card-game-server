package org.dimhat.hearthstone.model.container.element;

import org.dimhat.hearthstone.algorithm.FisherYatesShuffle;
import org.dimhat.hearthstone.algorithm.Shuffle;
import org.dimhat.hearthstone.model.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * 牌库
 */
public class Library{

    private static Shuffle shuffle = new FisherYatesShuffle();

    private List<Card> list = new ArrayList<>();

    public boolean add(Card card){
        return list.add(card);
    }

    public boolean remove(Card card){
        return list.remove(card);
    }

    public void shuffle() {
        shuffle.shuffle(list);
    }
}
