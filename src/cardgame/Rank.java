package cardgame;

public enum Rank {
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("T"), 
    JACK("J"), QUEEN("Q"), KING("K"), ACE("A");
    
	private String stringValue; 
    
    Rank(String stringValue){
    	this.stringValue = stringValue;
    	
    }
    public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

}
