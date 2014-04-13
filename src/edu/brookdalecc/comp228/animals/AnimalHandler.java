package edu.brookdalecc.comp228.animals;
/* Terry Chern
 * Comp 228-800RL
 * 12 February 2014
 * Rolf Kamp
 * Driver Program for Animal Interface
 */

public class AnimalHandler {
// Driver class for Animals package, includes variety of methods for generating random things
	
	public static String RandomColor(){
	// return a random color
		switch((int)(Math.random()*7)){
			case 0:
				return "brown";
			case 1:
				return "orange";
			case 2:
				return "yellow";
			case 3:
				return "white";
			case 4:
				return "striped";
			case 5:
				return "dotted";
			default:
				return "black";
		}
	}
	
	public static short RandomMean(){
	// returns a meanness from 0-10
		return ((short)(Math.random()*11));
	}
	
	public static String RandomBreed(){
	// returns a random breed of dog		
		switch((int)(Math.random()*5)){
			case 0:
				return "chihuahua";
			case 1:
				return "dalmatian";
			case 2:
				return "pomeranian";
			case 3:
				return "beagle";
			default:
				return "poodle";
		}
	}
	
	
	public static void main(String[] args) {
		final int ZOO_SIZE = 10;  // Number of animals to be generated
		
		// Create an array of size ZOO_SIZE to house the animals
		Animal[] zoo = new Animal[ZOO_SIZE]; // All subclasses ISA superclass, so will fit in a zoo of Animals!
		
		// Iterate through the array using standard for loop to populate with random animals
		for(int i = 0; i < zoo.length; i++){
			switch((int)(Math.random()*4)){
				case 0:
					zoo[i] = new Fish(RandomColor());
					break;
				case 1:
					zoo[i] = new GuardDog(RandomColor(),RandomMean());
					break;
				case 2:
					zoo[i] = new Dog(RandomColor());
					break;
				default:
					zoo[i] = new ShowDog(RandomColor(),RandomBreed());
			}
		}
		
		// use enhanced for loop to iterate through array
		for(Animal animal: zoo){
			System.out.print(animal);
			animal.move();
			System.out.print(" and ");
			animal.makeSound();
			System.out.println(".");
		}
	}
}
