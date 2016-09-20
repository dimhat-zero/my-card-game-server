package org.dimhat.hearthstone;

import org.dimhat.hearthstone.match.MatchConfig;
import org.dimhat.hearthstone.match.MatchProcessor;
import org.dimhat.hearthstone.match.MatchProcessorNotifier;
import org.dimhat.hearthstone.match.MatchTask;
import org.dimhat.hearthstone.match.expander.MatchExpandConfig;
import org.dimhat.hearthstone.model.Player;
import org.dimhat.hearthstone.model.card.hero.Tuhao;
import org.dimhat.hearthstone.model.container.Deck;
import org.dimhat.hearthstone.model.container.element.Library;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 匹配进程器测试
 */
public class MatchProcessorTest {

    private static final Logger logger = LoggerFactory.getLogger(MatchProcessorTest.class);

    /**
     * 初始化可以差20分，超过3次匹配不到后，每次加10分
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        long matchExecutePeriod = 1000;
        MatchExpandConfig matchExpandConfig = new MatchExpandConfig(3,10);
        MatchConfig config = new MatchConfig(matchExpandConfig,matchExecutePeriod);
        MatchProcessor matchProcessor = new MatchProcessor(config);
        MatchProcessorNotifier notifier = new MatchProcessorNotifier();
        matchProcessor.setNotifier(notifier);
        logger.debug("启动匹配进程...");
        matchProcessor.start();

        int count  = 20;
        Random random = new Random();
        while(count-->0){
            Player player= new Player();
            player.setId((long) random.nextInt(100000000));
            player.setMmr(2000+random.nextInt(1000));//玩家分数区间
            Deck deck = new Deck();
            deck.setHero(new Tuhao());
            deck.setLibrary(new Library());
            player.setDeck(deck);
            MatchTask task1 = new MatchTask(player);
            //初始化添加可用分差
            task1.addMatchRangeRecords(20);
            matchProcessor.submitMatch(task1);
            Thread.sleep(1000L);
        }
    }

    @Test
    public void test() throws InterruptedException {


    }
}
