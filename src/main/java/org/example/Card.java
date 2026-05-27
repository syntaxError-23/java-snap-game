package org.example;

public class Card {

    private String cardSuit;
    private String stringCardValue;
    private int intCardValue;

    public Card(String cardSuit, String stringCardValue, int intCardValue) {
        this.cardSuit = cardSuit;
        this.stringCardValue = stringCardValue;
        this.intCardValue = intCardValue;
    }

    @Override
    public String toString(){
        return this.stringCardValue + " of " + this.cardSuit;
    }

    public String getCardSuit() {
        return cardSuit;
    }

    public String getStringCardValue() {
        return stringCardValue;
    }

    public int getIntCardValue() {
        return intCardValue;
    }
}