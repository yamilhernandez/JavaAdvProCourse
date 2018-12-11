package Exam1.Wallet;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WalletTest {

	private Wallet zeroAll;
	private Wallet oneOfEach;
	private Wallet twoOfEach;
	private Wallet allOneHundred;
	private Wallet minimal1;
	private Wallet minimal2;
	private Wallet notMinimal1;
	private Wallet notMinimal2;

	@Before
	public void setUp() {
		zeroAll = new Wallet(0,0,0,0,0);
		oneOfEach = new Wallet(1,1,1,1,1); // $136
		twoOfEach = new Wallet(2,2,2,2,2); // $272
		allOneHundred = new Wallet(100,20,10,5,1); // $500
		minimal1 = new Wallet(4, 1, 1, 3, 2); // $279
		minimal2 = new Wallet(3, 1, 0, 2, 2); // $248
		notMinimal1 = new Wallet(279,0,0,0,0);
		notMinimal2 = new Wallet(203,1,0,2,0);
	}

	@Test
	public void testAmountConstructor() {
		Wallet newZero = new Wallet(0);
		assertEquals(newZero, zeroAll);
		Wallet twoSeventyNine = new Wallet(279);
		assertEquals(twoSeventyNine, minimal1);
		Wallet twoFortyEight = new Wallet(248);
		assertEquals(twoFortyEight, minimal2);
	}

	@Test
	public void testGetAmount() {
		assertEquals(0, zeroAll.getAmount()); 
		assertEquals(136, oneOfEach.getAmount()); 
		assertEquals(500, allOneHundred.getAmount()); 
		assertEquals(279, minimal1.getAmount()); 
		assertEquals(248, minimal2.getAmount()); 
	}

	@Test
	public void testAddWallet() {
		assertTrue(zeroAll == zeroAll.add(zeroAll));
		assertEquals(zeroAll,zeroAll.add(zeroAll));
		assertEquals(oneOfEach,new Wallet(zeroAll).add(oneOfEach));
		assertEquals(oneOfEach,new Wallet(oneOfEach).add(zeroAll));
		assertEquals(twoOfEach,new Wallet(oneOfEach).add(oneOfEach));
	}
	
	@Test 
	public void testAddAmount() {
		assertTrue(zeroAll == zeroAll.add(0));
		assertEquals(oneOfEach,new Wallet(zeroAll).add(136));
		assertEquals(minimal1,new Wallet(zeroAll).add(279));
		assertEquals(minimal2,new Wallet(zeroAll).add(248));
	}
	
	@Test
	public void minimize() {
		assertTrue(zeroAll.minimize()==zeroAll);
		assertEquals(zeroAll, new Wallet(zeroAll).minimize());
		assertEquals(minimal1, new Wallet(notMinimal1).minimize());
		assertEquals(minimal2, new Wallet(notMinimal2).minimize());
	}

}
