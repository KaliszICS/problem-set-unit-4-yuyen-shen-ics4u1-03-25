import java.util.ArrayList;

/**
 * @author Yu-Yen, Shen
 * @version problem set Player class
 */
class Player{

    private String name;
    private int age;
    private ArrayList<Card> hand;

    public Player(String name, int age, Card[] cards){
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>(Arrays.asList(cards));
    }

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public Card[] getHand() {
        return hand.toArray(new Card[0]);
    }

    public int size() {
        return hand.size();
    }

    public void draw(Deck cards){
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            hand.add(drawnCard);
        }
    }

    public boolean discardCard(Card card, DiscardPile discardPile) {
        if (hand.remove(card)) {
            discardPile.add(card);
            return true;
        }
        return false;
    }

    public boolean returnCard(Card card, Deck Cards) {
        if (hand.remove(card)) {
            deck.add(card);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String info = "";
        for (int i = 0; i < hand.size(); i++) {
            if (i < hand.size() - 1) {
                info += ", ";
            } else {
                info += ".";
            }
        }
        System.out.println(this.name + "," + this.age + "," + info);
        return this.name + "," + this.age + "," + info;
    }
}