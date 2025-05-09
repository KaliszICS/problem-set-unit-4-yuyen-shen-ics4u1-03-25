//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProblemSetTest {

   //Create your tests here if you want any

   /*

   //Example Test
   
   @Test
   public void exampleTest()
   {
      Cat cat = new Cat();
      assertEquals("whiskers", cat.getName());
   }
   */

   @BeforeEach
    void reset() {
        player = new Player("TestPlayer");
        deck = new Deck();
        card1 = new Card("Hearts", "A");
        card2 = new Card("Spades", "K");
    }

   @Test
   public void testCardClassExists() {
       try {
           Class.forName("Card");
           assertTrue(true);
       } catch (ClassNotFoundException e) {
           fail("Card class does not exist");
       }
   }

   @Test
   public void testCardConstructor() {
      try {
            Class<?> cardClass = Class.forName("Card");
            Constructor<?> constructor = cardClass.getConstructor(String.class, String.class, int.class);
            assertNotNull(constructor, "Constructor with (String, String, int) parameters should exist");
      } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
      } catch (NoSuchMethodException e) {
            fail("Card constructor with (String, String, int) parameters does not exist");
      }
   }

   @Test
    public void testGetValueMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method getValueMethod = cardClass.getMethod("getValue");
            assertEquals(int.class, getValueMethod.getReturnType(), 
                    "getValue() should return int");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getValue() method does not exist in Card class");
        }
    }

    @Test
    public void testGetCardNameMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method getNameMethod = cardClass.getMethod("getName");
            assertEquals(String.class, getNameMethod.getReturnType(), 
                    "getName() should return String");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getName() method does not exist in Card class");
        }
    }

    @Test
    public void testGetSuitMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method getSuitMethod = cardClass.getMethod("getSuit");
            assertEquals(String.class, getSuitMethod.getReturnType(), 
                    "getSuit() should return String");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getSuit() method does not exist in Card class");
        }
    }

    @Test
    public void testCardToStringMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method toStringMethod = cardClass.getMethod("toString");
            assertEquals(String.class, toStringMethod.getReturnType(), 
                    "toString() should return String");
            
            // Create a card instance if the class exists
            Constructor<?> constructor = cardClass.getConstructor(String.class, String.class, int.class);
            Object card = constructor.newInstance("Queen", "Diamonds", 12);
            
            String result = (String) toStringMethod.invoke(card);
            assertEquals("Queen of Diamonds", result, 
                    "toString() should return name, suit, and value in the specified format");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("toString() method does not exist or constructor is not properly defined in Card class");
        } catch (Exception e) {
            fail("Error testing toString(): " + e.getMessage());
        }
    }

    @Test
    public void testEqualsMethod() {
        try {
            Class<?> cardClass = Class.forName("Card");
            Method equalsMethod = cardClass.getMethod("equals", Object.class);
            assertEquals(boolean.class, equalsMethod.getReturnType(), 
                    "equals() should return boolean");
            
            // Create crd instances if the class exists
            Constructor<?> constructor = cardClass.getConstructor(String.class, String.class, int.class);
            Object card1 = constructor.newInstance("Ace", "Spades", 1);
            Object card2 = constructor.newInstance("Ace", "Spades", 1);
            Object card3 = constructor.newInstance("3", "Spades", 1);
            Object card4 = constructor.newInstance("Ace", "Clubs", 1);
            Object card5 = constructor.newInstance("Ace", "Spades", 5);
            
            // Test equals method with all attributes the same
            boolean result1 = (boolean) equalsMethod.invoke(card1, card2);
            assertTrue(result1, "equals() should return true when all attributes match");
            
            // Test equals method with different name
            boolean result2 = (boolean) equalsMethod.invoke(card1, card3);
            assertFalse(result2, "equals() should return false when names don't match");
            
            // Test equals method with different age
            boolean result3 = (boolean) equalsMethod.invoke(card1, card4);
            assertFalse(result3, "equals() should return false when ages don't match");
            
            // Test equals method with different weight
            boolean result4 = (boolean) equalsMethod.invoke(card1, card5);
            assertFalse(result4, "equals() should return false when weights don't match");
            
            // Test equals with null and different class
            boolean result5 = (boolean) equalsMethod.invoke(card1, new Object[]{null});
            assertFalse(result5, "equals() should return false when comparing with null");
            
            boolean result6 = (boolean) equalsMethod.invoke(card1, "Not a cow");
            assertFalse(result6, "equals() should return false when comparing with object of different class");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("equals(Object) method does not exist in Card class");
        } catch (Exception e) {
            fail("Error testing equals(): " + e.getMessage());
        }
    }


   @Test
   public void testDeckClassExists() {
       try {
           Class.forName("Deck");
           assertTrue(true);
       } catch (ClassNotFoundException e) {
           fail("Deck class does not exist");
       }
   }

   @Test
   public void testDeckConstructor1() {
       try {
           Class<?> deckClass = Class.forName("Deck");
           Constructor<?> constructor = deckClass.getConstructor(Card[].class);
           assertNotNull(constructor, "Constructor with (Card[]) parameters should exist");
       } catch (ClassNotFoundException e) {
           fail("Deck class does not exist");
       } catch (NoSuchMethodException e) {
           fail("Deck constructor with (Card[]) parameters does not exist");
       }
   }

   @Test
   public void testDeckConstructor2() {
       try {
           Class<?> deckClass = Class.forName("Deck");
           Constructor<?> constructor = deckClass.getConstructor();
           assertNotNull(constructor, "Constructor with () parameters should exist");
       } catch (ClassNotFoundException e) {
           fail("Deck class does not exist");
       } catch (NoSuchMethodException e) {
           fail("Deck constructor with () parameters does not exist");
       }
   }

    @Test
    public void testDeckAddCardMethod() {
        try {
            Class<?> deckClass = Class.forName("Deck");
            Method addCardMethod = deckClass.getMethod("addCard", deckClass);
            assertEquals(void.class, addCardMethod.getReturnType(), 
                    "addCard(Deck) should return void");
        } catch (ClassNotFoundException e) {
            fail("Deck class does not exist");
        } catch (NoSuchMethodException e) {
            fail("addCard(Deck) method does not exist");
        }
    }

    @Test
    public void testDeckAddCardFunctionality() {
        try {
            Class<?> deckClass = Class.forName("Deck");
            Constructor<?> constructor = deckClass.getConstructor(
                String.class, String.class, int.class);
            
            // Create a main card
            Object card1 = constructor.newInstance("Queen", "Diamonds", 12);
            
            // Create cards
            Object card2 = constructor.newInstance("Jack", "Spades", 11);
            Object card3 = constructor.newInstance("2", "Hearts", 2);
            
            // Add cards
            Method addCardMethod = deckClass.getMethod("addCard", deckClass);
            Method getCardsMethod = deckClass.getMethod("getCards");
            
            // Add first card and check
            addCardMethod.invoke(card1, card2);
            Object cardsAfterOne = getCardsMethod.invoke(card1);
            
            assertNotNull(cardsAfterOne, "getCards() should not return null");
            assertEquals(1, Array.getLength(cardsAfterOne), 
                    "After adding one card, getCards() should return an array of length 1");
            
            // Add second card and check
            addCardMethod.invoke(card1, card3);
            Object cardsAfterTwo = getCardsMethod.invoke(card1);
            
            assertNotNull(cardsAfterTwo, "getCards() should not return null");
            assertEquals(2, Array.getLength(cardsAfterTwo), 
                    "After adding two cards, getCards() should return an array of length 2");
            
            // Check that the cards array contains the correct cards
            Method getNameMethod = deckClass.getMethod("getName");
            
            Object firstCard = Array.get(cardsAfterTwo, 0);
            Object secondCard = Array.get(cardsAfterTwo, 1);
            
            String firstCardName = (String) getNameMethod.invoke(firstCard);
            String secondCardName = (String) getNameMethod.invoke(secondCard);
            
            assertEquals("Queen", firstCardName, "First card should be Queen");
            assertEquals("Jack", secondCardName, "Second card should be JJack");
        } catch (ClassNotFoundException e) {
            fail("Deck class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Required method does not exist: " + e.getMessage());
        } catch (Exception e) {
            fail("Error testing addCard functionality: " + e.getMessage());
        }
    }

    @BeforeEach
    void setUp() {
        deck = new Deck();
        card1 = new Card("Hearts", "A");
        card2 = new Card("Spades", "K");
    }

    @Test
    void testAddCard() {
        deck.addCard(card1);
        assertEquals(1, deck.size());
    }

    @Test
    void testIsEmptyTrue() {
        assertTrue(deck.isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        deck.addCard(card1);
        assertFalse(deck.isEmpty());
    }

    @Test
    void testSizeAfterMultipleAdditions() {
        deck.addCard(card1);
        deck.addCard(card2);
        assertEquals(2, deck.size());
    }

    @Test
    void testShuffleChangesOrder() {
        // Add 52 unique cards
        for (int i = 0; i < 52; i++) {
            deck.addCard(new Card("Suit" + i, "Value" + i));
        }

        // Store original order
        String[] originalOrder = deck.toString().split(","); // simplistic
        deck.shuffle();
        String[] shuffledOrder = deck.toString().split(",");

        boolean orderChanged = false;
        for (int i = 0; i < originalOrder.length; i++) {
            if (!originalOrder[i].equals(shuffledOrder[i])) {
                orderChanged = true;
                break;
            }
        }
        assertTrue(orderChanged, "Shuffling should change the order");
    }

    @Test
    void testDeckPreservesOrderWithoutShuffle() {
        deck.addCard(card1);
        deck.addCard(card2);
        assertEquals(card1, deck.drawCard());
        assertEquals(card2, deck.drawCard());
    }

    @Test
    void testDeckAllowsDuplicateCards() {
        deck.addCard(card1);
        deck.addCard(card1);
        assertEquals(2, deck.size());
        assertEquals(card1, deck.drawCard());
        assertEquals(card1, deck.drawCard());
    }

    @Test
    void testDeckSizeZeroAfterAllDrawn() {
        deck.addCard(card1);
        deck.addCard(card2);
        deck.drawCard();
        deck.drawCard();
        assertEquals(0, deck.size());
    }


   @Test
   public void testDiscardPileClassExists() {
       try {
           Class.forName("DiscardPile");
           assertTrue(true);
       } catch (ClassNotFoundException e) {
           fail("DiscardPile class does not exist");
       }
   }

   @Test
   public void testDiscardPileConstructor1() {
       try {
           Class<?> discardPileClass = Class.forName("DiscardPile");
           Constructor<?> constructor = discardPileClass.getConstructor(Card[].class);
           assertNotNull(constructor, "Constructor with (Card[]) parameters should exist");
       } catch (ClassNotFoundException e) {
           fail("DiscardPile class does not exist");
       } catch (NoSuchMethodException e) {
           fail("DiscardPile constructor with (Card[]) parameters does not exist");
       }
   }

   @Test
   public void testDiscardPileConstructor2() {
       try {
           Class<?> discardPileClass = Class.forName("DiscardPile");
           Constructor<?> constructor = discardPileClass.getConstructor();
           assertNotNull(constructor, "Constructor with () parameters should exist");
       } catch (ClassNotFoundException e) {
           fail("DiscardPile class does not exist");
       } catch (NoSuchMethodException e) {
           fail("DiscardPile constructor with () parameters does not exist");
       }
   }

   @Test
    public void testGetDiscardPileMethod() {
        try {
            Class<?> discardPileClass = Class.forName("DiscardPile");
            Method getDiscardPileMethod = discardPileClass.getMethod("getDiscardPile");
            assertEquals(Card[].class, getDiscardPileMethod.getReturnType(), 
                    "getDiscardPile() should return Card[]");
        } catch (ClassNotFoundException e) {
            fail("DiscardPile class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getDiscardPile() method does not exist in DiscardPile class");
        }
    }

    @Test
    public void testDiscardPileToStringMethod() {
        try {
            Class<?> discardPileClass = Class.forName("DiscardPile");
            Method toStringMethod = discardPileClass.getMethod("toString");
            assertEquals(String.class, toStringMethod.getReturnType(), 
                    "toString() should return String");
            
            // Create a pile instance if the class exists
            Constructor<?> constructor = discardPileClass.getConstructor(ArrayList<Card>.class);
            Object pile = constructors.newInstance("Queen", "Diamonds", 12);
            
            String result = (String) toStringMethod.invoke(card);
            assertEquals("Queen of Diamonds", result, 
                    "toString() should return name, suit, and value in the specified format");
        } catch (ClassNotFoundException e) {
            fail("DiscardPile class does not exist");
        } catch (NoSuchMethodException e) {
            fail("toString() method does not exist or constructor is not properly defined in DiscardPile class");
        } catch (Exception e) {
            fail("Error testing toString(): " + e.getMessage());
        }
            
    }

    @Test
    public void testDiscardPileAddCardMethod() {
        try {
            Class<?> discardPileClass = Class.forName("DiscardPile");
            Method addCardMethod = discardPileClass.getMethod("addCard", discardPileClass);
            assertEquals(void.class, addCardMethod.getReturnType(), 
                    "addCard(DiscardPile) should return void");
        } catch (ClassNotFoundException e) {
            fail("DiscardPile class does not exist");
        } catch (NoSuchMethodException e) {
            fail("addCard(DiscardPile) method does not exist");
        }
    }

     @BeforeEach
    void setPileUp() {
        discardPile = new DiscardPile();
        card1 = new Card("Hearts", "2");
        card2 = new Card("Spades", "J");
    }

    @Test
    void testPeekTopCardWithoutAdding() {
        assertNull(discardPile.peekTopCard());
    }

    @Test
    void testPeekTopCardAfterMultipleAdditions() {
        discardPile.addCard(card1);
        discardPile.addCard(card2);
        assertEquals(card2, discardPile.peekTopCard());
    }

    @Test
    void testDiscardPileAcceptsNullCard() {
        discardPile.addCard(null);
        assertNull(discardPile.peekTopCard());
    }

    @Test
    void testAddMultipleCardsAndPeekEachTime() {
        discardPile.addCard(card1);
        assertEquals(card1, discardPile.peekTopCard());

        discardPile.addCard(card2);
        assertEquals(card2, discardPile.peekTopCard());
    }

    @Test
    void testTopCardNotAffectedByEarlierCards() {
        discardPile.addCard(card1);
        discardPile.addCard(card2);
        assertNotEquals(card1, discardPile.peekTopCard());
    }
   
   @Test
   public void testPlayerClassExists() {
       try {
           Class.forName("Player");
           assertTrue(true);
       } catch (ClassNotFoundException e) {
           fail("Player class does not exist");
       }
   }

   @Test
   public void testPlayerConstructor1() {
       try {
           Class<?> playerClass = Class.forName("Player");
           Constructor<?> constructor = playerClass.getConstructor(String.class, int.class, Card[].class);
           assertNotNull(constructor, "Constructor with (String, int, Card[]) parameters should exist");
       } catch (ClassNotFoundException e) {
           fail("Player class does not exist");
       } catch (NoSuchMethodException e) {
           fail("Player constructor with (String, int, Card[]) parameters does not exist");
       }
   }

   @Test
   public void testPlayerConstructor2() {
       try {
           Class<?> playerClass = Class.forName("Player");
           Constructor<?> constructor = playerClass.getConstructor(String.class, int.class);
           assertNotNull(constructor, "Constructor with (String, int) parameters should exist");
       } catch (ClassNotFoundException e) {
           fail("Player class does not exist");
       } catch (NoSuchMethodException e) {
           fail("Player constructor with (String, int) parameters does not exist");
       }
   }

   @Test
    public void testGetPlayerNameMethod() {
        try {
            Class<?> playerClass = Class.forName("Player");
            Method getNameMethod = playerClass.getMethod("getName");
            assertEquals(String.class, getNameMethod.getReturnType(), 
                    "getName() should return String");
        } catch (ClassNotFoundException e) {
            fail("Player class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getName() method does not exist in Player class");
        }
    }

    @Test
    public void testGetAgeMethod() {
        try {
            Class<?> playerClass = Class.forName("Player");
            Method getAgeMethod = playerClass.getMethod("getAge");
            assertEquals(int.class, getAgeMethod.getReturnType(), 
                    "getAge() should return int");
        } catch (ClassNotFoundException e) {
            fail("Player class does not exist");
        } catch (NoSuchMethodException e) {
          fail("getAge() method does not exist in Player class");
        }
    }

    @Test
    public void testGetHandMethod() {
        try {
            Class<?> playerClass = Class.forName("Player");
            Method getHandMethod = playerClass.getMethod("getHand");
            assertEquals(Card[].class, getHandMethod.getReturnType(), 
                    "getHand() should return Card[]");
        } catch (ClassNotFoundException e) {
            fail("Player class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getHand() method does not exist in Player class");
        }
    }

    @Test
    public void testPlayerToStringMethod() {
        try {
            Class<?> playerClass = Class.forName("Player");
            Method toStringMethod = playerClass.getMethod("toString");
            assertEquals(String.class, toStringMethod.getReturnType(), 
                    "toString() should return String");
            
            // Create a player instance if the class exists
            Constructor<?> constructor = playerClass.getConstructor(String.class, int.class, ArrayList<Card>.class);
            Object card = constructor.newInstance("Mr. Kalisz", 99, {"Ace of Hearts"});
            
            String result = (String) toStringMethod.invoke(card);
            assertEquals("Queen of Diamonds", result, 
                    "toString() should return name, suit, and value in the specified format");
        } catch (ClassNotFoundException e) {
            fail("Card class does not exist");
        } catch (NoSuchMethodException e) {
            fail("toString() method does not exist or constructor is not properly defined in Card class");
        } catch (Exception e) {
            fail("Error testing toString(): " + e.getMessage());
        }
      
    }

    @Test
    void testHasCard() {
        player.addCardToHand(card1);
        assertTrue(player.hasCard(card1));
        assertFalse(player.hasCard(card2));
    }

    @Test 
    void testGetHand() {    
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        List<Card> hand = player.getHand();
        assertEquals(2, hand.size());
        assertTrue(hand.contains(card1));
        assertTrue(hand.contains(card2));
    }

    @Test
    void testGetName() {
        assertEquals("TestPlayer", player.getName());
    }

    @Test
    void testAddCardToHand() throws Exception {
        player.addCardToHand(card1);

        Field handField = Player.class.getDeclaredField("hand");
        handField.setAccessible(true);
        List<Card> hand = (List<Card>) handField.get(player);

        assertTrue(hand.contains(card1));
    }

    @Test
    void testRemoveCardFromHand() throws Exception {
        player.addCardToHand(card1);
        player.removeCardFromHand(card1);

        Field handField = Player.class.getDeclaredField("hand");
        handField.setAccessible(true);
        List<Card> hand = (List<Card>) handField.get(player);

        assertFalse(hand.contains(card1));
    }

    @Test
    void testDrawCard() {
        deck.addCard(card1);
        player.drawCard(deck);

        assertTrue(player.hasCard(card1));
        assertEquals(0, deck.size());
    }

    @Test
    void testDrawCardFromEmptyDeck() {
        assertEquals(0, deck.size());
        player.drawCard(deck);

        assertEquals(0, player.getHand().size()); // nothing added
    }

    @Test
    void testPlayCard() {
        player.addCardToHand(card1);
        Card played = player.playCard(card1);

        assertEquals(card1, played);
        assertFalse(player.hasCard(card1));
    }

    @Test
    void testPlayCardNotInHand() {
        Card played = player.playCard(card2);
        assertNull(played);
    }

    @Test
    void testRemoveCardNotInHand() throws Exception {
        player.removeCardFromHand(card1); // should not throw
        Field handField = Player.class.getDeclaredField("hand");
        handField.setAccessible(true);
        List<Card> hand = (List<Card>) handField.get(player);
        assertFalse(hand.contains(card1));
    }

      
}
