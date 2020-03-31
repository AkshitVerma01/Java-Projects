package space;
/**
 * Date: 15th June 2019
 * Application to find the distance between two planets
 * @author Akshit Verma
 */
public class Route
{
    //Initializing attributes as getters and setters
    public Planet StartingPlanet;
    public Planet DestinationPlanet;
    public float distance;
    public float time;
    public float speed;

    /**
     * Gets the starting planet name
     * @return StartingPlanet (The name of the starting planet)
     */
    public Planet getStartingPlanet() {
		return StartingPlanet;
	}

    /**
     * Sets the starting planet's name
     * @param startingPlanet Name of starting planet
     * @return void
     */
	public void setStartingPlanet(Planet startingPlanet) {
		StartingPlanet = startingPlanet;
	}

	/**
	 * Gets the destination planets name
	 * @return DestinationPlanet (Name of destination planet)
	 */
	public Planet getDestinationPlanet() {
		return DestinationPlanet;
	}

	/**
	 * Sets the destination planet name
	 * @param destinationPlanet Name of destination planet
	 * @return void
	 */
	public void setDestinationPlanet(Planet destinationPlanet) {
		DestinationPlanet = destinationPlanet;
	}

	/**
	 * Gets the distance between two planets
	 * @return distance (The distance between the two planets)
	 */
	public float getDistance() {
		return distance;
	}

	/**
	 * Sets the distance between the two planets
	 * @param distance Distance between the planets
	 * @return void
	 */
	public void setDistance(float distance) {
		this.distance = distance;
	}

	/**
	 * Gets the time to go from to another
	 * @return time (Time taken to go from one planet to another)
	 */
	public float getTime() {
		return time;
	}

	/**
	 * Sets the time taken to go from one planet to another
	 * @param time Time to travel between two planets
	 * @return void
	 */
	public void setTime(float time) {
		this.time = time;
	}

	/**
	 * Gets the speed of the ship
	 * @return speed (The speed of the ship)
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Sets the speed of the ship
	 * @param speed The speed of the ship
	 * @return void
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	/**
	 * Route constructor
	 * 
	 * @param rStart Starting planet name
	 * @param rDestin Destination planet name
	 * @param rspeed Speed of the ship
	 */
    public Route(Planet rStart, Planet rDestin, float rspeed)
    {
        this.StartingPlanet = rStart;
        this.DestinationPlanet = rDestin;
        this.speed = rspeed;
        distance = CalculateDistance(StartingPlanet.x - DestinationPlanet.x, StartingPlanet.y - DestinationPlanet.y);
        time = distance / speed;
    }

    /**
     * Calculates the distance between two planets (or points in this case) using pythagoras theorem
     * @param x X coordinate on the Cartesian plane
     * @param y Y coordinate on the Cartesian plane
     * @return distance (distance between the two planets)
     */
    float CalculateDistance(float x, float y)
    {
        x = Math.abs(x);
        y = Math.abs(y);

        //Calculating the distance between two points using pythagoras theorem
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        return (float)distance;
    }
    
    @Override
    public String toString()
    {
        return "This route is from " + StartingPlanet.name + " to " + DestinationPlanet.name + "\nDistance between them is: " + distance + " AU" + "\nIt will take " + time + " light years to get there" + "\n\n";
    }
}
