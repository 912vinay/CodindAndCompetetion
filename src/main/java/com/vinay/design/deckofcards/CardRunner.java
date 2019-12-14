package com.vinay.design.deckofcards;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CardRunner {
    public static void main(String[] args) {
        Suits suits = Suits.getSuits(2);
        System.out.println(suits.getValue());
        Deck<Card> deck=new Deck<>();
        List<Card> cards=new ArrayList<>();
        cards.add(new BlackJackCard(10,Suits.spade));
        deck.setCards(cards);
    }
}
