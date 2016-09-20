package org.dimhat.hearthstone.database.service.impl;

import org.dimhat.hearthstone.Contacts;
import org.dimhat.hearthstone.database.dao.PlayerDao;
import org.dimhat.hearthstone.database.entity.Tplayer;
import org.dimhat.hearthstone.database.exception.BizException;
import org.dimhat.hearthstone.database.service.PlayerService;
import org.dimhat.hearthstone.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
 * 玩家服务实现类
 */
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlayerDao playerDao;

    @Override
    public Player register(String username, String password) {
        Tplayer player = new Tplayer();
        player.setUsername(username);
        player.setMmr(Contacts.INIT_MMR);
        player.setPassword(encryptPassword(password));
        int insertCount = playerDao.save(player);
        if(insertCount<=0){
            throw new BizException("注册失败！");
        }
        return trans(player);
    }

    private String encryptPassword(String password){
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    @Override
    public Player login(String username, String password) {
        Tplayer tplayer = playerDao.getByUsername(username);
        if(tplayer==null){
            throw new BizException("找不到用户！");
        }
        String userEncryptPassword = encryptPassword(password);
        if(tplayer.getPassword().equals(userEncryptPassword)){
            logger.debug("用户{}登录成功！",username);
            return trans(tplayer);
        }else{
            throw new BizException("用户名或密码不正确！");
        }
    }


    private Player trans(Tplayer tplayer){
        Player player = new Player();
        BeanUtils.copyProperties(tplayer,player);
        return player;
    }
}
