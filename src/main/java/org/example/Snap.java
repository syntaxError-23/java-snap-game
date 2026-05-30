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
            Player p2 = new Player("Player 2");
            System.out.println("Player 2");
            p2.setName();

            shuffleDeck();

            // ---------- GAME LOOP ----------
            System.out.println("Current turn: " + currentTurn);
            while(!endGame) {
                //Check of deck is empty
                if(noOfCards() == 0){
                    replenishDeck();
                    shuffleDeck();
                }

                //First turn - start game
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

                //Display current player turn
                if (currentTurn % 2 == 0){
                    System.out.println("Current player: " + p2.getName());
                    System.out.println("-------------------------");
                } else {
                    System.out.println("Current player: " + p1.getName());
                    System.out.println("-------------------------");
                }

                //prompt to press enter to continue
                System.out.println("Press enter to continue");
                String nextTurnInput = scanner.nextLine();

                if(nextTurnInput.isEmpty()){
                    if(currentTurn == 1) {
                        compareCards.add(dealCard());
                        compareCards.add(dealCard());
                    }else if(currentTurn > 1){
                        compareCards.removeFirst();
                        compareCards.add(dealCard());
                    }

                    System.out.println(compareCards.get(0));
                    System.out.println(compareCards.get(1));

                    //Compares String value of current and previous card
                    if(compareCards.get(0).getStringCardValue().equals(compareCards.get(1).getStringCardValue())){
                        System.out.println("SNAP");
                        if(currentTurn % 2 == 0){
                            System.out.println(p2.getName() + " wins");
                        } else {
                            System.out.println(p1.getName() + " wins");
                        }
                        endGame = true;
                    }

                    System.out.println("NoOfCardsInDeck: " + noOfCards());

                } else{
                    System.out.println("Invalid input");
                    endGame = true;
                }
                currentTurn++;
            }
        }
}
