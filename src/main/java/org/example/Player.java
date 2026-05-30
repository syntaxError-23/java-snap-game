package org.example;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> playerDeck = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(ArrayList<Card> playerDeck) {
        this.playerDeck = playerDeck;
    }

    public void addCardToPlayerDeck(Card card){
        playerDeck.add(card);
    }
}
