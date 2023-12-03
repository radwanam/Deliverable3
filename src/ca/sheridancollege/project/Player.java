package ca.sheridancollege.project;

import java.util.Scanner;

public class Player extends User {
    private Hand hand;
    private double bet;

    public Player() {
        super("test");
        hand = new Hand();
    }

    @Override
    public void play() {
        Scanner inp = new Scanner(System.in);

        System.out.println("Please enter bet amount:");
        bet = inp.nextDouble();

        System.out.println(hand.toString() + "\nBet amount: " + bet);

        System.out.println("Do you want to hit or stand?");
        inp.next();
        String stance = inp.nextLine();

        while (!stance.toLowerCase().equals("hit") ||
                !stance.toLowerCase().equals("stand")) {
            System.out.println("Invalid input. Please enter hit or stand");
            inp.next();
            stance = inp.nextLine();
        }
        if (stance.toLowerCase().equals("hit")) {
            hand.drawCard();
            System.out.println(hand.toString() + "\n Bet amount: " + bet);
        } else if (stance.toLowerCase().equals("stand")) {
            System.out.println(hand.toString() + "\n Bet amount: " + bet);
        }

        inp.close();
    }

}
