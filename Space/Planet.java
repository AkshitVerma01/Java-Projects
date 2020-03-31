package space;
/**
 * Date: 15th June 2019
 * Application to get the name and location of planets
 * @author Akshit Verma
 */
public class Planet
{
    //Initializing attributes as getters and setters
     public String name;
     public int population;
     public int maxPopulation;
     public float x;
     public float y;

     /**Gets the name of the planet
      * 
      * @return name (Name of planet)
      */
     public String getName() {
		return name;
	}

     /**
      * Sets the name of the planet
      * @param name Name of planet
      * @return void
      */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the current population of the planet
	 * @return population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * Set the current population
	 * @param population Current population
	 * @return void
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * Get the max population of the planet
	 * @return maxPopulation (Population max for the planet)
	 */
	public int getMaxPopulation() {
		return maxPopulation;
	}

	/**
	 * Set max population for planet
	 * @param maxPopulation Max population of the planet
	 * @return void
	 */
	public void setMaxPopulation(int maxPopulation) {
		this.maxPopulation = maxPopulation;
	}

	/**
	 * Get the X coordinate of the planet
	 * @return x (X coordinate)
	 */
	public float getX() {
		return x;
	}

	/**
	 * Set X value of coordinate
	 * @param x X coordinate
	 * @return void
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Get Y coordinate of the planet
	 * @return y (Y coordinate of the planet)
	 */
	public float getY() {
		return y;
	}

	/**
	 * Set Y value of coordinate planet
	 * @param y Y coordinate
	 * @return void
	 */
	public void setY(float y) {
		this.y = y;
	}

	
	/**
	 * //Planet constructor
	 * @param pName Planet name
	 * @param pPopu Planet population current
	 * @param pMaxPopu Planet max population allowed
	 * @param pX X coordinate of the planet
	 * @param pY Y coordinate of the planet
	 */
     public Planet(String pName, int pPopu, int pMaxPopu, int pX, int pY)
     {
         this.name = pName;
         this.population = pPopu;
         this.maxPopulation = pMaxPopu;
         this.x = pX;
         this.y = pY;
     }
     @Override
     //Printing the information
     public String toString()
     {
         return "Planet name is: " + name + "\nPopulation is: " + population + "\nMax population is: " + maxPopulation + "\nLocated at: " + (x + "," + y) + "\n";
     }
 }
