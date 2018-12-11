package Exam1.RGBColor;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RGBColorTest {

	private RGBColor fullRed;
	private RGBColor fullGreen;
	private RGBColor fullBlue;
	private RGBColor fullRG;
	private RGBColor white;
	private RGBColor black;
	private RGBColor darkGray;
	private RGBColor darkRed;
	
	private final double epsilon = 1E-5;

	@Before
	public void setup() {
		fullRed = new RGBColor(255,0,0);
		fullGreen = new RGBColor(0, 255,0);
		fullBlue = new RGBColor(0, 0,255);
		white = new RGBColor(255, 255,255);
		fullRG = new RGBColor(255, 255,0);
		black = new RGBColor(0, 0, 0);
		darkGray = new RGBColor(111, 111, 111);
		darkRed = new RGBColor(100, 0, 0);
	}
	
	@Test
	public void testCopyContructor() {
		RGBColor fullRedCopy = new RGBColor(fullRed);
		assertFalse("Copy contructor does not return new object", fullRedCopy == fullRed);
		assertEquals("Copy constructor returns different object", fullRedCopy, fullRed);
		RGBColor blackCopy = new RGBColor(white);
		assertFalse("Copy contructor does not return new object", blackCopy == white);
		assertEquals("Copy constructor returns different object", blackCopy, white);
	}

	@Test
	public void testAdd() {
		assertEquals(white,fullRG.add(fullBlue));
		assertEquals(white,white.add(fullBlue));
		assertEquals(white,white.add(white));
		assertEquals(white,white.add(black));
		assertEquals(new RGBColor(211,111,111),darkGray.add(darkRed));
	}

	@Test
	public void testSubtract() {
		assertEquals(fullRG,white.subtract(fullBlue));
		assertEquals(black,white.subtract(white));
		assertEquals(white,white.subtract(black));
		assertEquals(black,black.subtract(white));
		assertEquals(new RGBColor(11,111,111),darkGray.subtract(darkRed));
	}
	
	@Test
	public void testDarker() {
		assertEquals(new RGBColor(255-25,255-25,255-25), white.darker(0.10));
		assertEquals(black, black.darker(0.10));
		assertEquals(new RGBColor(0,255-25,0), fullGreen.darker(0.10));
	}
	
	@Test
	public void testComplement() {
		RGBColor blackComplement = black.complement();
		assertFalse("Copy contructor does not return new object", blackComplement == black);
		assertEquals("Copy constructor returns different object", blackComplement, white);
		RGBColor whiteComplement = white.complement();
		assertFalse("Copy contructor does not return new object", whiteComplement == white);
		assertEquals("Copy constructor returns different object", whiteComplement, black);
	}
}