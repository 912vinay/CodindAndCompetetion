package com.vinay.design.deckofcards;

public abstract class Card {
    private int facevalue;
    private Suits suits;

    public int getFacevalue() {
        return facevalue;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private boolean available;

    public Card(int facevalue, Suits suits) {
        this.facevalue = facevalue;
        this.suits = suits;
    }

    public boolean isAvailable() {
        return available;
    }


}
