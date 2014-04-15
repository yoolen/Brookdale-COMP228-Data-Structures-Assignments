package edu.brookdalecc.comp228.trees;

public interface BSTInterface {
  // used to specify traversal order
  static final int INORDER = 1;
  static final int PREORDER = 2;
  static final int POSTORDER = 3;

  boolean isEmpty();
  // Returns true if this BST is empty; otherwise, returns false.
  
  int size();
  // Returns the number of elements in this BST.

  boolean contains (Comparable element);
  // Returns true if this BST contains an element e such that 
  // e.compareTo(element) == 0; otherwise, returns false.
    
  boolean remove (Comparable element);
  // Removes an element e from this BST such that e.compareTo(element) == 0
  // and returns true; if no such element exists, returns false. 
  
  Comparable get(Comparable element);
  // Returns an element e from this BST such that e.compareTo(element) == 0;
  // if no such element exists, returns null.

  void add (Comparable element);
  // Adds element to this BST. The tree retains its BST property.
}
