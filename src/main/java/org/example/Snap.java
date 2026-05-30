package org.example;
import java.util.*;

public class Snap extends CardGame{

    public Snap() {
        super("Snap");
    }

    Scanner scanner = new Scanner(System.in);

        public void playGame(){
            boolean endGame = false;
            int currentTurn = 1;
            ArrayList<Card> compareCards = new ArrayList<>();

            Player p1 = new Player("Player 1");
            System.out.println("Player 1");
            p1.setName();
//            Player p2 = new Player("Player 2");
//            System.out.println("Player 2");
//            p2.setName();



            shuffleDeck();

//            for (Card card : getDeck()){
//                p1.addCardToPlayerDeck(dealCard());
//                p2.addCardToPlayerDeck(dealCard());
//            }
//
//            System.out.println(p1.getPlayerDeck());
//            System.out.println(p2.getPlayerDeck());

            while(!endGame) {
                if(noOfCards() == 0){
                    replenishDeck();
                    shuffleDeck();
                }

                //First turn
                if(currentTurn == 1){
                    System.out.println("To start the game, press enter. To quit, press q: ");
                    String gameStarted = scanner.nextLine();

                    if (!gameStarted.isEmpty()){
                        if (gameStarted.equalsIgnoreCase("q")){
                            System.out.println("Game ended");
                            endGame = true;
                        } else {
                            System.out.println("Invalid input");
                        }
                        continue;
                    }
                }

                if(currentTurn == 1) {
                    compareCards.add(dealCard());
                    compareCards.add(dealCard());
                }else if(currentTurn > 1){
                    compareCards.removeFirst();
                    compareCards.add(dealCard());
                }

                System.out.println(compareCards.get(0));
                System.out.println(compareCards.get(1));

                if(compareCards.get(0).getStringCardValue().equals(compareCards.get(1).getStringCardValue())){
                    System.out.println("SNAP");
                    endGame = true;
                }

                System.out.println("NoOfCardsInDeck: " + noOfCards());

                currentTurn++;
            }
        }
}
