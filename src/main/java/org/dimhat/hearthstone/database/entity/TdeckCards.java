package org.dimhat.hearthstone.database.entity;

/**
 * 卡组卡牌组成
 */
public class TdeckCards {

    private Long deckId;

    private Integer cardId;

    public Long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }
}
