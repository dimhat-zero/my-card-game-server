package org.dimhat.hearthstone.database.service;

import org.dimhat.hearthstone.model.Player;

/**
 * 玩家服务
 */
public interface PlayerService {

    Player register(String username, String password);

    Player login(String username,String password);

}
