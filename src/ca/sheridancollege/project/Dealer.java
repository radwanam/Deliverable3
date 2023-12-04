package ca.sheridancollege.project;

import java.util.Scanner;

public class Dealer extends User {
    private Hand hand;
    private double bet;

    public Dealer(String name) {
        super(name);
        hand = new Hand();
    }

    public Hand getDealerHand() {
        return hand;
    }

    @Override
    public void play() {
        System.out.println("Dealer's first card: ");
        System.out.println(hand.getCard(0));
        if (hand.getHandVal() <= 16) {
            hand.drawCard();
        }
    }

}
