package com.vinay.design.deckofcards;


import java.util.List;

public class Deck<T extends Card> {
    private List<T> cards;

    public List<T> getCards() {
        return cards;
    }

    public void setCards(List<T> cards) {
        this.cards = cards;
    }
}
