package org.dimhat.hearthstone.model;

import org.dimhat.hearthstone.lang.MInt;
import org.dimhat.hearthstone.lang.Nameable;

/**
 * 英雄
 */
public class Hero extends Nameable{

    private MInt attack = new MInt(0);//攻击

    private MInt armor = new MInt(0);//护甲

    private MInt blood = new MInt(30);//血量

    public Hero(Integer id, String title, String description, String explain, Integer patternId,MInt armor,MInt attack,MInt blood) {
        super(id, title, description, explain, patternId);
        this.armor=armor;
        this.attack=attack;
        this.blood=blood;
    }

    public Hero(Integer id, String title, String description, String explain, Integer patternId) {
        super(id, title, description, explain, patternId);
    }

    public static Hero hero = new Hero(1001,"土豪","iphone没兜","",0);

    public MInt getAttack() {
        return attack;
    }

    public void setAttack(MInt attack) {
        this.attack = attack;
    }

    public MInt getArmor() {
        return armor;
    }

    public void setArmor(MInt armor) {
        this.armor = armor;
    }

    public MInt getBlood() {
        return blood;
    }

    public void setBlood(MInt blood) {
        this.blood = blood;
    }
}
