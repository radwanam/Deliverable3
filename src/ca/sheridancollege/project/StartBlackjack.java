package ca.sheridancollege.project;

public class StartBlackjack extends Game {
    private Dealer dealer = new Dealer("Dealer");
    private Player player = new Player("Player");

    public StartBlackjack() {
        super("Blackjack");
    }

    public static void main(String[] args) {
        StartBlackjack blackjack = new StartBlackjack();
        blackjack.play();
        blackjack.declareWinner();
    }

    @Override
    public void play() {
        player.play();
        dealer.play();
    }

    public void declareWinner() {
        dealer.play();
        if (player.getPlayerHand().getHandVal() > 21) {
            System.out.println("Bust because your hand is greater than 21");
        } else if (player.getPlayerHand().compareTo(dealer.getDealerHand()) == 1) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString());
            System.out.println("Your hand is better than dealer's hand, you win!");
            System.out.println("Your earnings: " + player.getBet() * 1.5);
        } else if (player.getPlayerHand().compareTo(dealer.getDealerHand()) == 0) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString());
            System.out.println("Your hand is equal to dealer's hand. It's a draw");
            System.out.println("You get back your bet amount of" + player.getBet());
        } else {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString());
            System.out.println("Dealer's hand is better than your hand");
            System.out.println("You lose your wagered money. Better luck next time");
        }
    }
}