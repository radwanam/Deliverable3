package ca.sheridancollege.project;

import java.util.ArrayList;

public class Hand extends GroupOfCards implements Comparable<Hand> {
    private ArrayList<Card> hand;
    private int handVal = 0;

    public Hand() {
        super(52); // creates a deck of 52 cards
        shuffle(); // shuffles the deck

        hand = new ArrayList<>();

        drawCard();
        drawCard();
    }

    public int getHandVal() {
        return handVal;
    }

    // Used at the beginning to have two cards in the hand and used when player
    // decides to hit
    public void drawCard() {
        Card card = getDeck().get(getSize() - 1);
        addCard(card);
        removeCard(getSize() - 1);
        handVal += card.getValue().getNum();
    }

    // adds cards to the arraylist upon call
    public void addCard(Card card) {
        hand.add(card);
    }

    // Returns a card at a specific index in the hand
    public Card getCard(int i) {
        return hand.get(i);
    }

    //
    public ArrayList<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        String printCards = "This is your hand: \n";
        for (int i = 0; i < hand.size(); i++) {
            printCards += hand.get(i).getValue() + " of " + hand.get(i).getSuit() + "\n";
        }
        printCards += "Total value of your hand is: " + handVal;
        return printCards;
    }

    @Override
    public int compareTo(Hand other) {
        if (this.handVal == other.handVal) {
            return 0;
        } else if (this.handVal < other.handVal) {
            return -1;
        } else {
            return 1;
        }
    }

}
