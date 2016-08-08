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
		for (Card card : this.hand) {
			value += card.getValue();
		}
		if (howManyAces() > 0) {
			if (value > 21) {
				value -= 10 * howManyAces();

			}
		}
		return value;
	}

	public void displayHand(boolean isHidden) {
		String cardDisplay1 = "", cardDisplay2 = "", cardDisplay3 = "", cardDisplay4 = "", cardDisplay5 = "",
				cardDisplay6 = "", cardDisplay7 = "";
		for (Card card : hand) {
			cardDisplay1 += " __________\t";
			cardDisplay2 += "/ " + card.getSymbol() + card.getRank().getStringValue() + "       |\t";
			cardDisplay3 += "|          |\t";
			cardDisplay4 += "|          |\t";
			cardDisplay5 += "|          |\t";
			cardDisplay6 += "|       " + card.getSymbol() + card.getRank().getStringValue() + " |\t";
			cardDisplay7 += "|_________//\t";
			if (isHidden) {
				cardDisplay1 += " __________\t";
				cardDisplay2 += "/          |\t";
				cardDisplay3 += "|          |\t";
				cardDisplay4 += "|          |\t";
				cardDisplay5 += "|          |\t";
				cardDisplay6 += "|          |\t";
				cardDisplay7 += "|_________//\t";
				break;
			}
		}
		System.out.print(cardDisplay1 + "\n");
		System.out.print(cardDisplay2 + "\n");
		System.out.print(cardDisplay3 + "\n");
		System.out.print(cardDisplay4 + "\n");
		System.out.print(cardDisplay5 + "\n");
		System.out.print(cardDisplay6 + "\n");
		System.out.print(cardDisplay7 + "\n");
	}

	public void resetHand() {
		for (int i = 0; i < hand.size(); i++) {
			hand.clear();
		}
	}

	public int howManyAces() {
		int aceCount = 0;
		for (Card card : this.hand) {
			if (card.getRank() == (Rank.ACE))
				aceCount++;
		}
		return aceCount;
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
