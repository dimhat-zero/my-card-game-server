package org.dimhat.hearthstone.model.card.minion;

import org.dimhat.hearthstone.lang.MInt;
import org.dimhat.hearthstone.model.card.Minion;
import org.dimhat.hearthstone.model.container.OneGame;

/**
 * 随从：村头一喵
 */
public class Cuntouyimiao extends Minion implements BattleCry {
    public Cuntouyimiao() {
        super(1001003, "村头一喵", "战吼：使一个随从随机变形成为一个1/1的喵", "", 0, new MInt(3), new MInt(2), new MInt(2));
    }

    @Override
    public void battleCry(OneGame oneGame) {

    }
}
