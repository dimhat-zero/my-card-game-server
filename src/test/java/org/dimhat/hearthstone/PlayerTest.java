package org.dimhat.hearthstone;

import org.dimhat.hearthstone.database.service.PlayerService;
import org.dimhat.hearthstone.model.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 玩家功能测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class PlayerTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlayerService playerService;

    @Test
    public void testRegister(){
        Player player1 = playerService.register("player10086", "123456");
        logger.debug("注册成功： {}",player1);
    }

    @Test
    public void testLogin(){
        Player player1 = playerService.register("player10086", "123456");
        logger.debug("注册成功： {}",player1);
        Player player = playerService.login("player10086","123456");
        logger.debug("登录成功：{}",player);
    }
}
