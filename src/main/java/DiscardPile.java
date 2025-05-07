import java.util.ArrayList;

/**
 * @author Yu-Yen, Shen
 * @version problem set DiscardPile class
 */
class DiscardPile{

    private ArrayList<Card> pile;

    /**
     * take in a list of cards to be in the pile
     * 
     * @param cardsArray a list of cards that is going to replace the original pile of cards
     */
    public DiscardPile(Card[] cardsArray){
        this.pile = cardsArray;
    }

    /**
     * generate an empty array of discard pile
     */
    public DiscardPile() {
        this.pile = new ArrayList<Card>();
    }

    /**
     * @return the cards in the discard pile
     */
    public Card[] getDiscardPile() {
        return this.pile;
    }

    /**
     * 
     * @return the amount of cards in the pile
     */
    public int size() {
        return piles.size();
    }

    /**
     * add a card into the pile
     *
     * @param card the card that is going to be added into the pile
     */
    public void addCard(Card card) {
        pile.add(card);
    }

    /**
     * return the card that is being removed from the pile
     * 
     * @param card the card that is going to be removed from the pile
     * @return the card that is being removed
     */
    public Card removeCard(Card card){
        if (pile.remove(card)) {
            return card;
        } else {
            return null;
        }
    }

    /**
     * copy the original pile and return it, then remove all cards in the pile
     * 
     * @return all cards in the pile
     */
    public Card[] removeAll() {
        ArrayList allCards = pile.clone();
        pile.clear();
        return allCards;
    }

    @Override
    public String toString() {
        if (pile.isEmpty()) {
            return "";
        }
        String result = "";
        for (int i = 0; i < pile.size(); i++) {
            if (i < pile.size() - 1) {
                result += ", ";
            } else {
                result += ".";
            }
        }
        return result;
    }
}