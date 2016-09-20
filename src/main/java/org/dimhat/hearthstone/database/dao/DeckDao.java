package org.dimhat.hearthstone.database.dao;

import org.dimhat.hearthstone.database.entity.Tdeck;

import java.util.List;

/**
 * 卡组dao
 */
public interface DeckDao {

    /**
     * 创建卡组
     * @param tdeck
     * @return
     */
    int save(Tdeck tdeck);

    int update(Tdeck tdeck);

    int delete(Tdeck tdeck);

    /**
     * 根据id查找卡组
     * @param id
     * @return
     */
    Tdeck getById(Long id);

    /**
     * 找打玩家所有卡组
     * @param playId
     * @return
     */
    List<Tdeck> findByPlayId(Long playId);
}
