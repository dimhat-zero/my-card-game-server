package org.dimhat.hearthstone.database.dao;

import org.dimhat.hearthstone.database.entity.Tplayer;

/**
 * 玩家dao
 */
public interface PlayerDao {

    /**
     * insert ignore忽略错误，只返回条数
     * @param player
     */
    int save(Tplayer player);

    int update(Tplayer tplayer);

    Tplayer getById(Long id);

    Tplayer getByUsername(String username);

    Tplayer  getByNickName(String nickname);

}
