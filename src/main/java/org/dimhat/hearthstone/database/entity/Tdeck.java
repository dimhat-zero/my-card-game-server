package org.dimhat.hearthstone.database.entity;

/**
 * 卡组表
 */
public class Tdeck {

    private Long id;

    private String hero;

    private Long playerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
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
