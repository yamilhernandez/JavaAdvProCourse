package Exam1.Car;


public class Car {
	
	private double mileage;
	private double gasInTank;
	private double milesPerGallon;
	private double tripMileage;
	private double tripGasConsumed;
	
	public Car(double milesPerGallon) {
		super();
		this.milesPerGallon = milesPerGallon;
	}
	
	/*
	 * Returns the total mileage traveled by the car from its creation
	 */
	public double getMileage() {
		return mileage;
	}

	/*
	 * Returns the gas (in gallons) remaining in the target car tank
	 */
	public double getGasInTank() {
		return gasInTank;
	}

	/*
	 * Returns the miles per gallon for the target car
	 */
	public double getMilesPerGallon() {
		return milesPerGallon;
	}

	/*
	 * Returns the total mileage traveled in the last trip by the target car
	 */
	public double getTripMileage() {
		return tripMileage;
	}

	/*
	 * Get total gallons consumed by target Car in last trip
	 */
	public double getTripGasConsumed() {
		return tripGasConsumed;
	}
	
	/*
	 * Add the given gallons of gas to the target Car
	 */
	public void pumpGas(double gallons) {
			this.gasInTank+=gallons;
	    //	YOUR CODE HERE
	}
	
	/*
	 * Reset trip mileage and trip gas consumed to 0 to star measuring a new trip
	 */
	public void resetTrip() {
		this.tripMileage=0;
		this.tripGasConsumed=0;
	    //	YOUR CODE HERE
	}

	/*
	 * Record additional mileage traveled by the target Car.  Adjust
	 * total mileage and trip mileage.   Reduce the gas in the tank by
	 * the gas consumed by the target Car to travel the argument miles.
	 */
	public void addMiles(double miles) {
		this.mileage+=miles;
		this.tripMileage+=miles;
		this.gasInTank-=Math.pow(this.milesPerGallon/miles, -1);
		this.tripGasConsumed+= Math.pow(this.milesPerGallon/miles, -1);
		
        // YOUR CODE HERE
	}
	
	/*
	 * Return the miles per gallon achieved by the target Car during the last trip.
	 * This can be calculated by dividing miles traveled in trip by the gas consumed
	 * in this trip.
	 */
	public double getTripMilesPerGallon() {
		return this.mileage/this.tripGasConsumed;
	    // YOUR CODE HERE
	}
	
	/*
	 * Adjust the milePerGallon in the target Car by averaging the previous 
	 * milesPerGallon and the miles per gallon achieved during the last trip.
	 * The average should give twice more weight to the latest trip miles per
	 * gallon. HINT: Consider using the following formula.
	 *      new average = (previous average + (new average * 2))/3
	 */
	public void refineMPG() {
	
	}
	
	/*
	 * Returns true if and only if the target Car can travel for parameter miles
	 * with the gas held in the tank.
	 */
	public boolean canReach(double miles) {
		if(this.gasInTank<Math.pow(this.milesPerGallon/miles, -1)){
			return false;
		}
		return true;
		// YOUR COE HERE
	}
}