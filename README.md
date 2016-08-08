# Blackjack
Skill Distillery Week 3 Project: Blackjack.

![alt tag] (https://github.com/eginter/Blackjack/blob/master/Screen%20Shot%202016-08-07%20at%206.39.07%20PM.png)


### Application goals: 
Demonstrate proper object-oriented design to model the card game blackjack. Practice building classes whose fields are Objects, pratice writing methods, use collection types to organize and manage data, and use conditionals to create game logic.

### Start-up:
* When run, the player will begin with $1000 to wager. Standard blackjack rules apply: https://www.jumerscasinohotel.com/files/Blackjack.pdf  

### Class Overview:
* Rank.java and Suit.java are enums used as fields for Card.java
* Card.java contains the constructor that Deck.java call upon to populate it's ArrayList with a full deck of 52 cards.
* GameRunner.java contains the main method to begin running the program. When it instantiates an instance of Game.java, Game.java calls for a new deck, makes a dealer Hand instance, and a player Hand instance. When startGame() is invoked on Game, the user is presented with the option to play.
* Hand.java holds each players cards, allowing the game to determine hand value, if the hand needs to account for ace's 1/11 value, and provides a means to display the held cards.
* Player.java serves only to contain and manipulate the users funds and wagers.

### Features:
* Accounts for ace's 1/11 values.
* User betting.
* Full-up ascii Gui.
* Hides dealers hole card.


### TODO: 
* Refactor classes to better seperate concerns.



                                         

