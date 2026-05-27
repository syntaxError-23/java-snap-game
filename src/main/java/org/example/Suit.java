package org.example;

public enum Suit {
    HEARTS("\u2661"), DIAMONDS("\u2662"), SPADES("\u2664"), CLUBS("\u2667");

    private final String suit;

    Suit(String suit){
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
