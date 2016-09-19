package org.dimhat.hearthstone.model;

import org.dimhat.hearthstone.model.container.Deck;

import java.util.List;

/**
 * 玩家
 */
public class Player {

    private Long id;

    /*用户名*/
    private String username;

    /*密码*/
    private String password;

    /*昵称，唯一*/
    private String nickname;

    /*当前使用卡组*/
    private Deck deck;

    /*全部卡组*/
    private List<Deck> decks;

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

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", deck=").append(deck);
        sb.append('}');
        return sb.toString();
    }
}
