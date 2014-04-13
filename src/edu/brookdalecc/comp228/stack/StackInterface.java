package edu.brookdalecc.comp228.stack;

public interface StackInterface {
	Object popTop() throws StackUnderflowException;
	// Throws StackUnderflowException if this stack is empty,
	// otherwise removes and returns top element from this stack
	
	void pop() throws StackUnderflowException;
	// Throws StackUnderflowException if this stack is empty,
	// otherwise removes top element from this stack.
  
	Object top() throws StackUnderflowException;
	// Throws StackUnderflowException if this stack is empty,
	// otherwise returns top element from this stack.

	void push(Object element);
	// Places element at the top of this stack.
  
	boolean isEmpty();
	// Returns true if this stack is empty, otherwise returns false.
}
