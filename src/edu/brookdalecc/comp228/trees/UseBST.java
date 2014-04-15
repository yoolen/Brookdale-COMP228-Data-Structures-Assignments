package edu.brookdalecc.comp228.trees;
/* Terry Chern
 * Comp 228-800RL
 * 15 April 2014
 * Assignment 8 - Binary Search Tree
 */

import edu.brookdalecc.comp228.book.*;


public class UseBST {
	

  public static void main(String args[]) {
    BinarySearchTree bst = new BinarySearchTree();
    Book b1 = null;
    Book b2 = null;
    Book b3 = null;
    Book b4 = null;
    Book b5 = null;
    Book b6 = null;
    Book b7 = null;
    Book b8 = null;
    Book b9 = null;
    Book b10 = null;
    
	try{ // compareTo method sorts by Title,Pages, Hardback, Price
		b1 = new Book(300,true,"Redwall",9.99);
		b2 = new Book(300,false,"The Girl with the Dragon Tattoo",10.99);
		b3 = new Book(400,false,"Red Dragon",8.99);
		b4 = new Book(200,false,"Where the Red Fern Grows",3.99);
		b5 = new Book(250,true,"Where's Waldo",8.45);
		b6 = new Book(123,false,"The Return of the King",10.99);
		b7 = new Book(456,true,"The Lion, the Witch, and the Wardrobe",18.40);
		b8 = new Book(789,false,"A Wrinkle in Time",7.99);
		b9 = new Book(102,true,"Dune",4.93);
		b10 = new Book(304,false,"Ender's Game",5.46);
	} catch(BookException be){
		System.err.println(be.getMessage());
	}
    
    
    
    
    bst.add(new Integer(20));
    bst.add(new Integer(18));
    bst.add(new Integer(80));
    bst.add(new Integer(8));
    bst.add(new Integer(0));
    bst.add(new Integer(10));
    bst.add(new Integer(12));
    bst.add(new Integer(1));
    bst.add(new Integer(2));
    bst.add(new Integer(22));
    bst.printInOrder();
    // System.out.println(bst.min());
    // System.out.println(bst.max());
	
  }
}
