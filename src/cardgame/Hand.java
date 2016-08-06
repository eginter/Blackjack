package cardgame;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private String name;
	List<Card> hand = new ArrayList<>();

	public Hand(String name) {
		this.name = name;
	}
	
	public void addCard(Deck d) {
		hand.add(d.dealCard());
	}
	
	public int getValueofHand() {
		int value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}
	
	public void displayHand(){
		for (Card card : hand) {
			System.out.print(" " + card.getRank() + card.getSymbol());
		}
	}
	
	public void resetHand(){
		for (int i = 0; i < hand.size(); i++) {
			hand.clear();
		} 
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hand [hand=" + hand + "]";
	}
	
	

}
