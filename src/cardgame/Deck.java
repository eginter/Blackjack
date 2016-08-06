package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<Card>(52);

	public Deck() {
		this.deck = createDeck();
		shuffleDeck();
	}

	public List<Card> createDeck() {

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		shuffleDeck();
		return deck;
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	public Card dealCard() {
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}

	public int cardsLeft() {
		return deck.size();
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}
}
