package Exam1.Fraction;
/*
 * Immutable Fraction class holds a rational number represented 
 * by an integer numerator and an integer denominator
 */
public class Fraction {

	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}


	/*
	 * Returns the greatest common divisor of a and b
	 */
	public int gcd(int a, int b) {
		if (a % b == 0) return b;
		return gcd(b, a%b);
	}

	/*
	 * Return a new fraction equivalent to the target fraction but expressed in 
	 * minimal terms. That is, the numerator and the denominator may not have a 
	 * gcd larger than one.
	 */
	public Fraction minimize() {
		int gcd= gcd(this.numerator, this.denominator);
		// YOUR CODE HERE
		return new Fraction(this.numerator/gcd, this.denominator/gcd); // Dummy return. Please change and remove this comment
	}

	/*
	 * Returns a new fraction representing the sum of the target and argument
	 * fractions.  The resulting fraction may not be expressed in minimal terms.
	 */
	public Fraction add(Fraction f2) {
			int den = this.denominator*f2.denominator;
			return new Fraction(this.numerator*f2.denominator+this.denominator*f2.numerator,den);
	// Dummy return. Please change and remove this comment
	}

	/*
	 * Returns a new fraction representing the subtraction of the argument
	 * fraction from the target fraction. The resulting fraction may not be 
	 * expressed in minimal terms.
	 */
	public Fraction subtract(Fraction f2) {
		int den = this.denominator*f2.denominator;
		return new Fraction(this.numerator*f2.denominator-this.denominator*f2.numerator,den);// Dummy return. Please change and remove this comment
	}

	/*
	 * Returns a new fraction representing the product of the target times
	 * the argument fraction.  The resulting fraction may not be expressed 
	 * in minimal terms.
	 */
	public Fraction multiply(Fraction f2) {
		// YOUR CODE HERE
		return new Fraction(this.numerator*f2.numerator,this.denominator*f2.denominator); // Dummy return. Please change and remove this comment
	}

	/*
	 * Returns a new fraction representing the division of the target fraction
	 * by the argument fraction.  Remember that a/b divided by c/d is equivalent
	 * to a/b times d/c.  The resulting fraction may not be expressed in minimal
	 * terms.
	 */
	public Fraction divide(Fraction f2) {
		// YOUR CODE HERE
		return new Fraction(this.numerator*f2.denominator,this.denominator*f2.numerator); // Dummy return. Please change and remove this comment
	}

}