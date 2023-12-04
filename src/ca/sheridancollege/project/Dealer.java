package ca.sheridancollege.project;

public class Dealer extends User {
    private Hand hand;
    private GroupOfCards deck;

    public Dealer(String name, GroupOfCards deck) {
        super(name);
        this.deck = deck;
        hand = new Hand(deck);
    }

    public Hand getDealerHand() {
        return hand;
    }

    public void revealFirstCard() {
        System.out.println("Dealer's first card: ");
        System.out.println(hand.getCard(0) + "\n");
    }

    @Override
    public void play() {
        while (hand.getHandVal() <= 16) {
            hand.drawCard();
        }
    }

}
