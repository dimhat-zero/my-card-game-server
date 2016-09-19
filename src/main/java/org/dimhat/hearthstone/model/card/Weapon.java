package org.dimhat.hearthstone.model.card;

import org.dimhat.hearthstone.lang.MInt;

/**
 * 武器类
 */
public class Weapon extends Card {

    private MInt attack;

    private MInt blood;

    public Weapon(Integer id, String title, String description, String explain, Integer patternId, MInt cost,MInt attack,MInt blood) {
        super(id, title, description, explain, patternId, cost);
        this.attack=attack;
        this.blood=blood;
    }

    @Override
    CardType getCardType() {
        return CardType.WEAPON;
    }

    public MInt getAttack() {
        return attack;
    }

    public void setAttack(MInt attack) {
        this.attack = attack;
    }

    public MInt getBlood() {
        return blood;
    }

    public void setBlood(MInt blood) {
        this.blood = blood;
    }
}
