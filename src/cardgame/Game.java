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
			}

			displayTable();
			if (isRoundOver()) {
				initialDeal();
			} else {
				promptForAction(players.get(0), players.get(1));
			}
		} else {
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
			displayTable();
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

		while (players.get(1).getValueofHand() < 17 && !(isRoundOver())) {
			System.out.println("Dealer drawing...");
			players.get(1).addCard(deck);
			displayTable();
		}
		if (players.get(0).getValueofHand() == players.get(1).getValueofHand()) {
			System.out.println("Player's tied: Push.");
			initialDeal();
		}
		if (isRoundOver()) {
			initialDeal();

		}
		if (players.get(0).getValueofHand() > players.get(1).getValueofHand()) {
			System.out.println("\nPlayer Wins.");
		} else {
			System.out.println("\nDealer Wins.");
		}
		initialDeal();

	}

	public boolean isRoundOver() {
		for (Hand hand : players) {
			if (isBlackjack(hand)) {
				System.out.println("\n" + hand.getName() + " has blackjack.");
				return false;
			} else if (isBust(hand)) {
				System.out.println("\n" + hand.getName() + " has busted.");
				return true;
			} else if (is21(hand)) {
				System.out.println("\n" + hand.getName() + " has 21.");
				return false;
			}
		}
		return false;

	}

	public boolean isBust(Hand hand) {
		return (hand.getValueofHand() > 21) ? true : false;
	}

	public boolean isBlackjack(Hand hand) {
		return (hand.getHand().size() == 2 && hand.getValueofHand() == 21) ? true : false;
	}

	public boolean is21(Hand hand) {
		return (hand.getHand().size() == 2 && hand.getValueofHand() == 21) ? true : false;
	}

	public void displayTable() {
		System.out.println("-----------------------------------------------------");
		System.out.println("                   Dealer's Hand: " + players.get(1).getValueofHand());
		players.get(1).displayHand();
		System.out.println();
		System.out.println();
		System.out.println("                   Player's Hand:" + players.get(0).getValueofHand());
		players.get(0).displayHand();
		System.out.println();
		System.out.println("------------------------------------------------------");

	}
}
