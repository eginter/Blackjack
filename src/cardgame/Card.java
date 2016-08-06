package cardgame;

import java.util.HashMap;
import java.util.Map;

public class Card {
	private Rank rank;
	private Suit suit;
	private int value;
	private char symbol;

	Map<Rank, Integer> valueMap = new HashMap<>(12);
	Map<Suit, Character> unicodeMap = new HashMap<>(4);

	public void cardValues() {

		valueMap.put(Rank.TWO, 2);
		valueMap.put(Rank.THREE, 3);
		valueMap.put(Rank.FOUR, 4);
		valueMap.put(Rank.FIVE, 5);
		valueMap.put(Rank.SIX, 6);
		valueMap.put(Rank.SEVEN, 7);
		valueMap.put(Rank.EIGHT, 8);
		valueMap.put(Rank.NINE, 9);
		valueMap.put(Rank.TEN, 10);
		valueMap.put(Rank.JACK, 10);
		valueMap.put(Rank.QUEEN, 10);
		valueMap.put(Rank.KING, 10);
		valueMap.put(Rank.ACE, 11);
		
		unicodeMap.put(Suit.HEARTS, '\u2665');
		unicodeMap.put(Suit.SPADES, '\u2660');
		unicodeMap.put(Suit.CLUBS, '\u2663');
		unicodeMap.put(Suit.DIAMONDS, '\u2666');
	}

	public Card(Rank r, Suit s) {
		cardValues();
		rank = r;
		suit = s;
		this.setValue(valueMap.get(rank));
		this.setSymbol(unicodeMap.get(suit));
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return (rank + " of " + suit).toLowerCase();
	}
}
