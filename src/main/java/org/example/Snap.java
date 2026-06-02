package org.example;
import java.io.IOException;
import java.util.*;

public class Snap extends CardGame{

    public Snap() {
        super("Snap");
    }

    Scanner scanner = new Scanner(System.in);

    private void printNoOfCards(){
        System.out.println("--------------------------");
        System.out.println("NoOfCardsInDeck: " + noOfCards());
        System.out.println("--------------------------");
    }

    public void playGame() throws InterruptedException, IOException {
        boolean endGame = false;
        int currentTurn = 1;
        ArrayList<Card> compareCards = new ArrayList<>();

        Player p1 = new Player("Player 1");
        System.out.println("Player 1");
        p1.setName(scanner);
        Player p2 = new Player("Player 2");
        System.out.println("Player 2");
        p2.setName(scanner);

        shuffleDeck();

        // -------------------- GAME LOOP --------------------

        while(!endGame) {
            System.out.println("Current turn: " + currentTurn);
            System.out.println("--------------------------");
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

            //adds cards to comparison ArrayList
            if(currentTurn == 1) {
                compareCards.add(dealCard());
                compareCards.add(dealCard());
            }else if(currentTurn > 1){
                compareCards.removeFirst();
                compareCards.add(dealCard());
            }

                //display current cards to player
                System.out.println(compareCards.get(0));
                System.out.println(compareCards.get(1));


                //Check if card values match
                if(compareCards.get(0).getStringCardValue().equals(compareCards.get(1).getStringCardValue())){
                    boolean inputReceived = false;

                    long startTime = System.currentTimeMillis();
                    long timeLimit = 2000; // 2 seconds in milliseconds

                    while(System.currentTimeMillis() - startTime < timeLimit) {
                        if(System.in.available() > 0) {
                            inputReceived = true;
                            break;
                        }
                        Thread.sleep(100); // wait a bit before checking again
                    }

                    if(inputReceived){
                        String snapInput = scanner.nextLine();
                        if(snapInput.equalsIgnoreCase("snap")){
                            if(currentTurn % 2 == 0){
                                System.out.println(p2.getName() + " WINS!");
                            } else {
                                System.out.println(p1.getName() + " WINS!");
                            }
                            endGame = true;
                        } else{
                            System.out.println("It's spelled S N A P");
                            printNoOfCards();
                            continue;
                        }
                    } else {
                        System.out.println("Too slow!");
                        printNoOfCards();
                        continue;
                    }

                }else {
                //prompt to press enter to continue
                System.out.println("Press enter to continue");
                String nextTurnInput = scanner.nextLine();

                if(nextTurnInput.isEmpty()){
                    currentTurn++;
                    printNoOfCards();
                    continue;
                }else{
                    System.out.println("Invalid input");
                    endGame = true;
                }
            }
            printNoOfCards();
            currentTurn++;
        }
    }
}
