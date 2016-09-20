package org.dimhat.hearthstone;

import org.dimhat.hearthstone.exception.GameException;
import org.dimhat.hearthstone.model.Player;
import org.dimhat.hearthstone.model.container.Deck;
import org.dimhat.hearthstone.model.container.Domain;
import org.dimhat.hearthstone.model.container.OneGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 游戏管理器
 */
public class GameManager {

    private Map<String,OneGame> map = new HashMap<>();

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 两个玩家产生一局游戏
     * @param player1
     * @param player2
     * @return
     */
    public OneGame createOneGame(Player player1,Player player2){
        if(player1.getDeck()==null || player2.getDeck()==null){
            throw new GameException("未选择卡牌");
        }
        OneGame oneGame = new OneGame();
        oneGame.setPlayer1(player1);
        oneGame.setPlayer2(player2);
        oneGame.setDomain1(createDomain(player1.getDeck()));
        oneGame.setDomain2(createDomain(player2.getDeck()));

        this.initGameConfig(oneGame);
        logger.debug("开始游戏！");
        return oneGame;
    }

    private void initGameConfig(OneGame oneGame) {
        //洗牌
        oneGame.getDomain1().getLibrary().shuffle();
        oneGame.getDomain2().getLibrary().shuffle();

    }


    /**
     * 根据卡组创建对战领域
     * @param deck
     * @return
     */
    private Domain createDomain(Deck deck){
        Domain domain = new Domain();
        domain.setHero(deck.getHero());
        domain.setLibrary(deck.getLibrary());
        return domain;
    }

}
