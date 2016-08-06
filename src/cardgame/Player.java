package cardgame;

public class Player {

	private Hand h;
	private double wallet;
	
	public Player(Hand h, double wallet) {

		this.h = h;
		this.wallet = wallet;
		
	}

	public Hand getH() {
		return h;
	}
	
	public void placeWager(){
		
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
