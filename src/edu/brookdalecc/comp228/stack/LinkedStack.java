package edu.brookdalecc.comp228.stack;

/* Terry Chern
 * Comp 228-800RL
 * 8 March 2014
 * Professor Kamp
 * Assignment 5: Linked Stacks
 * 
 * 39. Create a toString method for the LinkedStack Class. This method should
 * create and return a string that correctly represents the current stack. Such
 * a method could prove useful for testing and debugging the LinkedStack class
 * and for testing and debugging applications that use the LinkedStack class.
 * 42. We decide to add a new operation to our Stack ADT called popTop. We add
 * the following code to our StackInterface interface:
 * 	public Object popTop() throws StackUnderflowException;
 * 	// Throws StackUnderflowException if this stack is empty,
 * 	// otherwise removes and returns top element from this stack
 * An operation like this is often included for stacks. Implement the popTop
 * method for the LinkedStack class.
 * 43b. Suppose we decide to add a new operation to our Stack ADT called sizeIs,
 * which returns a value of primitive type int equal to the number of items on
 * the stack. The method signature for sizeIs is
 * 	public int sizeIs();
 * Write the code for sizeIs for the LinkedStack class (do not add any instance
 * variables to the class; each time sizeIs is called you must "walk" through
 * the stack and count the nodes).
 */

public class LinkedStack implements StackInterface {
  protected LLObjectNode top;   // reference to the top of this stack

  public LinkedStack() {
    top = null;
  }

  public void push(Object element) {
  // Places element at the top of this stack.
    LLObjectNode newNode = new LLObjectNode(element);
    newNode.setLink(top);
    top = newNode;
  }     

  public void pop() throws StackUnderflowException {
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
    if (!isEmpty()) {
      top = top.getLink();
    } else {
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    }
  }

  public Object top() throws StackUnderflowException {
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element from this stack.
    if (!isEmpty()){
    	return top.getInfo();
    }
    else{
    	throw new StackUnderflowException("Top attempted on an empty stack.");
    }
  }

  public boolean isEmpty() {
  // Returns true if this stack is empty, otherwise returns false.
    if (top == null) 
      return true;
    else
      return false;
  }
  
// Additional Methods
  @Override
  public String toString(){
  // 39. This method creates and returns a string that correctly 
  // represents the current stack.
	  StringBuilder output = new StringBuilder();
	  LLObjectNode traverse = top;
	  while(traverse != null){
		  output.append(traverse.getInfo());
		  output.append("\n");
		  traverse = traverse.getLink();
	  }
	  return output.toString();
  }
  
  public Object popTop() throws StackUnderflowException{
  // 42. Throws StackUnderflowException if this stack is empty,
  // otherwise removes and returns top element from this stack	  
	if (!isEmpty()){
		Object topVal = top.getInfo(); 	// Need to save this value before popping
		top = top.getLink();			// or it would be lost at this step
		return topVal;					// had we just done the top operation.
	} else {
		throw new StackUnderflowException("PopTop attempted on an empty stack.");
	}
  }
  
  public int sizeIs(){
  // returns a value of type int equal to the number of items on the stack.
	  int elements = 0;
	  LLObjectNode traverse = top;
	  while(traverse != null){
		  elements++;
		  traverse = traverse.getLink();
	  }
	  return elements;
  }
}
