import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class ProblemSetTest {

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
            Assertions.assertFalse(result2, "equals() should return false when names don't match");
            
            // Test equals method with different age
            boolean result3 = (boolean) equalsMethod.invoke(card1, card4);
            Assertions.assertFalse(result3, "equals() should return false when ages don't match");
            
            // Test equals method with different weight
            boolean result4 = (boolean) equalsMethod.invoke(card1, card5);
            Assertions.assertFalse(result4, "equals() should return false when weights don't match");
            
            // Test equals with null and different class
            boolean result5 = (boolean) equalsMethod.invoke(card1, new Object[]{null});
            Assertions.assertFalse(result5, "equals() should return false when comparing with null");
            
            boolean result6 = (boolean) equalsMethod.invoke(card1, "Not a cow");
            Assertions.assertFalse(result6, "equals() should return false when comparing with object of different class");
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
        Class<?> cardClass = Class.forName("Card"); // You need the Card class here
        Method addCardMethod = deckClass.getMethod("addCard", cardClass);
        assertEquals(void.class, addCardMethod.getReturnType(),
                "addCard(Card) should return void");
    } catch (ClassNotFoundException e) {
        fail("Deck or Card class does not exist: " + e.getMessage());
    } catch (NoSuchMethodException e) {
        fail("addCard(Card) method does not exist");
    }
}


    @Test
    public void testDeckAddCardFunctionality() {
    try {
        Class<?> deckClass = Class.forName("Deck");
        Class<?> cardClass = Class.forName("Card");

        // Create a Deck instance
        Object deck = deckClass.getConstructor().newInstance();

        // Create Card instances
        Constructor<?> cardConstructor = cardClass.getConstructor(String.class, String.class, int.class);
        Object card1 = cardConstructor.newInstance("Queen", "Diamonds", 12);
        Object card2 = cardConstructor.newInstance("Jack", "Spades", 11);

        // Add cards to the deck
        Method addCardMethod = deckClass.getMethod("addCard", cardClass);
        addCardMethod.invoke(deck, card1);
        addCardMethod.invoke(deck, card2);

        // Get the list of cards from the deck
        Method getCardsMethod = deckClass.getMethod("getCards");
        Object cardList = getCardsMethod.invoke(deck); // Should be a List<Card>

        // Use reflection to work with List
        Class<?> listClass = Class.forName("java.util.List");
        Method sizeMethod = listClass.getMethod("size");
        Method getMethod = listClass.getMethod("get", int.class);

        int size = (int) sizeMethod.invoke(cardList);
        assertEquals(2, size, "Deck should contain 2 cards");

        Object firstCard = getMethod.invoke(cardList, 0);
        Object secondCard = getMethod.invoke(cardList, 1);

        // Check the names of the cards
        Method getNameMethod = cardClass.getMethod("getName");

        String name1 = (String) getNameMethod.invoke(firstCard);
        String name2 = (String) getNameMethod.invoke(secondCard);

        assertEquals("Queen", name1, "First card should be Queen");
        assertEquals("Jack", name2, "Second card should be Jack");

    } catch (ClassNotFoundException e) {
        fail("One of the classes (Deck or Card) does not exist: " + e.getMessage());
    } catch (NoSuchMethodException e) {
        fail("A required method or constructor is missing: " + e.getMessage());
    } catch (Exception e) {
        fail("Unexpected exception during test: " + e.getMessage());
    }
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
        // Load DiscardPile and Card classes
        Class<?> discardPileClass = Class.forName("DiscardPile");
        Class<?> cardClass = Class.forName("Card");

        // Ensure toString returns a String
        Method toStringMethod = discardPileClass.getMethod("toString");
        assertEquals(String.class, toStringMethod.getReturnType(), 
                "toString() should return a String");

        // Create a DiscardPile instance
        Object discardPile = discardPileClass.getConstructor().newInstance();

        // Prepare card constructor and cards to add
        Constructor<?> cardConstructor = cardClass.getConstructor(String.class, String.class, int.class);

        Object card1 = cardConstructor.newInstance("Ace", "Hearts", 14);
        Object card2 = cardConstructor.newInstance("King", "Hearts", 13);
        Object card3 = cardConstructor.newInstance("Queen", "Hearts", 12);
        Object card4 = cardConstructor.newInstance("Jack", "Hearts", 11);
        Object card5 = cardConstructor.newInstance("9", "Spades", 9);

        Method addCardMethod = discardPileClass.getMethod("addCard", cardClass);

        addCardMethod.invoke(discardPile, card1);
        addCardMethod.invoke(discardPile, card2);
        addCardMethod.invoke(discardPile, card3);
        addCardMethod.invoke(discardPile, card4);
        addCardMethod.invoke(discardPile, card5);

        // Call toString on the discard pile
        String result = (String) toStringMethod.invoke(discardPile);

        String expected = "Ace of Hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades.";

        assertEquals(expected, result, 
                "toString() should return all cards in the correct formatted string");

    } catch (ClassNotFoundException e) {
        fail("Required class not found: " + e.getMessage());
    } catch (NoSuchMethodException e) {
        fail("Missing method or constructor: " + e.getMessage());
    } catch (Exception e) {
        fail("Unexpected exception during test: " + e.getMessage());
    }
}

     

    @Test
    public void testDiscardPileAddCardMethod() {
    try {
        Class<?> discardPileClass = Class.forName("DiscardPile");
        Class<?> cardClass = Class.forName("Card");
        
        // Corrected: Check if addCard(Card) exists
        Method addCardMethod = discardPileClass.getMethod("addCard", cardClass);
        assertEquals(void.class, addCardMethod.getReturnType(), 
                "addCard(Card) should return void");
    } catch (ClassNotFoundException e) {
        fail("Required class not found: " + e.getMessage());
    } catch (NoSuchMethodException e) {
        fail("addCard(Card) method does not exist");
    }
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
        // Load Player and Card classes
        Class<?> playerClass = Class.forName("Player");
        Class<?> cardClass = Class.forName("Card");

        // Verify Player's toString() exists
        Method toStringMethod = playerClass.getMethod("toString");
        assertEquals(String.class, toStringMethod.getReturnType(),
                "toString() should return a String");

        // Prepare Card constructor and make 5 cards
        Constructor<?> cardConstructor = cardClass.getConstructor(String.class, String.class, int.class);
        Object card1 = cardConstructor.newInstance("Ace", "Hearts", 1);
        Object card2 = cardConstructor.newInstance("King", "Hearts", 13);
        Object card3 = cardConstructor.newInstance("Queen", "Hearts", 12);
        Object card4 = cardConstructor.newInstance("Jack", "Hearts", 11);
        Object card5 = cardConstructor.newInstance("9", "Spades", 9);

        // Add cards to hand
        ArrayList<Object> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        // Create Player instance
        Constructor<?> playerConstructor = playerClass.getConstructor(String.class, int.class, ArrayList.class);
        Object playerInstance = playerConstructor.newInstance("Mr. Kalisz", 99, hand);

        // Expected output with period at the end
        String expected = "Mr. Kalisz, 99, Ace of Hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades.";

        // Invoke toString and compare
        String result = (String) toStringMethod.invoke(playerInstance);
        assertEquals(expected, result, "toString() output is incorrect");

    } catch (ClassNotFoundException e) {
        fail("Required class does not exist: " + e.getMessage());
    } catch (NoSuchMethodException e) {
        fail("Required constructor or method is missing: " + e.getMessage());
    } catch (Exception e) {
        fail("Exception during test execution: " + e.getMessage());
    }
}

      
}
