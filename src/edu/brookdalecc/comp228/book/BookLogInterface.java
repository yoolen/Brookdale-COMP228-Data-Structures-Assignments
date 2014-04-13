package edu.brookdalecc.comp228.book;
/* Terry Chern
 * Comp 228-800RL
 * 2 March 2014
 * Professor Kamp
 * Assignment 4: Book Class and Book-based Linked List
 */
public interface BookLogInterface {
	void insert(Book book); // Places book into this BookLog.
	int size(); // Returns the number of Strings in this BookLog.
	boolean contains(Book book); // Returns true if element is in BookLog; must be exact match (defined in Book class).
	void clear(); // Makes this BookLog empty.
	String getName(); // Returns the name of this BookLog.
	String toString();  // Returns a nicely formatted string representing this StringLog.
}
