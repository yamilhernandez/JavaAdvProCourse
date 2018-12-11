package Exam1.PointRectangle;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class PointRectangleTest {

	private static final double EPSILON = 0.00001;

	private PointRectangle pR1;
	private PointRectangle pR2;
	private PointRectangle pR3;
	private PointRectangle pR4;
	private PointRectangle pR5;

	@Before
	public void setUp() {
		pR1 = new PointRectangle(new Point(0,0),new Point(4,4));
		pR2 = new PointRectangle(new Point(1,6),new Point(3,10));
		pR3 = new PointRectangle(new Point(8,10),new Point(10,12));
		pR4 = new PointRectangle(new Point(1,1),new Point(5,3));
		pR5 = new PointRectangle(new Point(1,1),new Point(1,1));
	}

	@Test
	public void testConstructor() {
		Rectangle rec = new Rectangle(1,5,3,4);
		PointRectangle result = new PointRectangle(rec);
		assertEquals("The X upper left value is incorrect.", 1,result.getUpperLeft().getX(),EPSILON);
		assertEquals("The Y upper left value is incorrect.", 5,result.getUpperLeft().getY(),EPSILON);
		assertEquals("The X lower right value is incorrect.", 4,result.getLowerRight().getX(),EPSILON);
		assertEquals("The Y lower right value is incorrect.", 9,result.getLowerRight().getY(),EPSILON);

		rec = new Rectangle(0,0,0,0);
		result = new PointRectangle(rec);
		assertEquals("The X upper left value is incorrect.", 0,result.getUpperLeft().getX(),EPSILON);
		assertEquals("The Y upper left value is incorrect.", 0,result.getUpperLeft().getY(),EPSILON);
		assertEquals("The X lower right value is incorrect.", 0,result.getLowerRight().getX(),EPSILON);
		assertEquals("The Y lower right value is incorrect.", 0,result.getLowerRight().getY(),EPSILON);

		rec = new Rectangle(5,4,0,0);
		result = new PointRectangle(rec);
		assertEquals("The X upper left value is incorrect.", 5,result.getUpperLeft().getX(),EPSILON);
		assertEquals("The Y upper left value is incorrect.", 4,result.getUpperLeft().getY(),EPSILON);
		assertEquals("The X lower right value is incorrect.", 5,result.getLowerRight().getX(),EPSILON);
		assertEquals("The Y lower right value is incorrect.", 4,result.getLowerRight().getY(),EPSILON);
	}

	@Test
	public void testTranslate() {
		pR1.translate(0, 0);
		assertEquals("The X upper left value must not change.",0,pR1.getUpperLeft().getX(),EPSILON);
		assertEquals("The Y upper left value must not change.",0,pR1.getUpperLeft().getY(),EPSILON);
		assertEquals("The X lower right value must not change.",4,pR1.getLowerRight().getX(),EPSILON);
		assertEquals("The Y lower right value must not change.",4,pR1.getLowerRight().getY(),EPSILON);

		pR1.translate(5, 5);
		assertEquals("The X upper left value must change.",5,pR1.getUpperLeft().getX(),EPSILON);
		assertEquals("The Y upper left value must change.",5,pR1.getUpperLeft().getY(),EPSILON);
		assertEquals("The X lower right value must change.",9,pR1.getLowerRight().getX(),EPSILON);
		assertEquals("The Y lower right value must change.",9,pR1.getLowerRight().getY(),EPSILON);

		pR1.translate(-6, -5);
		assertEquals("The X upper left value must change.",-1,pR1.getUpperLeft().getX(),EPSILON);
		assertEquals("The Y upper left value must change.",0,pR1.getUpperLeft().getY(),EPSILON);
		assertEquals("The X lower right value must change.",3,pR1.getLowerRight().getX(),EPSILON);
		assertEquals("The Y lower right value must change.",4,pR1.getLowerRight().getY(),EPSILON);
	}

	@Test
	public void testPerimeter() {
		double result = pR2.perimeter();
		assertNotEquals("The result must not be 0.",0,result,EPSILON);

		result = pR1.perimeter();
		assertEquals("The result is not the correct perimeter.",16,result,EPSILON);

		result = pR2.perimeter();
		assertEquals("The result is not the correct perimeter.",12,result,EPSILON);

		result = pR3.perimeter();
		assertEquals("The result is not the correct perimeter.",8,result,EPSILON);

		result = pR4.perimeter();
		assertEquals("The result is not the correct perimeter.",12,result,EPSILON);

		result = pR5.perimeter();
		assertEquals("The result is not the correct perimeter.",0,result,EPSILON);
	}

	@Test
	public void testArea() {
		double result = pR2.area();
		assertNotEquals("The result must not be 0.",0,result,EPSILON);

		result = pR1.area();
		assertEquals("The result is not the correct perimeter.",16,result,EPSILON);

		result = pR2.area();
		assertEquals("The result is not the correct perimeter.",8,result,EPSILON);

		result = pR3.area();
		assertEquals("The result is not the correct perimeter.",4,result,EPSILON);

		result = pR4.area();
		assertEquals("The result is not the correct perimeter.",8,result,EPSILON);

		result = pR5.area();
		assertEquals("The result is not the correct perimeter.",0,result,EPSILON);
	}

	@Test
	public void testHalfByWidth() {
		PointRectangle result = pR1.halfByWidth();
		assertNotSame("The method must not return the target object.",result,pR1);
		assertEquals("The method must not change the target object upper left.",new Point(0,0),pR1.getUpperLeft());
		assertEquals("The method must not change the target object lower right.",new Point(4,4),pR1.getLowerRight());
		
		assertEquals("The method changed the upper left new object parameter.",new Point(0,0),result.getUpperLeft());
		assertNotEquals("The method did not changed the lower right new object parameter.",new Point(4,4),result.getLowerRight());
		assertEquals("The method did not calculate properly the lower right new object parameter.",new Point(2,4),result.getLowerRight());
		
		result = pR2.halfByWidth();
		assertNotSame("The method must not return the target object.",result,pR2);
		assertEquals("The method must not change the target object upper left.",new Point(1,6),pR2.getUpperLeft());
		assertEquals("The method must not change the target object lower right.",new Point(3,10),pR2.getLowerRight());
		
		assertEquals("The method changed the upper left new object parameter.",new Point(1,6),result.getUpperLeft());
		assertNotEquals("The method did not changed the lower right new object parameter.",new Point(3,10),result.getLowerRight());
		assertEquals("The method did not calculate properly the lower right new object parameter.",new Point(2,10),result.getLowerRight());
		
		result = pR5.halfByWidth();
		assertNotSame("The method must not return the target object.",result,pR5);
		assertEquals("The method must not change the target object upper left.",new Point(1,1),pR5.getUpperLeft());
		assertEquals("The method must not change the target object lower right.",new Point(1,1),pR5.getLowerRight());
		
		assertEquals("The method changed the upper left new object parameter.",new Point(1,1),result.getUpperLeft());
		assertEquals("The method did not calculate properly the lower right new object parameter.",new Point(1,1),result.getLowerRight());
	}

}