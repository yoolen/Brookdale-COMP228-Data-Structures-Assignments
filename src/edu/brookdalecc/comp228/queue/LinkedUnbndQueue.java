package edu.brookdalecc.comp228.queue;
import java.util.ArrayList;
import java.util.List;

public class LinkedUnbndQueue implements QueueInterface {
  protected LLObjectNode front;   // reference to the front of this queue
  protected LLObjectNode rear;    // reference to the rear of this queue

  public LinkedUnbndQueue() {
    front = null;
    rear = null;
  }

  public void enqueue(Object element) { 
    LLObjectNode newNode = new LLObjectNode(element);
    if (rear == null)
      front = newNode;
    else
      rear.setLink(newNode);
    rear = newNode;
  }     

  public Object dequeue() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    } else {
      Object element;
      element = front.getInfo();
      front = front.getLink();
      if (front == null)
        rear = null;

      return element;
    }
  }
  
  // 25b. Write this operation as a new public method of the LinkedUnbndQueue class
  // Method: Return the object that the front is pointing to, throw an exception if
  // queue is empty.
  public Object front() throws QueueUnderflowException{
	  if(this.isEmpty()){
		  throw new QueueUnderflowException("Queue is empty!");
	  }
	  else{
		  return front.getInfo();
	  }
  }

  public boolean isEmpty() {              
    if (front == null) 
      return true;
    else
      return false;
  }
  
  	public int howMany() {
	// steps through the queue and counts number of nodes
  		int count = 0;
  		LLObjectNode iterator = front;
  		while(iterator != null){
  			count++;
  			iterator = iterator.getLink();
  		}
  		return count;
  	}
  

  public List toList() {
  // converts the contents of the queue into an ArrayList
	  ArrayList list = new ArrayList();
	  LLObjectNode iterator = front;
	  while(iterator != null){
		  list.add(iterator.getInfo());
		  iterator = iterator.getLink();
	  }
	  return list;
  }
  
  @Override
  public String toString(){
  // Steps through the queue and builds a string representation of the queue
  // using the toString methods of the objects in the queue.
	  StringBuilder output = new StringBuilder("Current Queue:\n");
	  LLObjectNode iterator = front;
	  int count = 1;
	  while(iterator!=null){
	      output.append(count);    		// Append method can only accept single input
	      output.append(". ");       	// so multiple lines must be used to format
	      output.append(iterator.getInfo()); // the resulting StringBuilder properly.
	      output.append("\n");
	      iterator = iterator.getLink();
	      count++;
	  }
	  return output.toString();
  }
}

