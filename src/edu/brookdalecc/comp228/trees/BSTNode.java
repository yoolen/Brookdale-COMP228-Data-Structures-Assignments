package edu.brookdalecc.comp228.trees;

public class BSTNode {
  protected Comparable info;       // The info in a BST node
  protected BSTNode left;          // A link to the left child node
  protected BSTNode right;         // A link to the right child node

  public BSTNode(Comparable info) {
    this.info = info;
    left = null;
    right = null;
  }
 
  public void setInfo(Comparable info) {
    this.info = info;
  }

  public Comparable getInfo() {
    return info;
  }
 
  public void setLeft(BSTNode link) {
    left = link;
  }

  public void setRight(BSTNode link) {
    right = link;
  }

  public BSTNode getLeft() {
    return left;
  }

  public BSTNode getRight() {
    return right;
  }
}
