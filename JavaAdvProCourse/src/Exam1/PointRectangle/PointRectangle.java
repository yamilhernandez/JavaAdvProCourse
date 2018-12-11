package Exam1.PointRectangle;
import java.awt.Point;
import java.awt.Rectangle;

/*
 * Represents a rectangle by an upper-left and a lower-right points
 */
public class PointRectangle {
	
	private Point upperLeft;
	private Point lowerRight;
	
	//Constructors
	
	public PointRectangle(Point upperLeft, Point lowerRight) {
		super();
		this.upperLeft = upperLeft;
		this.lowerRight = lowerRight;
	}
	
	/*
	 * Builds a PointRectangle with the same location and dimensions as the
	 * parameter rectangle.
	 */
	public PointRectangle(Rectangle r) {
		this.upperLeft = r.getLocation();
		this.lowerRight= new Point(r.x+r.width, r.y+r.height);
	}
	
	//Getters

	public Point getUpperLeft() {
		return upperLeft;
	}

	public Point getLowerRight() {
		return lowerRight;
	}
	
	//Setters

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public void setLowerRight(Point lowerRight) {
		this.lowerRight = lowerRight;
	}
	
	//Instance Methods
	
	/*
	 * Modifies the target PointRectangle to relocate deltax units horizontally
	 * and deltay units vertically. 
	 */
	public void translate(int deltax, int deltay) {
		this.upperLeft.x+=deltax;
		this.upperLeft.y+=deltay;
		this.lowerRight.x+=deltax;
		this.lowerRight.y+=deltay;
		
		
	}
	
	/*
	 * Return the perimeter of the target PointRectangle.  Remember that the
	 * perimeter is defined as the sum of the lengths of all its four sides. 
	 * HINT: Consider using the distance method from the Point class.
	 */
	public double perimeter() {
		double side1 =this.lowerRight.x-this.upperLeft.x;
		double side2= this.lowerRight.y- this.upperLeft.y;
		return side1*2+ side2*2; // Dummy return. Correct and remove this comment.
	}
	
	/*
	 * Return the area of the target PointRectangle.  Remember that the
	 * area is defined as the product of the height by the width of the
	 * rectangle.
	 * HINT: Consider using the distance method from the Point class.
	 */
	public double area() {
		double side1 =this.lowerRight.x-this.upperLeft.x;
		double side2= this.lowerRight.y- this.upperLeft.y;
		// YOUR CODE HERE
		return side1*side2; // Dummy return. Correct and remove this comment.
	}
	
	/*
	 * Returns a new Rectangle consisting of the original rectangle with the lower
	 * right point moved to the left by half the width of the rectangle.  The resulting
	 * rectangle will have half the area of the original.
	 * HINT: Carefully read the test cases to make sure you understand how the method
	 * should work.
	 */
	public PointRectangle halfByWidth() {
		double side1 =this.lowerRight.x-this.upperLeft.x;
		double side2= this.lowerRight.y- this.upperLeft.y;
		// YOUR CODE HERE
		return new PointRectangle(this.upperLeft, new Point((int) (this.lowerRight.x-side1/2),this.lowerRight.y )); // Dummy return. Correct and remove this comment.
	}
}