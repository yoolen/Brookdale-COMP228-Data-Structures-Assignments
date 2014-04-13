package edu.brookdalecc.comp228.stack;
import edu.brookdalecc.comp228.book.*;

public class UseLinkedStack {
// LinkedStack has the following methods:
// push(); pop(); top(); isEmpty(); toString(); popTop(); sizeIs(); 
	public static void main(String[] args) throws StackUnderflowException {
		LinkedStack stack = new LinkedStack();
		Book b1 = null, b2 = null, b3 = null, b4 = null, b5 = null;
		try{ // Test title preconditions using constructor
			b1 = new Book(90, true, "Lord of the Flies", 8.99); // This is okay
			b2 = new Book(287, true, "Catcher in the Rye", 4.99);
			b3 = new Book(500, false, "Wicked", 29.95);
			b4 = new Book(299, false, "Choke", 9.98);
			b5 = new Book(1010, true, "War and Peace", 10.98);
		}catch(BookException be){
			System.err.println(be.getMessage());
		}
		
		// Test isEmpty()
		System.out.println(String.format("The stack is %s.\n", stack.isEmpty()?"empty":"not empty"));
		
		// Test push()
		stack.push(b1);
		stack.push(b2);
		stack.push(b3);
		System.out.println("Pushed 3 books.\n");
		
		System.out.println(String.format("The stack is %s.\n", stack.isEmpty()?"empty":"not empty."));
		// Test toString()
		System.out.println("-Books in Stack-\n");
		System.out.println(stack);
		System.out.println("----------------\n");
		
		// Test top()
		try{
			System.out.println(String.format("The top element is:\n%s\n",stack.top()));
		}catch(StackUnderflowException sue){
			System.err.println(sue.getMessage());
		}
		System.out.println("----------------\n");
		
		// Test pop()
		System.out.println("--Now Popping---\n");
		try{
			stack.pop();
		}catch(StackUnderflowException sue){
			System.err.println(sue.getMessage());
		}
		try{
			System.out.println(String.format("The top element is:\n%s\n",stack.top()));
		}catch(StackUnderflowException sue){
			System.err.println(sue.getMessage());
		}
		System.out.println("----------------\n");
		
		// Add 2 new books
		System.out.println("--Push 2 Books--\n");
		stack.push(b4);
		stack.push(b5);
		System.out.println("-Books in Stack-\n");
		System.out.println(stack);
		
		// Test popTop()
		System.out.println("--Test popTop---\n");
		try{
			System.out.println(String.format("The top element was:\n%s\n",stack.popTop()));
		}catch(StackUnderflowException sue){
			System.err.println(sue.getMessage());
		}
		
		// Test sizeIs()
		System.out.println("----------------\n");
		System.out.println(String.format("There are %d elements in this stack.", stack.sizeIs()));
		System.out.println(stack);
	}

}
