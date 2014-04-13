package edu.brookdalecc.comp228.queue;

/** 
* Defines a node to be used in ADTs
*/
public class LLObjectNode {
  /**
   * reference to another link
   */
  private LLObjectNode link;

  /**
   * reference to object housed in this node
   */
  private Object info;
  
  /**
   * Constructs a node
   * @param object to be stored
   */
  public LLObjectNode(Object info) {
    this.info = info;
    link = null;
  }
 
  /** 
   * Sets the info in the node
   * @param node to store
   */
  public void setInfo(Object info) {
    this.info = info;
  }

  /** 
   * Gets the info in the node
   * @return node stored
   */
  public Object getInfo() {
    return info;
  }
 
   /** 
   * Sets the link
   * @param node to link to
   */
  public void setLink(LLObjectNode link) {
    this.link = link;
  }

  /** 
   * Gets the next link
   * @return link
   */
  public LLObjectNode getLink() {
    return link;
  }
}
