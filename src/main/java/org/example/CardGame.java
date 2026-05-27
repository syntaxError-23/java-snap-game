package org.example;
import java.util.ArrayList;
import java.util.Comparator;

public class CardGame {
    private ArrayList<Card> deck = new ArrayList<>();
    private String name;

    public CardGame(String name) {
        this.name = name;

        for(CardValue value : CardValue.values()){
            for (Suit suit : Suit.values()){
                deck.add(new Card(suit.getSuit(), value.getStringValue(), value.getIntValue()));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        for(Card card : deck){
            System.out.println(card.toString());
        }
        return deck;
    }

    public String getName() {
        return name;
    }

    public Card dealCard(){
        Card topCard = deck.getLast();
        deck.removeLast();

        return topCard;
    }

    public void sortDeckInNumberOrder(){
        deck.sort((a,b) -> a.getIntCardValue() - b.getIntCardValue());
    }


    

}

