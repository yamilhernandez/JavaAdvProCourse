package Exam1.RGBColor;
/*
 * Represents colors as a combination of integers 0-255 representing amounts
 * of red, green and blue colors.
 */
public class RGBColor {

	private long red;
	private long green;
	private long blue;

	public RGBColor(long red, long green, long blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	//Copy constructor
	public RGBColor(RGBColor c2) {
		// YOUR CODE HERE
		this.red = c2.red;
		this.green = c2.green;
		this.blue = c2.blue;
	}

	//Getters

	public long getRed() {
		return red;
	}

	public long getGreen() {
		return green;
	}

	public long getBlue() {
		return blue;
	}

	//Instance methods
	/*
	 * Returns true if and only if both the target and the parameter RGBColor's
	 * have exactly the same levels of red, green and blue.  Returns false otherwise.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof RGBColor)) { return false; }
		RGBColor c = (RGBColor) o;
		return ((c.red == this.red) &&
				(c.green == this.green) &&
				(c.blue == this.blue));
	}

	/*
	 *  Returns a new RGBColor with each of the levels of red, green and blue
	 *  are equal to the sums of the corresponding levels in the target and the
	 *  parameter RGBColor's.  If any of the sums for any of the levels turn out
	 *  to be larger than 255, the final for this level should be 255. That is, 
	 *  the final level should be the minimum of the sum and 255.
	 *  Check the JUnits for examples.
	 */

	public RGBColor add(RGBColor color2) {
		long red= this.red+color2.red;
		long blue= this.blue+color2.blue;
		long green= this.green+color2.green;
		if(red>255){
			red=255;
		}
		if(blue>255){
			blue=255;
		}
		if(green>255){
			green=255;
		}
		// YOUR CODE HERE
		return new RGBColor(red,green,blue);
	}

	/*
	 *  Returns a new RGBColor with each of the levels of red, green and blue
	 *  equal to the subtraction of the corresponding level in the parameter 
	 *  RGBColor  from the level in the target object.  If any of the subtractions
	 *  results negative for any of the levels, then the the final for this level 
	 *  should be 0. That is, the final level should be the maximum of the sum and 0.
	 */
	public RGBColor subtract(RGBColor color2) {
		long red= this.red-color2.red;
		long blue= this.blue-color2.blue;
		long green= this.green-color2.green;
		if(red<0){
			red=0;
		}
		if(blue<0){
			blue=0;
		}
		if(green<0){
			green=0;
		}
		// YOUR CODE HERE
		return new RGBColor(red,green,blue);	}
	
	/*
	 * Returns the complement RGBColor to the target RGBColor defined as follows.  The 
	 * complement RGBColor of a color with red=r, green=g and blue=b (r, g, and b integers
	 * from 0 to 255) is the RGBColor with red=(255-r), green=(255-g), blue=(255 - b).
	 */
	public RGBColor complement() {
		// YOUR CODE HERE
		long red= 255-this.red;
		long blue= 255-this.blue;
		long green= 255-this.green;
		return new RGBColor(red,green,blue);
	}

	/*
	 * Returns a new RGBColor that is darker by a percentage specified by the parameter
	 * than the target RGBColor.  To compute the new color, each of the levels reg, 
	 * green and blue should be decreased by the given percentage.  For instance, if a color
	 * with RGB levels (n,n,n) is darkened 10%, the the new color will end up being
	 * (n*(1-0.1), n*(1-0.1), n*(1-0.1)).
	 * See the JUnits for more examples.
	 */
	public RGBColor darker(double percentage) {
		long red= (long) ((long) this.red-Math.floor((this.red*(1-percentage))));
		long blue= (long) ((long) this.blue-Math.floor(this.blue*(1-percentage)));
		long green= (long) ((long) this.green-Math.floor(this.green*(1-percentage)));
		return new RGBColor(red,green,blue);
	}



}