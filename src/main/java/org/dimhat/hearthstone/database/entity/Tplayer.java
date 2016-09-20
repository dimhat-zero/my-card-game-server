package org.dimhat.hearthstone.database.entity;

/**
 * 玩家表
 */
public class Tplayer {

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private Integer mmr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getMmr() {
        return mmr;
    }

    public void setMmr(Integer mmr) {
        this.mmr = mmr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tplayer{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", mmr=").append(mmr);
        sb.append('}');
        return sb.toString();
    }
}
