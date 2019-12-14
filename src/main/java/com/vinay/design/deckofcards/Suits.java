package com.vinay.design.deckofcards;

public enum Suits {
    asc(0), diamond(1), heart(2), spade(3);

    int value;

    public int getValue() {
        return value;
    }


    Suits(int i) {
        value = i;
    }

    public static Suits getSuits(int d) {
        Suits[] values = Suits.values();
        return values[d];
    }
}
