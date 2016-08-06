package cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private Deck deck;
	List<Hand> players = new ArrayList<>();

	Scanner scanner = new Scanner(System.in);

	public Game() {
		this.deck = new Deck();
		Hand player = new Hand("Player");
		Hand dealer = new Hand("Dealer");
		players.add(player);
		players.add(dealer);
	}

	public void startGame() {
		initialDeal();

	}

	public void initialDeal() {

		System.out.println("DEBUG: Cards in deck:" + deck.cardsLeft());
		if (deck.cardsLeft() < 10) {
			this.deck = new Deck();
		}
		System.out.println("\nDeal? y/n");
		char choice = scanner.nextLine().charAt(0);

		if (choice == 'y' || choice == 'Y') {
			for (Hand hand : players) {
				hand.resetHand();
				hand.addCard(deck);
				hand.addCard(deck);
				System.out.println(hand.getName() + "'s hand: " + hand.getValueofHand());
				hand.displayHand();
				System.out.println();

			}
			if (isRoundOver()) {
				initialDeal();
			} else {
				promptForAction(players.get(0), players.get(1));
			}
		}else{
			System.out.println("\nThanks for playing.");
			System.exit(0);
		}
	}

	public void promptForAction(Hand p, Hand d) {
		System.out.println("\nHit(1) or Stay(2):");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1:
			p.addCard(deck);
			for (Hand hand : players) {
				System.out.println("\n\n" + hand.getName() + "'s hand: " + hand.getValueofHand());
				hand.displayHand();

			}
			if (isRoundOver()) {
				System.out.println("\n\n");
				initialDeal();
			} else {
				promptForAction(p, d);
			}
			break;
		case 2:
			dealerLogic();

		default:
			break;
		}
	}

	public void dealerLogic() {
		while (players.get(0).getValueofHand() > players.get(1).getValueofHand() && !(isRoundOver())) {
			System.out.println("Dealer drawing...");
			players.get(1).addCard(deck);
			players.get(1).displayHand();
			if (isRoundOver()) {
				initialDeal();
			}
		}
		System.out.println("\nDealer Wins.");
		initialDeal();
	}

	public boolean isRoundOver() {
		for (Hand hand : players) {
			if (isBlackjack(hand.getValueofHand())) {
				System.out.println("\n" + hand.getName() + " has blackjack.");
				return true;
			} else if (isBust(hand.getValueofHand())) {
				System.out.println("\n" + hand.getName() + " has busted.");
				return true;
			}

		}
		return false;
	}

	public boolean isBust(int valueOfHand) {
		return (valueOfHand > 21) ? true : false;
	}

	public boolean isBlackjack(int valueOfHand) {
		return (valueOfHand == 21) ? true : false;
	}

	// public void displayHands(){
	// System.out.println("====== Dealer's Hand ======");
	// System.out.println(players.get(1).getHand());
	// System.out.println("====== Player's Hand ======");
	// System.out.println(players.get(0).getHand());
	// }

}
