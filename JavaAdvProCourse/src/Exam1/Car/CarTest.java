package Exam1.Car;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
	private static final double EPSILON = 0.00001;

	private Car c1;
	private Car c2;
	private Car c3;
	private Car c4;
	private Car c5;
	
	@Before
	public void setUP() {
		c1 = new Car(10);
		c2 = new Car(15);
		c3 = new Car(20);
		c4 = new Car(30);
		c5 = new Car(50);
	}
	
	@Test
	public void testPumpGas() {
		assertEquals("The gas tank must be empty.",0,c1.getGasInTank(),EPSILON);
		
		c1.pumpGas(10.5);
		assertEquals("The gas tank must have 10.5 gallons",10.5,c1.getGasInTank(),EPSILON);
		
		c1.pumpGas(5.5);
		assertEquals("The gas tank must have 16 gallons",16,c1.getGasInTank(),EPSILON);
		
		c2.pumpGas(0);
		assertEquals("The gas tank must have 0 gallons.",0,c2.getGasInTank(),EPSILON);
		
		c3.pumpGas(5.5);
		assertEquals("The gas tank must have 16 gallons",5.5,c3.getGasInTank(),EPSILON);
	}
	
	@Test
	public void testAddMilage() {
		c1.pumpGas(25);
		c2.pumpGas(25);
		c3.pumpGas(25);
		c4.pumpGas(25);
		c5.pumpGas(25);
		
		assertEquals("Mileage must be 0.",0,c1.getMileage(),EPSILON);
		assertEquals("Mileage must be 0.",0,c2.getMileage(),EPSILON);
		assertEquals("Mileage must be 0.",0,c3.getMileage(),EPSILON);
		assertEquals("Mileage must be 0.",0,c4.getMileage(),EPSILON);
		assertEquals("Mileage must be 0.",0,c5.getMileage(),EPSILON);
		
		c1.addMiles(250);
		c2.addMiles(300);
		c3.addMiles(300);
		c4.addMiles(400);
		c5.addMiles(500);
		c5.addMiles(100);
		
		assertEquals("Mileage must be 250.",250,c1.getMileage(),EPSILON);
		assertEquals("Mileage must be 300.",300,c2.getMileage(),EPSILON);
		assertEquals("Mileage must be 300.",300,c3.getMileage(),EPSILON);
		assertEquals("Mileage must be 400.",400,c4.getMileage(),EPSILON);
		assertEquals("Mileage must be 600.",600,c5.getMileage(),EPSILON);
		
		assertEquals("The gas in tank is incorrect.",0,c1.getGasInTank(),EPSILON);
		assertEquals("The gas in tank is incorrect.",5,c2.getGasInTank(),EPSILON);
		assertEquals("The gas in tank is incorrect.",10,c3.getGasInTank(),EPSILON);
		assertEquals("The gas in tank is incorrect.",(35.0/3.0),c4.getGasInTank(),EPSILON);
		assertEquals("The gas in tank is incorrect.",13,c5.getGasInTank(),EPSILON);
		
		assertEquals("The gas consumend is incorrect.",25,c1.getTripGasConsumed(),EPSILON);
		assertEquals("The gas consumend is incorrect.",20,c2.getTripGasConsumed(),EPSILON);
		assertEquals("The gas consumend is incorrect.",15,c3.getTripGasConsumed(),EPSILON);
		assertEquals("The gas consumend is incorrect.",(40.0/3.0),c4.getTripGasConsumed(),EPSILON);
		assertEquals("The gas consumend is incorrect.",12,c5.getTripGasConsumed(),EPSILON);
	}
	
	@Test
	public void testResetTrip() {
		c1.pumpGas(25);
		c2.pumpGas(25);
		c3.pumpGas(25);
		c4.pumpGas(25);
		c5.pumpGas(25);
		c1.addMiles(250);
		c2.addMiles(300);
		c3.addMiles(300);
		c4.addMiles(400);
		c5.addMiles(500);
		c5.addMiles(100);
		c1.resetTrip();
		c2.resetTrip();
		c3.resetTrip();
		c4.resetTrip();
		c5.resetTrip();
		assertEquals("The car did not reset trip mileage.",0,c1.getTripMileage(),EPSILON);
		assertEquals("The car did not reset trip mileage.",0,c2.getTripMileage(),EPSILON);
		assertEquals("The car did not reset trip mileage.",0,c3.getTripMileage(),EPSILON);
		assertEquals("The car did not reset trip mileage.",0,c4.getTripMileage(),EPSILON);
		assertEquals("The car did not reset trip mileage.",0,c5.getTripMileage(),EPSILON);
		assertEquals("The car did not reset gas consumed.",0,c1.getTripGasConsumed(),EPSILON);
		assertEquals("The car did not reset gas consumed.",0,c2.getTripGasConsumed(),EPSILON);
		assertEquals("The car did not reset gas consumed.",0,c3.getTripGasConsumed(),EPSILON);
		assertEquals("The car did not reset gas consumed.",0,c4.getTripGasConsumed(),EPSILON);
		assertEquals("The car did not reset gas consumed.",0,c5.getTripGasConsumed(),EPSILON);
	}

	@Test
	public void testGetTripMilesGallon() {
		c1.pumpGas(25);
		c2.pumpGas(25);
		c3.pumpGas(25);
		c4.pumpGas(25);
		c5.pumpGas(25);
		c1.addMiles(250);
		c2.addMiles(300);
		c3.addMiles(300);
		c4.addMiles(400);
		c5.addMiles(500);
		c5.addMiles(100);
		assertEquals("The calculation is wrong.",10,c1.getTripMilesPerGallon(),EPSILON);
		assertEquals("The calculation is wrong.",15,c2.getTripMilesPerGallon(),EPSILON);
		assertEquals("The calculation is wrong.",20,c3.getTripMilesPerGallon(),EPSILON);
		assertEquals("The calculation is wrong.",30,c4.getTripMilesPerGallon(),EPSILON);
		assertEquals("The calculation is wrong.",50,c5.getTripMilesPerGallon(),EPSILON);
	}
	
	@Test
	public void testRefineMPG() {
		c1.pumpGas(25);
		c2.pumpGas(25);
		c3.pumpGas(25);
		c4.pumpGas(25);
		c5.pumpGas(25);
		c1.addMiles(250);
		c2.addMiles(300);
		c3.addMiles(300);
		c4.addMiles(400);
		c5.addMiles(500);
		c5.addMiles(100);
		c1.refineMPG();
		c2.refineMPG();
		c3.refineMPG();
		c4.refineMPG();
		c5.refineMPG();
		assertEquals("The calculation is wrong.",10,c1.getMilesPerGallon(),EPSILON);
		assertEquals("The calculation is wrong.",15,c2.getMilesPerGallon(),EPSILON);
		assertEquals("The calculation is wrong.",20,c3.getMilesPerGallon(),EPSILON);
		assertEquals("The calculation is wrong.",30,c4.getMilesPerGallon(),EPSILON);
		assertEquals("The calculation is wrong.",50,c5.getMilesPerGallon(),EPSILON);
	}
	
	@Test
	public void testCanReach() {
		c1.pumpGas(25);
		c2.pumpGas(25);
		c3.pumpGas(25);
		c4.pumpGas(25);
		c5.pumpGas(25);
		
		assertTrue("It should reach 0 miles.",c1.canReach(0));
		assertTrue("It should reach 0 miles.",c2.canReach(0));
		assertTrue("It should reach 0 miles.",c3.canReach(0));
		assertTrue("It should reach 0 miles.",c4.canReach(0));
		assertTrue("It should reach 0 miles.",c5.canReach(0));
		
		assertFalse("It should not reach 2000 miles.",c1.canReach(2000));
		assertFalse("It should not reach 2000 miles.",c2.canReach(2000));
		assertFalse("It should not reach 2000 miles.",c3.canReach(2000));
		assertFalse("It should not reach 2000 miles.",c4.canReach(2000));
		assertFalse("It should not reach 2000 miles.",c5.canReach(2000));
		
		assertTrue("It should reach 250 miles.",c1.canReach(250));
		assertTrue("It should reach 375 miles.",c2.canReach((375)));
		assertTrue("It should reach 500 miles.",c3.canReach(500));
		assertTrue("It should reach 750 miles.",c4.canReach(750));
		assertTrue("It should reach 1250 miles.",c5.canReach(1250));
	}
}