package ca.sheridancollege.project;

public class StandardCard extends Card {

    public StandardCard(Suit s, Value v) {
        setValue(v);
        setSuit(s);
    }

    public String toString() {
        return getValue() + " of " + getSuit();
    }
}
