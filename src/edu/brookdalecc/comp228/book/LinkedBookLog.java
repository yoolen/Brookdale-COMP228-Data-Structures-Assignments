package edu.brookdalecc.comp228.book;
/* Terry Chern
 * Comp 228-800RL
 * 2 March 2014
 * Professor Kamp
 * Assignment 4: Book Class and Book-based Linked List
 */
public class LinkedBookLog implements BookLogInterface{
	protected String logName;
	protected LLBookNode log;
	
// Constructor	
	public LinkedBookLog(String name){
	// Constructor generates an empty linked list with name
		this.logName = name;
		this.log = null;
	}
	
// Accessors and Mutators
	public LLBookNode getLog() {
		return this.log;
	}	
	
	public void setLog(LLBookNode log) {
		this.log = log;
	}
	
	@Override
	public String getName() {
		return this.logName; // return name of the log
	}

// Methods from BookLogInterface
	@Override
	public void insert(Book book) {
	// Insert a new Book into the linked list.
		LLBookNode newNode = new LLBookNode(book); // Create a new node
		newNode.setNextBook(this.getLog());	// Assign the pointer of the new node to the current head of the linked list
		this.setLog(newNode); // Set the head of the linked list to the new node
	}

	@Override
	public int size() {
	// Step through the linked list and return the number of Books
		int nodes = 0;
		LLBookNode stepper = this.log; // Create a node reference to step through the linked list
		while(stepper != null){ // Keep going through the list until we've hit the end
			nodes++;
			stepper = stepper.getNextBook();
		}
		return nodes; // Return the number of books
	}

	@Override
	public boolean contains(Book book) {
	// Step through the linked list, searching for a specific book, if book is 
	// found return true, otherwise false. Uses Book.equals() method
		boolean found = false;
		LLBookNode stepper = this.log; // Create a node reference to step through the linked list
		while(!found && stepper != null){ // Keep searching until end of list or item found
			if(book.equals(stepper.getBookinfo())){ // Compare the two and see if you've found the book
				found = true; // If found set flag
			}
			else{
				stepper = stepper.getNextBook(); // Otherwise keep going
			}
		}
		return found; // Return the results!
	}

	@Override
	public void clear() {
	// Clear the linked list
		this.log = null; // And there it goes.
	}

	@Override
	public String toString(){
	// This method steps through the linked list and prints out the info of each 
	// book in each node of the linked list; uses StringBuilder.
		StringBuilder booklist = new StringBuilder(""); // Start with an empty StringBuilder
		LLBookNode stepper = this.log; // Create a node reference to step through the linked list.
		while(stepper != null){ // go through the linked list until the end!
			booklist.append(stepper.getBookinfo().toString()); // Use Book.toString() to get book info and append
			stepper = stepper.getNextBook(); // go to next node
		}
		return booklist.toString(); // Convert StringBuilder to String and return the listing!
	}

}
