package org.dimhat.hearthstone.model;

import org.dimhat.hearthstone.lang.MInt;
import org.dimhat.hearthstone.lang.Nameable;

/**
 * 技能
 */
public class Skill extends Nameable{

    private MInt cost;

    public Skill(Integer id, String title, String description, String explain, Integer patternId,MInt cost) {
        super(id, title, description, explain, patternId);
        this.cost=cost;
    }

    public MInt getCost() {
        return cost;
    }

    public void setCost(MInt cost) {
        this.cost = cost;
    }
}
