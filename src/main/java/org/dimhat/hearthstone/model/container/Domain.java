package org.dimhat.hearthstone.model.container;

import org.dimhat.hearthstone.model.Crystal;
import org.dimhat.hearthstone.model.Hero;
import org.dimhat.hearthstone.model.container.element.BattleGround;
import org.dimhat.hearthstone.model.container.element.Hands;
import org.dimhat.hearthstone.model.container.element.Library;

/**
 * 对战时：玩家领域
 */
public class Domain {

    private Hero hero;

    private Library library;

    private Hands hands;

    private BattleGround battleGround;

    private Crystal crystal;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Hands getHands() {
        return hands;
    }

    public void setHands(Hands hands) {
        this.hands = hands;
    }

    public BattleGround getBattleGround() {
        return battleGround;
    }

    public void setBattleGround(BattleGround battleGround) {
        this.battleGround = battleGround;
    }

    public Crystal getCrystal() {
        return crystal;
    }

    public void setCrystal(Crystal crystal) {
        this.crystal = crystal;
    }
}
