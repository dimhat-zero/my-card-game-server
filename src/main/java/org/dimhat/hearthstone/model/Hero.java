package org.dimhat.hearthstone.model;

import org.dimhat.hearthstone.lang.MInt;
import org.dimhat.hearthstone.lang.Nameable;

/**
 * 英雄
 */
public abstract class Hero extends Nameable{

    private MInt attack;//攻击

    private MInt armor;//护甲

    private MInt blood;//血量

    public Hero(Integer id, String title, String description, String explain, Integer patternId,MInt armor,MInt attack,MInt blood) {
        super(id, title, description, explain, patternId);
        this.armor=armor;
        this.attack=attack;
        this.blood=blood;
    }
}
