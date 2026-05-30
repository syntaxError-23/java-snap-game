package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Player {

    private String name;
    private ArrayList<Card> playerDeck = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Player(String name){
        this.name = name;
    }

    public void setName() {
        System.out.println("Enter player name: ");
        String userInput = scanner.nextLine();

        if(userInput.isBlank()){
            System.out.println("Default name used");
            System.out.println("Welcome " + this.name);
        } else {
            this.name = userInput;
            System.out.println("Welcome " + this.name);
        }
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
