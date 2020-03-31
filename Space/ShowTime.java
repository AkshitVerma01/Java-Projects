package space;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * Date: 15th June 2019 Application for finding the best route between two
 * planets
 * 
 * @author Akshit Verma
 */
public class ShowTime {
	/**
	 * 
	 * @param args String array for passing command line
	 * @return void
	 */
	public static void main(String[] args) {

		// Array of planet objects
		Planet[] planets = new Planet[] {
				// name, population, max population, x coord, y coord
				new Planet("55Canrie", 548254, 132568743, 678, 56), new Planet("GJ 1214b", 654223, 982756438, 567, 567),
				new Planet("Osiris", 654265, 564237894, 56, 5678), new Planet("Methuselah", 789073, 432789540, 567, 67),
				new Planet("Kepler-1B", 454356, 432179430, 657, 567) };

		// Array of route objects
		Route[] routes = new Route[] {
				// starting planet and destination planet routes with speed
				new Route(planets[0], planets[1], 3), new Route(planets[0], planets[2], 3),
				new Route(planets[0], planets[3], 3), new Route(planets[0], planets[4], 3) };

		Spaceship Tartarus = new Spaceship(routes[0], 175, 650, 3);

		System.out.println(planets[0].toString() + "\n" + planets[1].toString() + routes[0].toString()
				+ planets[2].toString() + routes[1].toString() + planets[3].toString() + routes[2].toString()
				+ planets[4].toString() + routes[3].toString() + Tartarus.toString());

		// Array for the ratios for distance and population for each planet
		float[] ratio = { (routes[0].distance / planets[1].population), (routes[1].distance / planets[2].population),
				(routes[2].distance / planets[3].population), (routes[3].distance / planets[4].population) };
		// Array for storing population
		float[] populations = { (planets[1].population), (planets[2].population), (planets[3].population),
				(planets[4].population) };

		// All these while loops ensure there are no -ve people left stranded
		int shipSent = 0;
		while (planets[1].population > 0) {

			// If the planet's population is higher than the max passenger limit, decrease
			// the population by max limit
			if (planets[1].population > Tartarus.maxPassengers) {
				planets[1].population -= Tartarus.maxPassengers;
			}

			// If it is lower, set the passenger limit to the current population, and
			// decrease it from there.
			else {
				Tartarus.passengers = planets[1].population;
				planets[1].population -= Tartarus.passengers;
			}
			shipSent++;

		}

		System.out.println("The ship needs to go to GJ1214b " + shipSent + " times to save everyone");

		while (planets[2].population > 0) {
			if (planets[2].population > Tartarus.maxPassengers) {
				planets[2].population -= Tartarus.maxPassengers;
			} else {
				Tartarus.passengers = planets[2].population;
				planets[2].population -= Tartarus.passengers;
			}

			shipSent++;
		}

		System.out.println("The ship needs to go to Osiris " + shipSent + " times to save everyone");

		while (planets[3].population > 0) {
			if (planets[3].population > Tartarus.maxPassengers) {
				planets[3].population -= Tartarus.maxPassengers;
			} else {
				Tartarus.passengers = planets[3].population;
				planets[3].population -= Tartarus.passengers;
			}

			shipSent++;
		}

		System.out.println("The ship needs to go to Methuselah " + shipSent + " times to save everyone");

		while (planets[4].population > 0) {

			if (planets[4].population > Tartarus.maxPassengers) {
				planets[4].population -= Tartarus.maxPassengers;
			} else {
				Tartarus.passengers = planets[4].population;
				planets[4].population -= Tartarus.passengers;
			}

			shipSent++;
		}

		System.out.println("The ship needs to go to Kepler1B " + shipSent + " times to save everyone");
		System.out.println(" ");

		// Print out the list for the calculated ratios
		System.out.println("The ratios for distance vs population for each planet and route are: " + ratio[0] + ", "
				+ ratio[1] + ", " + ratio[2] + ", " + ratio[3]);

		Arrays.sort(ratio);

		// Make a temporary route array
		Route[] tempRoute = new Route[routes.length];
		int count = 0;

		for (int i = 0; i < routes.length; i++) {

			Route tempRoutes = new Route(planets[0], planets[i + 1], 3);

			for (int j = 0; j < ratio.length; j++) {

				float temp = (tempRoutes.distance / populations[i]);
				System.out.println(planets[i + 1].population);

				if (temp == ratio[j]) {
					tempRoute[count] = routes[i];
					count++;
					break;
				}
				break;
			}
		}

		// Set the route current index to the tempRoute, all sorted
		for (int i = 0; i < routes.length; i++) {
			routes[i] = tempRoute[i];
		}
		System.out.println("\nThe best route for evacuation based on the lowest ratio is: " + ratio[0] + "\n"
				+ routes[0].toString());
	}
}