//don't forget to import anything else you need (ArrayLists, HashMaps, Scanners, etc)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

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
   
   //Card class: equals

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


   //Deck class: size, draw, shuffle, addCard, reshuffle

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

   //DiscardPile class: size, addCard, removeCard, removeAll, toString

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
           /* Constructor<?> constructor = discardPileClass.getConstructor(ArrayList<Card>.class);
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
            */
    }

   //Player class: size, draw, discardCard, returnCard, toString
   
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
            /* Constructor<?> constructor = playerClass.getConstructor(String.class, int.class, ArrayList<Card>.class);
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
            */
        }
      
    }
      

}
