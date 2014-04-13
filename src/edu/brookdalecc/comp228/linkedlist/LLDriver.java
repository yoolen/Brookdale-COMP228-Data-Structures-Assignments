package edu.brookdalecc.comp228.linkedlist;
/* Terry Chern
 * Comp 228-800RL
 * 25 February 2014
 * Rolf Kamp
 * Linked List Driver
 * Method: This driver class will create a linked list then populate it using the 
 * pre-packaged class methods as well as the 5 new functions implemented per the
 * assignment and exercises from the end of the chapter:
 * public String[] logAsArray(); returns an array containing all strings in log, precondition: list not empty
 * public boolean isEmpty(); returns true if StringLog is empty, false otherwise
 * public int howMany(String element); returns an int indicating number of instances of element in StringLog
 * public boolean uniqInsert(String element); insert element into StringLog if unique and return true, otherwise do nothing and return false
 * public String smallest(); returns the smallest string (using String's compareTo), precondition: list not empty.
 */
public class LLDriver{

	public static void main(String[] args){
		String[] initVals = {"Apple","Banana","Coconut","Durian","Elderberry","Fig","Grapefruit","Honeydew",
				"Jujube","Kumquat","Lingonberry","Mango","Nectarine","Orange","Passionfruit","Quince",
				"Raspberry","Strawberry","Tangerine","Watermelon"}; // A table of fruits to fill our linked list
		LinkedStringLog log = new LinkedStringLog("LLTest"); // Creates an empty Linked List Log
		String element1 = "Kumquat", element2 = "Kiwi";

// Testing isEmpty() and modified toString		
		System.out.println("The log is " + (log.isEmpty()?"empty.":"not empty.")); // Empty!
		for(String fruit:initVals){ // Populate the linked list with fruit names!
			log.insert(fruit);
		}
		System.out.println("The log is " + (log.isEmpty()?"empty.":"not empty.")); // Not empty!
		System.out.println(log); // Make sure the data is right using the StringBuilder version of toString

// Testing uniqInsert()	and howMany()
		System.out.println(String.format("There are %d instances of the word %s.",log.howMany(element1),element1));
		log.insert("Kumquat"); // Let's add another Kumquat to the list!
		System.out.println(String.format("There are %d instances of the word %s.",log.howMany(element1),element1));
		log.uniqInsert("Kumquat"); // Let's try adding another Kumquat using uniqInsert()
		System.out.println(String.format("There are %d instances of the word %s.",log.howMany(element1),element1));
		
		System.out.println(String.format("There are %d instances of the word %s.",log.howMany(element2),element2));
		log.uniqInsert(element2); // Let's add a Kiwi to the list using uniqInsert()
		System.out.println(String.format("There are %d instances of the word %s.\n",log.howMany(element2),element2));
		
// Testing smallest()
		System.out.println(String.format("The smallest word in the list is %s.\n",log.smallest())); // Should give us Apple.
		
// Testing logAsArray()
		String[] link2log = log.logAsArray(); // make an array using the linked list using logAsArray() method.
		for(String element:link2log){
			System.out.println(element); // The print out should  have all the new elements we added (1 extra Kumquat and Kiwi at the start)
		}
		
	}

}
