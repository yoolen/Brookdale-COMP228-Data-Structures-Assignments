package edu.brookdalecc.comp228.animals;
/* Terry Chern
 * Comp 228-800RL
 * 12 February 2014
 * Rolf Kamp
 * GuardDog subclass (extends Dog superclass)
 */

public class GuardDog extends Dog{
// Subclass of Dog
	public static final short DEFAULT_MEAN = 10; 
	private short meanness;
	
// Constructors
	public GuardDog(){
	// Creates a DEFAULT_COLOR (super) colored GuardDog of DEFAULT_MEAN meanness
		this(DEFAULT_MEAN);
	}
	
	public GuardDog(short meanness) {
	// Creates a DEFAULT_COLOR (super) colored GuardDog of specified meanness
		this.meanness = meanness;
	}
	
	public GuardDog(String color, short meanness){
	// Create a "color" colored GuardDog of specified meanness
		super(color);
		this.setMeanness(meanness);
	}

// Methods	
	public void setMeanness(short meanness){
	// Set GuardDog to specified meanness
		this.meanness = meanness;
	}

	public short getMeanness(){
	// Retrieve meanness of GuardDog
		return this.meanness;
	}
	
	// Subclass specific implementations of move() and makeSound()
	public void move(){
	// Generates 4 motions at random
		switch((int)(Math.random()*4)){
			case 0:
				System.out.print("chases");
				break;
			case 1:
				System.out.print("jumps");
				break;
			case 2:
				System.out.print("runs");
				break;
			default:
				System.out.print("dashes");
		}
	}

	public void makeSound(){
	// Generates 3 sounds at random
		switch((int)(Math.random()*4)){
			case 0:
				System.out.print("barks");
				break;
			case 1:
				System.out.print("growls");
				break;
			default:
				System.out.print("howls");
		}
	}
	
	public String toString(){
		return String.format("The %s, %d meanness %s ",this.getFurColor(),
			this.getMeanness(),this.getClass().getSimpleName());
	}
}
