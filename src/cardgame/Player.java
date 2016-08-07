package cardgame;

import java.util.Scanner;

public class Player {

	private Hand h;
	private double wallet;
	Scanner scanner = new Scanner(System.in);

	public Player(Hand h, double wallet) {
		this.h = h;
		this.wallet = wallet;

	}

	public Hand getH() {
		return h;
	}

	public double placeWager() {
		System.out.println("You currently have $" + getWallet());
		System.out.print("How much do you want to bet?:");
		double wager = scanner.nextDouble();
		if (wallet <= 0) {
			System.out.println("You have no money, here's the door...");
			System.exit(0);
		}
		while (wager > wallet) {
			System.out.println("You don't have enough money for that... have you considered a payday loan?");
			System.out.print("How much do you want to bet?:");
			wager = scanner.nextDouble();
		}
		wallet -= wager;
		return wager;
	}

	public void setH(Hand h) {
		this.h = h;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

}
