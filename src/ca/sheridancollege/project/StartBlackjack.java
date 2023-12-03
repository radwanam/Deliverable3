package ca.sheridancollege.project;

public class StartBlackjack extends Game {

    public StartBlackjack() {
        super("Blackjack");
    }

    public static void main(String[] args) {
        StartBlackjack blackjack = new StartBlackjack();
        blackjack.play();
    }

    @Override
    public void play() {
        Player player = new Player();
        player.play();
        Dealer dealer = new Dealer();
        dealer.play();
    }

    public void declareWinner() {

    }
}
