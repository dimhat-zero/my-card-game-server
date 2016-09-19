package org.dimhat.hearthstone.model.container;

import org.dimhat.hearthstone.model.Player;

/**
 * 一局游戏
 */
public class OneGame {

    private Player player1;

    private Domain domain1;

    private Player player2;

    private Domain domain2;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Domain getDomain1() {
        return domain1;
    }

    public void setDomain1(Domain domain1) {
        this.domain1 = domain1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Domain getDomain2() {
        return domain2;
    }

    public void setDomain2(Domain domain2) {
        this.domain2 = domain2;
    }
}
