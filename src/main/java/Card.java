/**
 * @author Yu-Yen, Shen
 * @version problem set Card class
 */
class Card{
    
    private String name;
    private String suit;
    private int value;

    /**
     * take in 3 parameters to a card
     * 
     * @param name the number/value of the card in words that is going to replace the original name
     * @param suit the suit of the card that is going to replace the original suit
     * @param value the value of the card in whole number that is going to replace the original value
     */
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * 
     * @return the name of the card
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return the suit of the card
     */
    public String getSuit() {
        return this.suit;
    }

    /**
     * 
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
    }

    /**
     * 
     * @return the name of the card + of + the suit of the card
     */
    public String toString() {
        return this.name + " of " + this.suit;
    }

    /**
     * compare the two cards
     * 
     * @return true if the two cards are equal 
     * @return false if the two cards are not equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card other = (Card) obj;
        return this.name.equals(other.name) &&
               this.suit.equals(other.suit) &&
               this.value == other.value;
    }

}