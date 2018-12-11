package Exam1.Wallet;
/*
 * Represents a wallet with dollar bills form various denominations
 */
public class Wallet {

	private int ones;
	private int fives;
	private int tens;
	private int twenties;
	private int hundreds;

	public Wallet(int ones, int fives, int tens, int twenties, int hundreds) {
		super();
		this.ones = ones;
		this.fives = fives;
		this.tens = tens;
		this.twenties = twenties;
		this.hundreds = hundreds;
	}
	
	/*
	 * Creates a new wallet with exactly the same bills as the parameter wallet
	 */
	public Wallet(Wallet w) {
		this.ones = w.ones;
		this.fives = w.fives;
		this.tens = w.tens;
		this.twenties = w.twenties;
		this.hundreds = w.hundreds;
	}
	
	/*
	 * Return true if and only if the parameter wallet contans exactly the same bills 
	 * as the target object.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Wallet)) { return false; }
		Wallet w = (Wallet) o;
		return ((w.ones == this.ones) &&
				(w.fives == this.fives) &&
				(w.tens == this.tens) &&
				(w.twenties == this.twenties) &&
				(w.hundreds == this.hundreds));
	}

	/*
	 * Creates a new wallet with the minimal number of bills necessary to represent the
	 * number of dollars received as a parameter
	 */
	public Wallet(int dollars) {
	if(dollars>= 100) {
		dollars-=100;
		this.hundreds+=1;
	}
	if(dollars>= 20) {
		dollars-=20;
		this.twenties+=1;
	}
	if(dollars>= 10) {
		dollars-=10;
		this.tens+=1;
	}
	if(dollars>= 5) {
		dollars-=5;
		this.fives+=1;
	}
	if(dollars>=1) {
		dollars-=1;
		this.ones+=1;
	}
	}

	// Getters 
	
	public int getOnes() { return ones; }
	public int getFives() { return fives; }
	public int getTens() { return tens; }
	public int getTwenties() { return twenties; }
	public int getHundreds() { return hundreds; }
	
	/*
	 * Returns the amount of money in dollars contained in the wallet
	 */
	public int getAmount() {
		return this.getHundreds()*100+this.getTwenties()*20+this.getTens()*10+ this.getFives()*5+ this.getOnes();
		
	}
	
	/*
	 * Modifies the target wallet to add the bills from the parameter wallet
	 */
	public Wallet add(Wallet w2) {
		this.hundreds+= w2.hundreds;
		this.twenties+= w2.twenties;
		this.tens+= w2.tens;
		this.fives+=w2.fives;
		this.ones+= w2.ones;
		
		// YOUR CODE HERE
		return this; // Dummy return. Please change and remove comment
	}

	/*
	 * Modifies the target wallet to add the minimal number of bills necessary to add
	 * the amount of money represented by the dollars parameter
	 */
	public Wallet add(int dollars) {
		// YOUR CODE HERE
		return null; // Dummy return. Please change and remove comment
	}

	/*
	 * Modifies the target wallet to contain the same amount as before, but using the minimal
	 * number of bills
	 */
	public Wallet minimize() {
		// YOUR CODE HERE
		return null; // Dummy return. Please change and remove comment
	}
}