package org.dimhat.hearthstone.model.card.minion;

import org.dimhat.hearthstone.lang.MInt;
import org.dimhat.hearthstone.model.card.Minion;

/**
 * 随从卡：杨教授
 */
public class ProfessorYang extends Minion {

    public ProfessorYang() {
        super(101001, "羊教授", "战吼：对所有其他随从造成10点伤害", "让我们电个痛快！", 0,new MInt(10),new MInt(10),new MInt(10));
    }

}
