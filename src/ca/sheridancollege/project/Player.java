package ca.sheridancollege.project;

import java.util.Scanner;

public class Player extends User {
    private Hand hand;
    private double bet;
    private GroupOfCards deck;

    public Player(String name, GroupOfCards deck) {
        super(name);
        this.deck = deck;
        hand = new Hand(deck);
    }

    public Hand getPlayerHand() {
        return hand;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(Double bet) {
        this.bet = bet;
    }

    public void play() {
        Scanner inp2 = new Scanner(System.in);

        System.out.println("Please enter bet amount:");
        bet = inp2.nextDouble();

        System.out.println(hand.toString() + "\nBet amount: " + bet);

        Scanner inp = new Scanner(System.in);

        System.out.println("Do you want to hit or stand?");
        String stance = inp.next();

        while (!(stance.equalsIgnoreCase("hit")) && !(stance.equalsIgnoreCase("stand"))) {
            System.out.println("Invalid input. Please enter hit or stand");
            inp.next();
            stance = inp.next();
        }

        while (hand.getHandVal() < 21 && stance.equalsIgnoreCase("hit")) {
            System.out.println("\nYou chose to hit.\n");
            hand.drawCard();
            System.out.println("Card drew:");
            System.out.println(hand.getCard(hand.getHand().size() - 1).toString() + "\n");
            System.out.println("This is your hand: \n" + hand.toString() + "\nBet amount: " + bet);
            System.out.println();
            if (hand.getHandVal() < 21) {
                System.out.println("If you want to hit again, enter hit. Otherwise, enter stand:");
                stance = inp.next();
                System.out.println();
            }
        }
        if (stance.equalsIgnoreCase("stand")) {
            System.out.println("\nYou chose to stand.");
            System.out.println("This is your hand: \n" + hand.toString() + "\nBet amount: " + bet);
            System.out.println();
        }

        inp.close();
        inp2.close();
    }

}
