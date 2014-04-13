package edu.brookdalecc.comp228.book;
/* Terry Chern
 * Comp 228-800RL
 * 2 March 2014
 * Professor Kamp
 * Assignment 4: Book Class and Book-based Linked List
 */
public class LLBookNode {
	private Book book;
	private LLBookNode nextBookNode;
	
	public LLBookNode(Book book){ // Constructor takes a Book as its argument
		this.book = book; // Set data attribute of this node as Book passed in
		this.nextBookNode = null;
	}

	public Book getBookinfo() {
		return this.book; // Return the Book stored in this node
	}

	public void setBookinfo(Book book) {
		this.book = book; // Change the Book stored in this node
	}

	public LLBookNode getNextBook() {
		return this.nextBookNode; // Return a link to the next node
	}

	public void setNextBook(LLBookNode nextBookNode) {
		this.nextBookNode = nextBookNode; // Change the pointer to the next node
	}
	
	
}
