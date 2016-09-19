package org.dimhat;

import org.dimhat.hearthstone.GameManager;
import org.dimhat.hearthstone.model.Player;

/**
 * 卡牌存在数据库
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GameManager manager = new GameManager();
        Player player1 = new Player();
        Player player2 = new Player();
        manager.createOneGame(player1,player2);
    }
}
