package org.dimhat.hearthstone.model.card;


import org.dimhat.hearthstone.lang.MInt;

/**
 * 随从卡，id 10开头
 */
public abstract class Minion extends Card {

    private MInt attack;

    private MInt blood;

    public Minion(Integer id, String title, String description, String explain, Integer patternId,MInt cost,MInt attack,MInt blood) {
        super(id, title, description, explain, patternId,cost);
        this.attack=attack;
        this.blood=blood;
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

    @Override
    CardType getCardType() {
        return CardType.MINION;
    }
}
