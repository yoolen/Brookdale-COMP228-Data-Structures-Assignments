package edu.brookdalecc.comp228.stack;

public class StackUnderflowException extends Exception {
  public StackUnderflowException() {
    super();
  }

  public StackUnderflowException(String message) {
    super(message);
  }
}
