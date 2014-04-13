package edu.brookdalecc.comp228.queue;

public interface QueueInterface {

  Object dequeue() throws QueueUnderflowException;
  
  void enqueue(Object element);
  
  boolean isEmpty();
}




