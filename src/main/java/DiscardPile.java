import java.util.ArrayList;

/**
 * @author Yu-Yen, Shen
 * @version problem set DiscardPile class
 */
class DiscardPile{

    private ArrayList<Card> pile;

    public DiscardPile(Card[] cardsArray){
        this.pile = cardsArray;
    }

    public DiscardPile() {
        this.pile = new ArrayList<Card>();
    }

    public Card[] getDiscardPile() {
        return pile.toArray(new Card[0]);
    }

    public int size() {
        return piles.size();
    }

    public void addCard(Card card) {
        pile.add(card);
    }

    public Card removeCard(Card card){
        if (pile.remove(card)) {
            return card;
        } else {
            return null;
        }
    }

    public Card[] removeAll() {
        Card[] allCards = pile.toArray(new Card[0]);
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