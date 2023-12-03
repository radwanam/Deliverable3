package ca.sheridancollege.project;

import java.util.Scanner;

public class Dealer extends User {
    private Hand hand;
    private double bet;

    public Dealer() {
        super("test");
        hand = new Hand();
    }

    @Override
    public void play() {
        String stance;
        if (hand.getHandVal() <= 16) {
            hand.drawCard();
        }
    }

}
