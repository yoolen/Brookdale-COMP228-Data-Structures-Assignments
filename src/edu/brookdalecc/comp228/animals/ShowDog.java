package edu.brookdalecc.comp228.animals;
/* Terry Chern
 * Comp 228-800RL
 * 12 February 2014
 * Rolf Kamp
 * ShowDog subclass (extends Dog superclass)
 */

public class ShowDog extends Dog{
// Subclass of dog
	public static final String DEFAULT_BREED = "poodle";
	private String breed;
	
// Constructors
	public ShowDog(){
	// no-arg generates a DEFAULT-COLOR (super) colored ShowDog of breed DEFAULT_BREED
		this(DEFAULT_BREED);
	}
	
	public ShowDog(String breed){
	// generates a DEFAULT-COLOR (super) colored ShowDog of specified breed
		this.breed = breed;
	}
	
	public ShowDog(String color, String breed){
	// generates a DEFAULT-COLOR (super) colored ShowDog of specified breed
		super(color);
		this.setBreed(breed);
	}

// Methods
	public String getBreed() {
	// get breed of ShowDog
		return breed;
	}

	public void setBreed(String breed) {
	// set breed of ShowDog
		this.breed = breed;
	}
	
	// Subclass specific implementations of move() and makeSound()
	public void move(){
	// Generates 4 motions at random
		switch((int)(Math.random()*4)){
			case 0:
				System.out.print("trots");
				break;
			case 1:
				System.out.print("walks");
				break;
			case 2:
				System.out.print("jumps");
				break;
			default:
				System.out.print("runs");
		}
	}

	public void makeSound(){
	// Generates 3 sounds at random
		switch((int)(Math.random()*4)){
			case 0:
				System.out.print("barks");
				break;
			case 1:
				System.out.print("yips");
				break;
			default:
				System.out.print("howls");
		}
	}
	
	public String toString(){
		return String.format("The %s %s %s ",this.getFurColor(),this.getBreed(),
			this.getClass().getSimpleName());
	}
}
