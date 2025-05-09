import java.util.ArrayList;

/**
 * @author Yu-Yen, Shen
 * @version problem set Deck class
 */
class Deck{
    
    private ArrayList<Card> cards;

    /**
     * take in a list of cards
     * 
     * @param cardsArray a list of cards that is taken in to replace the original cards
     */
    public Deck(Card[] cardsArray) {
        this.cards = new ArrayList<>(Arrays.asList(cardsArray));
    }

    /**
     * create a new arrayList of the cards that has all the possible card types
     */
    public Deck() {
        this.cards = new ArrayList<Card>();
        String[] suits = {"hearts", "clubs", "diamonds", "spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < names.length; j++){
                cards.add(new Card(names[J], suits[i]));
            }
        }
    }

    /**
     * 
     * @return how many cards are there in the deck - the size of the arrayList
     */
    public int size() {
        return cards.size();
    }

    /**
     * draw a card from the deck
     * 
     * @return the card that is drawn from the origianl cards we have
     */
    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    //I do not understand
    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    //I do not understand
    public void reshuffle(Card[] cardsToAdd) {
        for (Card card : cardsToAdd) {
            if (card != null) {
                cards.add(card);
            }
        }
        shuffle();
    }

}