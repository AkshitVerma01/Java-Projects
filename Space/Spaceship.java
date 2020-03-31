package space;

/**
 * Date: 15th June 2019 Application for finding the information about a
 * spaceship
 * 
 * @author Akshit Verma
 */
public class Spaceship {
	// Initializing attributes as getters and setters
	public Route route;
	public int passengers;
	public int maxPassengers;
	public float speed;

	/**
	 * Spaceship constructor
	 * 
	 * @param sRoute     The route the ship will take
	 * @param sPassen    The number of people on the ship at this moment
	 * @param sMaxPassen The max number of people allowed on the ship
	 * @param sSpeed     The speed of the spaceship
	 */
	public Spaceship(Route sRoute, int sPassen, int sMaxPassen, float sSpeed) {
		this.route = sRoute;
		this.passengers = sPassen;
		this.maxPassengers = sMaxPassen;
		this.speed = sSpeed;
	}

	/**
	 * Get the route name
	 * @return route (The route for the two planets)
	 */
	public Route getRoute() {
		return route;
	}

	/**
	 * Set the route name
	 * @param route The route name
	 * @return void
	 */
	public void setRoute(Route route) {
		this.route = route;
	}

	/**
	 * Get the passenger limit
	 * @return passengers (Number of passengers on the ship)
	 */
	public int getPassengers() {
		return passengers;
	}

	/**
	 * Set passenger limit
	 * @param passengers The number of passengers on the ship
	 * @return void
	 */
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	/**
	 * Get max passenger limit
	 * @return maxPassengers (Maximum number of passengers on the ship)
	 */
	public int getMaxPassengers() {
		return maxPassengers;
	}

	/**
	 * Set the max passenger limit
	 * @param maxPassengers The maximum number of passengers on the ship
	 * @return void
	 */
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	/**
	 * Get the speed of the ship
	 * @return speed (The speed of the ship)
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Set the speed of the ship
	 * @param speed The speed of the ship
	 * @return void
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	// Printing the information
	public String toString() {
		return "Spaceship has " + passengers + " many people on board" + "\nCan hold: " + maxPassengers
				+ " people total" + "\nTravelling at a speed of: " + speed + " light years" + "\n";
	}

}