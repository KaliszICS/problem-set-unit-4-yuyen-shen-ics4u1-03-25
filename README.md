[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/qdezvRBW)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19406086)
# Card Game Framework - Creating a Game System - Due May 8th 11:59 PM

For this assignment, you will create a card game framework. The framework consists of four main classes: Card, Deck, DiscardPile, and Player. These classes will work together to provide the foundation for various card games.</br>

Your assignment will be to implement these classes according to the requirements. There will be 3 options that you can choose to code the assignment.</br>

**Option 1** (Up to 80%)</br>

Create the basic Card and Deck classes according to these specifications:</br>

## The Card class

The card class must take in three values as parameters: _name_, _suit_ and _value_</br>
_name_ will be the name of the card (for playing cards for example Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King)</br>
_suit_ will be the suit of a card (for a playing card for example Hearts, Spades, Diamonds, Clubs)</br>
_value_ will be a number value that represents if a card is worth more or less than another. This should be represented by a whole number.</br>

It Should also have getters for its name, value, and suit (no setters)</br>
A toString() method that will return its full form, e.g. "Queen of Diamonds" if the _name_ is "Queen" and the _suit_ is "Diamonds"</br>
An equals() method which checks if the two cards have the same name, suit and value.</br>

## The Deck class

Contains a deck of cards.</br>
It should have two constructors:</br>

The first constructor takes in an array of cards and sets it as the deck.</br>
The second Constructor is required that takes no parameters and generates an unshuffled deck of cards - Ace through King for each suit.</br>
An unshuffled deck should have the cards in the suit order of _hearts, clubs, diamonds, spades._ (This should be done in your constructor)</br>

The following methods are required:</br>

A size() method which returns the amount of cards in the deck.</br>
A draw() method that removes the top card from the deck and returns it. (The top of the deck is up to you. It should be consistent). If there are no cards left in the deck, return null.</br>
A shuffle() method that rearranges the order of the cards in the deck, use Google if you get stuck here to help you with this if needed (DO NOT COPY CODE).</br>

Here are some helpful hints to help you along the way:</br>

Remember to be consistent with which end of the deck is the "top".</br>
Make sure your shuffle method provides good randomization.</br>
Check for edge cases like empty decks or null cards.</br>

**Option 2** (Up to 90%)</br>

Create the same classes as above, plus the DiscardPile class, and add the following requirements to the Deck class.</br>

### Additional Deck methods:
An addCard(Card card) method that adds the provided card into the deck. Should not add the card if it is null.</br>
A reshuffle(Card[] cards) method that adds all of the cards in the provided card array into the deck. Shuffle the deck after adding them.</br>


## The DiscardPile class

Contains a discard pile of cards.</br>
It should have two constructors:</br>
The first constructor takes in an array of cards and sets it as the discard pile.</br>
The second Constructor is required that takes no parameters and generates an empty discard pile.</br>

The DiscardPile should have the following methods:</br>
A getter that returns the discard pile as an array of cards.</br>
A size() method which returns the amount of cards in the discard pile.</br>
An addCard(Card card) method that adds the provided card into the discard pile.</br>
A removeCard(Card card) method which removes the specified card from the discard pile and returns it. If the card does not exist, return null.</br>
A removeAll() method that returns an array of cards and removes them all from your discard pile. If there are no cards in the discard pile return an empty Card array.</br>
A toString() method that returns all of the cards in the format "Ace of hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades."</br>

**Option 3** (Up to 100%)</br>

Create the same classes as above, plus the Player class.</br>

## The Player class

Should have two constructors:</br>
The first Constructor should take a _name_ and _age_ and an array of cards which should be assigned to the hand.</br>
The second Constructor should take a _name_ and _age_ while creating a default empty hand of cards.</br>

Has getters for its name, age and hand (hand should return an array of cards).</br>

The following methods are required:</br>

A size() method which returns the size of the hand.</br>
A draw(Deck deck) method that adds a card from the deck to the hand of the player.</br>
A discardCard(Card card, DiscardPile discardPile) method that discards a card from the hand to the given deck's discard pile.</br>
Return true if the card exists in the hand. False otherwise.</br>
A returnCard(Card card, Deck deck) method that returns the specified card to the deck. Return true if the card exists in the hand. False otherwise.</br>
A toString() method that will print out their name, age, and hand of cards (e.g. "Mr. Kalisz, 99, Ace of hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades.")</br>



## If you're done early: Simple Card Game Implementation

Create a simple "High Card" game that:
1. Creates a deck and shuffles it
2. Creates two players with names provided by user input
3. Deals 5 cards to each player
4. Each round, both players play their highest value card
5. The player with the higher value card wins the round and gets a point
6. After 5 rounds, display the winner

---

There are no test cases for the Problem Set. You must test your own code and do so thoroughly. Think of all values that could break your code. Use output statements or create test cases to check values and make sure to test all extremes! Do not forget to comment and create javadocs for your code! Any AI use or copying of other people's code will be considered plagiarism and receive an automatic 0. This is a chance to apply what you ahve learned in this course. Good luck!
