package edu.brookdalecc.comp228.book;
/* Terry Chern
 * Comp 228-800RL
 * 26 February 2014
 * Professor Kamp
 * Assignment 3: Book Class
 */

public class BookException extends Exception{
	
	public BookException(){	}
	
	public BookException(String errMsg) {
		super(errMsg); // Use parent constructor because Exception error message is private
	}

}
