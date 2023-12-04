package ca.sheridancollege.project;

import java.util.Scanner;

public class Player extends User {
    private Hand hand;
    private double bet;

    public Player(String name) {
        super(name);
        hand = new Hand();
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

    @Override
    public void play() {
        Scanner inp2 = new Scanner(System.in);

        System.out.println("Please enter bet amount:");
        bet = inp2.nextDouble();

        System.out.println(hand.toString() + "\nBet amount: " + bet);

        Scanner inp = new Scanner(System.in);
        System.out.println("Do you want to hit or stand?");
        String stance = inp.nextLine();

        while (!(stance.equalsIgnoreCase("hit")) && !(stance.equalsIgnoreCase("stand"))) {
            System.out.println("Invalid input. Please enter hit or stand");
            inp.next();
            stance = inp.nextLine();
        }

        while (hand.getHandVal() < 21 && stance.equalsIgnoreCase("hit")) {
            System.out.println("You chose to hit.\n");
            hand.drawCard();
            System.out.println("Card drew:");
            System.out.println(hand.getCard(hand.getHand().size() - 1).toString() + "\n");
            System.out.println(hand.toString() + "\nBet amount: " + bet);
            if (hand.getHandVal() < 21) {
                System.out.println("If you want to hit again, enter hit:");
                inp.next();
                stance = inp.nextLine();
            }
        }
        if (stance.equalsIgnoreCase("stand")) {
            System.out.println("You chose to stand.");
            System.out.println(hand.toString() + "\nBet amount: " + bet);
        }

        inp.close();
        inp2.close();
    }

}
