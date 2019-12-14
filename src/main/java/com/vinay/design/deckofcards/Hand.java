package com.vinay.design.deckofcards;

import java.util.ArrayList;
import java.util.List;

public class Hand<T extends Card> {
    private List<T> cards = new ArrayList<>();
    int sum = 0;

    public void add(T t) {
        cards.add(t);
    }

    public int score() {

        cards.stream().forEach(e ->

                {
                    sum += e.getFacevalue();
                }
        );
        return sum;
    }

}
