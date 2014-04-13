package edu.brookdalecc.comp228.queue;

import edu.brookdalecc.comp228.book.*;
import java.util.*;

/*	Chapter 5
 *  Array-based Implementations
 * 	17. Write a segment of code (application level) to perform each of the following
 * 	operations. Assume myQueue is an object of the class ArrayUnbndQueue. You may call
 * 	any of the public methods. You may also declare additional queue objects.
 * 	a) Set secondElement to the second element from the beginning of myQueue, leaving
 * 	myQueue without its original two front elements.
 *  b) Set rear equal to the rear element in myQueue, leaving myQueue empty.
 *  c) Set rear equal to the rear element in myQueue, leaving myQueue unchanged.
 *  d) Print out the contents of myQueue, leaving myQueue unchanged.
 *  Link-based Implementations
 *  24. Describe the effects each of the following changes would have on the LinkedBndQueue class.
 *  a) In the constructor, change "rear = null" to "rear = front"
 *  b) In the enqueue method, move the last statement "rear = newNode" to just before the if statement.
 *  c) In the enqueue method, change the boolean expression "rear = null" to "front == null"
 *  d) In the dequeue method, switch the second and third statements in the else clause.
 *  25. Given the following specification of a front operation for queue:
 *  	Effect: Returns a reference to the front element on the queue.
 *  	Precondition: Queue is not empty.
 *  a) Write this operation as client code, using operations from the LinkedUnbndQueue class.
 *  (Remember, the client code has no access to the non-public variables of the class).
 *  b) Write this operation as a new public method of the LinkedUnbndQueue class.
 *  26. Consider a toString method for a queue that would create and return a string
 *  that nicely represents the current queue. Assume each enqueued object already provides
 *  its own reasonable toString method that you can invoke from the queue's toString
 *  method. Design, code, and test a toString method for the LinkedUnbndQueue class.
 */

public class UseQueue {
	static final String first = "first", second = "second", third = "third", last = "last";
	
	private UseQueue(){}; // do not allow people to instantiate this class
	
	public static LinkedUnbndQueue buildTestQueue(){ 
	// Build a fresh queue to test on.
		LinkedUnbndQueue queue = new LinkedUnbndQueue();    
		queue.enqueue(first);
		queue.enqueue(second);
		queue.enqueue(third);
		queue.enqueue(last);
		return queue;
	}
	
	public static void printQueue(LinkedUnbndQueue myQueue){ 
	// 17d. Print out the contents of myQueue, leaving myQueue unchanged.
	// Method: Use toList method to convert queue into a list and print
	// out the contents without modifying myQueue.
	// Also makes use of howMany and toList methods!
		List list = myQueue.toList();
		System.out.printf("Queue Contents: %d elements\n",myQueue.howMany());
		for (Iterator it = list.iterator (); it.hasNext (); ) {
			Object o = it.next ();
			System.out.println(o);
		}
	}
	
	public static void main(String args[]) {
	// Build and populate a LinkedUnbndQueue.
		LinkedUnbndQueue myQueue;
		myQueue = buildTestQueue();
		LLObjectNode rear = new LLObjectNode(null); // Create a node to hold values
		
		// 17a. Set secondElement to the second element from the beginning 
		// leaving myQueue without its original two front elements.
		// Method: dequeue twice.
		System.out.println("17a.");
		printQueue(myQueue);
		try{
			myQueue.dequeue();
			myQueue.dequeue();
		}catch(QueueUnderflowException que){
			System.err.println(que.getMessage());
		}
		printQueue(myQueue);
		
		// 17b. Set rear equal to the rear element in myQueue, leaving myQueue empty.
		// Method: dequeue until empty. 
		System.out.println("\n17b.");
		printQueue(myQueue);
		while(!myQueue.isEmpty()){ // keep going until queue is empty
			try{
				rear.setInfo(myQueue.dequeue());
			}catch(QueueUnderflowException que){
				// this will never happen because of the test condition
			} 
		}
		System.out.printf("Rear is: %s\n", rear.getInfo());
		printQueue(myQueue);
		
		// 17c. Set rear equal to the rear element in myQueue, leaving myQueue unchanged.
		// Method: Rebuild the queue so we have stuff to work with; then dequeue into 
		// a tempQueue, then set myQueue to the tempQueue.
		myQueue = buildTestQueue();
		LinkedUnbndQueue tempQueue;
		tempQueue = new LinkedUnbndQueue(); // temp queue
		System.out.println("\n17c.");
		printQueue(myQueue);
		while(!myQueue.isEmpty()){
			try{
				rear.setInfo(myQueue.dequeue());
				tempQueue.enqueue(rear.getInfo());	
			}catch(QueueUnderflowException que){
				// this will never happen because of the test condition
			} 
		}
		myQueue = tempQueue;	
		System.out.printf("Rear is: %s\n", rear.getInfo());
		printQueue(myQueue);
	
	//  25. Given the following specification of a front operation for queue:
	// 	Effect: Returns a reference to the front element on the queue.
	// 	Precondition: Queue is not empty.
	// 	a) Write this operation as client code, using operations from the LinkedUnbndQueue class.
	//   (Remember, the client code has no access to the non-public variables of the class).
	//	Method: Similar to 17c. Create a node. Dequeue the front of the queue into it to hold the value,
	//	assuming the queue isn't empty; then enqueue this value into a holding queue, dequeue
	//	the remaining elements of the original queue into the temporary queue. Lastly set
	//  the queue to the temporary queue.
		System.out.println("\n25a.");
		LLObjectNode front = new LLObjectNode(null);
		tempQueue = new LinkedUnbndQueue();
		printQueue(myQueue);
		try{
			front.setInfo(myQueue.dequeue());
			tempQueue.enqueue(front.getInfo());
			while(!myQueue.isEmpty()){
				tempQueue.enqueue(myQueue.dequeue());
			}
		}catch(QueueUnderflowException que){
			System.err.println(que.getMessage());
		}
		myQueue = tempQueue;
		System.out.printf("Front is: %s\n",front.getInfo());
		printQueue(myQueue);
	// 25b. Write this operation as a new public method of the LinkedUnbndQueue class
		System.out.println("\n25a.");
		front = new LLObjectNode(null); // reset front
		try 
		{
			front.setInfo(myQueue.front());
		} catch (QueueUnderflowException que) {
			System.err.println(que.getMessage());
		}
		System.out.printf("Front is: %s\n",front.getInfo());
	// 26. toString() method
		System.out.println(myQueue);
	}
}
