package org.dimhat.hearthstone.model.container.element;

import org.dimhat.hearthstone.Contacts;
import org.dimhat.hearthstone.model.card.Minion;

import java.util.LinkedList;
import java.util.List;

/**
 * 对战时：战场（7个位置）
 */
public class BattleGround extends LinkedList<Minion> {

    private List<Minion> list = new LinkedList<Minion>();

    private boolean put(int index,Minion minion){
        if(list.size()>= Contacts.MAX_MINION) return false;
        list.add(index,minion);
        return true;
    }

    private void remove(Minion minion){
        list.remove(minion);
    }
}
