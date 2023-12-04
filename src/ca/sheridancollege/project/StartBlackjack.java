package ca.sheridancollege.project;

public class StartBlackjack extends Game {
    private GroupOfCards sharedDeck = new GroupOfCards(52);
    private Dealer dealer = new Dealer("Dealer", sharedDeck);
    private Player player = new Player("Player1", sharedDeck);

    public StartBlackjack() {
        super("Blackjack");
    }

    public static void main(String[] args) {
        StartBlackjack blackjack = new StartBlackjack();
        blackjack.play();
        blackjack.declareWinner();
        System.out.println("Thanks for playing!");
    }

    @Override
    public void play() {
        dealer.revealFirstCard();
        player.play();
        dealer.play();
    }

    public void declareWinner() {
        // Player's hand greater than 21 - bust without looking at dealer's hand because
        // if both player and dealer bust, the player loses
        if (player.getPlayerHand().getHandVal() > 21) {
            System.out.println("Bust because your hand is greater than 21");
            System.out.println("You lose your wagered money.");
        }
        // Player gets blackjack and dealer doesn't - player wins
        else if (player.getPlayerHand().getHandVal() == 21 && dealer.getDealerHand().getHandVal() != 21) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString());
            System.out.println("Blackjack. You win!");
            System.out.println("Your earnings: $" + player.getBet() * 2);
        }
        // Dealers hand greater than 21 - bust
        else if (dealer.getDealerHand().getHandVal() > 21) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString());
            System.out.println("Dealer busts. You win!");
            System.out.println("Your earnings: $" + player.getBet() * 1.5);
        }
        // Player's hand closer to 21 than dealer's hand
        else if (player.getPlayerHand().compareTo(dealer.getDealerHand()) == 1) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString());
            System.out.println("Your hand is better than dealer's hand, you win!");
            System.out.println("Your earnings: $" + player.getBet() * 1.5);
        }
        // Player's hand equal to dealer's hand
        else if (player.getPlayerHand().compareTo(dealer.getDealerHand()) == 0) {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString());
            System.out.println("Your hand is equal to dealer's hand. It's a draw");
            System.out.println("You get back your bet amount of $" + player.getBet());
        }
        // Dealer's hand closer to 21 than player's hand
        else {
            System.out.println("Dealer's hand:");
            System.out.println(dealer.getDealerHand().toString());
            System.out.println("Dealer's hand is better than your hand");
            System.out.println("You lose your wagered money. Better luck next time");
        }
    }
}