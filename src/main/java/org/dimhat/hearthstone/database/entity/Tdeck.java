package org.dimhat.hearthstone.database.entity;

import static org.dimhat.hearthstone.model.Hero.hero;

/**
 * 卡组表
 */
public class Tdeck {

    private Long id;

    private Integer heroId;

    private Long playerId;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHeroId() {
        return heroId;
    }

    public void setHeroId(Integer heroId) {
        this.heroId = heroId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tdeck{");
        sb.append("id=").append(id);
        sb.append(", hero='").append(hero).append('\'');
        sb.append(", playerId=").append(playerId);
        sb.append('}');
        return sb.toString();
    }
}
