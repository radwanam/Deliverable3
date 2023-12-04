/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player and Dealer in the game. users have an
 * identifier,
 * which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class User {

    private String name; // the unique name for this user

    /**
     * A constructor that allows you to set the user's unique ID
     *
     * @param name the unique ID to assign to the user.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the userID is unique
     *
     * @param name the user name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The method to be overridden when you subclass the user class with your
     * specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();

}
