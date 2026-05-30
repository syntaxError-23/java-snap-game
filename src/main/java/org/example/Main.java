package org.example;

public class Main {
    public static void main(String[] args){
        CardGame exampleGame = new CardGame("Game 1");

        exampleGame.sortDeckInNumberOrder();

        exampleGame.getDeck();

        exampleGame.sortDeckInSuitOrder();

        System.out.println("-----------------------------------------");

        exampleGame.getDeck();

    }
}
