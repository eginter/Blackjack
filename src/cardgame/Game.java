package cardgame;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
	private Deck deck;
	private Player p;
	private double wager;
	private boolean isHidden = true;
	List<Hand> players = new ArrayList<>();

	Scanner scanner = new Scanner(System.in);

	public Game() {
		this.deck = new Deck(); // Generate a new shuffled deck.
		Hand player = new Hand("Player"); // Create player hand.
		Hand dealer = new Hand("Dealer"); // Create dealer hand.
		this.p = new Player(player, 1000);// Start player with $1000
		players.add(player);
		players.add(dealer);
	}

	public void startGame() {
		initialDeal();

	}

	public void initialDeal() {
		isHidden = true; // Hide dealers hole card.
		int choice = -1;
		if (deck.cardsLeft() < 10) { // If less than 10 card, fetch new deck.
			this.deck = new Deck();
		}
		welcomeMessage();
		while (choice != 1 || choice != 2) {
			try {
				choice = scanner.nextInt();

				if (choice != 2) {

					wager = p.placeWager();

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
			} catch (InputMismatchException e) {
				System.out.println("Not a valid choice.");
				scanner.nextLine();
			}
		}
	}

	public void promptForAction(Hand p, Hand d) {

		System.out.println("\nHit(1) or Stay(2):");
		int selection = scanner.nextInt();
		scanner.nextLine();
		switch (selection) {
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
			isHidden = false;
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
			isHidden = false;
			displayTable();
			System.out.println("Player's tied: Push.");
			p.setWallet(p.getWallet() + wager);
			initialDeal();
		}
		if (isRoundOver()) {
			initialDeal();

		}
		if (players.get(0).getValueofHand() > players.get(1).getValueofHand() && players.get(1).getValueofHand() < 22) {
			System.out.println("Player Wins.");
			if (isBlackjack(players.get(0))) {
				p.setWallet(p.getWallet() + (wager * (2 / 3)));
			}
			p.setWallet(p.getWallet() + (wager * 2));
		} else {
			isHidden = false;
			displayTable();
			System.out.println("Dealer Wins.");
		}
		initialDeal();

	}

	public boolean isRoundOver() {
		if (players.get(0).getHand().size() == 5 && players.get(0).getValueofHand() <= 21) {
			System.out.println("Player wins by 5 card rule.");
			p.setWallet(p.getWallet() + (wager * 2));
			return true;
		}
		for (Hand hand : players) {
			if (isBlackjack(hand)) {
				System.out.println(hand.getName() + " has blackjack.");
				return false;
			} else if (isBust(hand)) {
				System.out.println(hand.getName() + " has busted.");
				if (isBust(players.get(1))) {
					p.setWallet(p.getWallet() + (wager * 2));
				}
				return true;
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

	public void displayTable() {
		System.out.println("-----------------------------------------------------");
		System.out.println("                   Dealer's Hand: ");
		players.get(1).displayHand(isHidden);
		System.out.println();
		System.out.println(
				"                   Player's Hand: " + players.get(0).getValueofHand() + "\tWager: $" + this.wager);
		players.get(0).displayHand(false);
		System.out.println("Wallet: $" + p.getWallet());
		System.out.println("------------------------------------------------------");

	}

	public void welcomeMessage() {
		System.out.println("******************************************************");
		System.out.println("*      ~Welcome to Elijah's Extortion Emporium~      *");
		System.out.println("*                                                    *");
		System.out.println("*     1) Play Hand of blackjack                      *");
		System.out.println("*     2) Quit                                        *");
		System.out.println("*                                                    *");
		System.out.println("******************************************************");
	}
}
