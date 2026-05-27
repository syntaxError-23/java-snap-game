package org.example;

public class Main {
    public static void main(String[] args){
        CardGame exampleGame = new CardGame("Game 1");

        for(int i = 0; i < 10; i++){
            System.out.println("Top card: " + exampleGame.dealCard());
        }

    }
}
