package org.dimhat.hearthstone.model.container;

import org.dimhat.hearthstone.model.Hero;
import org.dimhat.hearthstone.model.container.element.Library;

/**
 * 卡组
 */
public class Deck {

    private Hero hero;

    private Library library;

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
}
