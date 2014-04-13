package edu.brookdalecc.comp228.animals;
/* Terry Chern
 * Comp 228-800RL
 * 12 February 2014
 * Rolf Kamp
 * Dog subclass (implementation of Animal superclass)
 */

public class Dog implements Animal{
// Subclass of Animal
	public static final String DEFAULT_COLOR = "black";
	protected String furColor;
	
// Constructors
	public Dog(){
	// no-arg creates a dog of the default color
		this(DEFAULT_COLOR);
	}
	
	public Dog(String furColor){
		this.furColor = furColor;
	}	
	
// Methods
	public void move(){
	// Generates 4 motions at random
		switch((int)(Math.random()*4)){
			case 0:
				System.out.print("walks");
				break;
			case 1:
				System.out.print("jumps");
				break;
			case 2:
				System.out.print("runs");
				break;
			default:
				System.out.print("sits");
		}
	}

	public void makeSound(){
	// Generates 4 sounds at random
		switch((int)(Math.random()*4)){
			case 0:
				System.out.print("barks");
				break;
			case 1:
				System.out.print("growls");
				break;
			case 2:
				System.out.print("howls");
				break;
			default:
				System.out.print("whines");
		}
	}

	public String getFurColor() {
	// Retrieve color of dog
		return furColor;
	}

	public void setFurColor(String furColor) {
	// Set color of dog
		this.furColor = furColor;
	}
	
	public String toString(){
		return String.format("The %s %s ",this.getFurColor(),this.getClass().getSimpleName());
	}
	
}
