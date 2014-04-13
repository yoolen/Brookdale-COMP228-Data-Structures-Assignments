package edu.brookdalecc.comp228.stack;

public class LLObjectNode {
  private LLObjectNode link;
  private Object info;
  
  public LLObjectNode(Object info) {
    this.info = info;
    link = null;
  }
 
  public void setInfo(Object info) {
  // Sets info Object of this LLObjectNode.
    this.info = info;
  }

  public Object getInfo() {
  // Returns info Object of this LLObjectNode.
    return info;
  }
 
  public void setLink(LLObjectNode link) {
  // Sets link of this LLObjectNode.
    this.link = link;
  }

  public LLObjectNode getLink() {
  // Returns link of this LLObjectNode.
    return link;
  }
}
