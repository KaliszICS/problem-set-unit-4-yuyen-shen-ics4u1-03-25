import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yu-Yen, Shen
 * @version problem set Player class
 */
class Player{

    private String name;
    private int age;
    private ArrayList<Card> hand;

    /**
     * take in new information of the player and cards the player has
     * 
     * @param name the new name of the player that is going to replace the original player's name
     * @param age the new age of the player that is going to replace the original age of the player
     * @param cards the new cards that the player has that is going to replace the original cards
     */
    public Player(String name, int age, Card[] cards){
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>(Arrays.asList(cards));
    }


    /**
     * take in new information of the player with an empty list of cards
     * 
     * @param name the new name of the player that is going to replace the original player's name
     * @param age the new age of the player that is going to replace the original player's age
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();
    }

    /**
     * 
     * @return the name of the player
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return the age of the player
     */
    public int getAge() {
        return this.age;
    }

    /**
     * 
     * @return the cards that the player has
     */
    public Card[] getHand() {
        return this.hand.toArray(new Card[hand.size()]);
    }

    /**
     * 
     * @return the amount of cards that the player has
     */
    public int size() {
        return this.hand.size();
    }

    /**
     * draw a card if the card exists
     * 
     * @param card the card that is drawn from the deck to the player's hand
     */
    public void draw(Deck deck){
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            hand.add(drawnCard);
        }
    }

    /**
     * discards a card from the hand to the given deck's discard pile
     * 
     * @param card the card that is going to be removed from the hand of the player
     * @param discardPile the cards that are in the discard pile
     * @return true if the card exists in the hand
     * @return false if the card does not exist in the hand
     */
    public boolean discardCard(Card card, DiscardPile discardPile) {
        if (hand.remove(card)) {
            discardPile.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * return the specified card to the deck from the hand
     * 
     * @param card the card that is goint to be returned to the deck
     * @param deck the cards in the deck
     * @return true if the card exists in the hand
     * @return false if the card does not exist in the hand
     */
    public boolean returnCard(Card card, Deck deck) {
        if (hand.remove(card)) {
            deck.addCard(card);
            return true;
        }
        return false;
    }

    /**
     * print out the information of the player in the format of name, age, cards
     * 
     * @return name, age, a list of cards. 
     */
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < hand.size(); i++) {
            info.append(hand.get(i).toString());
            if (i < hand.size() - 1) {
                info.append(", ");
            }
        }
        System.out.println(this.name + ", " + this.age + ", " + info.toString() + ".");
        return this.name + ", " + this.age + ", " + info.toString() + ".";
    }

}