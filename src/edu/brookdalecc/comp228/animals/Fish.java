package edu.brookdalecc.comp228.animals;
/* Terry Chern
 * Comp 228-800RL
 * 12 February 2014
 * Rolf Kamp
 * Fish subclass (implementation of Animal superclass)
 */

public class Fish implements Animal{
// Subclass of Animal
	public static String DEFAULT_COLOR = "gold";
	protected String color;

// Constructors
	public Fish(){
	// generates a DEFAULT_COLOR colored fish
		this(DEFAULT_COLOR);
	}
	
	public Fish(String color){
	// generates a fish of specified color
		this.color = color;
	}

	
// Methods
	public void move() {
	// randomly generates a movement
		switch((int)(Math.random()*3)){
		case 0:
			System.out.print("swims");
			break;
		case 1:
			System.out.print("flops");
			break;
		default:
			System.out.print("sinks");
	}
	} 

	public void makeSound() {
	// randomly generates a sound
		switch((int)(Math.random()*3)){
			case 0:
				System.out.print("bloops");
				break;
			case 1:
				System.out.print("splashes");
				break;
			default:
				System.out.print("blubs");
		}
	}

	public String getColor() {
	// Retrieve color of fish
		return color;
	}

	public void setColor(String color) {
	// Set color of fish
		this.color = color;
	}
	
	public String toString(){
		return String.format("The %s %s ",this.getColor(),
			this.getClass().getSimpleName());
	}
}
