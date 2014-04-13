package edu.brookdalecc.comp228.linkedlist;

import java.util.Arrays;

public class LinkedStringLog implements StringLogInterface 
{
  protected LLStringNode log; // reference to first node of linked 
                              // list that holds the StringLog strings
  protected String name;      // name of this StringLog
  
  public LinkedStringLog(String name)
  // Instantiates and returns a reference to an empty StringLog object 
  // with name "name".
  {
    log = null;
    this.name = name;
  }

  public void insert(String element)
  // Precondition:   This StringLog is not full.
  //
  // Places element into this StringLog.
  {      
    LLStringNode newNode = new LLStringNode(element);
    newNode.setLink(log);
    log = newNode;
  }

  public boolean isFull()
  // Returns true if this StringLog is full, false otherwise.
  {              
    return false;
  }
  
  public int size()
  // Returns the number of Strings in this StringLog.
  {
    int count = 0;
    LLStringNode node;
    node = log;
    while (node != null)
    {
      count++;
      node = node.getLink();
    }
    return count;
  }
  
  public boolean contains(String element)
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case difference when doing string comparison.
  {                 
    LLStringNode node;
    node = log;
    boolean found = false;
    boolean moreToSearch;
    moreToSearch = (node != null);

    while (moreToSearch && !found) 
    {
      if (element.equalsIgnoreCase(node.getInfo()))  // if they match
        found = true;
      else
      {
        node = node.getLink();
        moreToSearch = (node != null);
      }
    }

   return found;
  }
  
  public void clear()
  // Makes this StringLog empty.
  { 
    log = null;
  }

  public String getName()
  // Returns the name of this StringLog.
  {
    return name;
  }

/* Assignment methods: logAsArray(), isEmpty(), howMany(), uniqInsert(), smallest()
 * public String[] logAsArray(); returns an array containing all strings in log, precondition: list not empty
 * public boolean isEmpty(); returns true if StringLog is empty, false otherwise
 * public int howMany(String element); returns an int indicating number of instances of element in StringLog
 * public boolean uniqInsert(String element); insert element into StringLog if unique and return true, otherwise do nothing and return false
 * public String smallest(); returns the smallest string (using String's compareTo), precondition: list not empty.
 */
  
  public String[] logAsArray(){
  /* This method converts the linked list into an array and then returns the array. 
   * Precondition: list not empty. In theory, as long as we do not try to access elements
   * in this array directly via indexing we can convert an empty list into an array, it
   * will just be returning a reference to an array of size 0 (which works for some reason).
   */
	  LLStringNode node = log;
	  String[] values = new String[this.size()]; // Dynamically sized array using class's size method
	  for(int index = 0; index < values.length; index++){
		  values[index] = node.getInfo();
		  node = node.getLink();
	  }
	  return values;
  }
  
  public boolean isEmpty(){
	  return (this.size()==0); // returns true if size 0, false otherwise.
	  // could also implement this by checking if first node is null!
	  // return(this.log == null);
  }
  
  public int howMany(String element){
  /* This method will traverse the linked list and search for instances of element, each
   * instance will cause a counter to be incremented. This counter will then be returned
   * at the end of the method. The contains() method is actually a specific case of this
   * method (where it's only concerned with if there's at least 1 instance of element).
   */
	  int count=0;
	  LLStringNode node = log; // Point to the start of the linked list.
	  while(node != null){ // Do this until the end of the list
		  if(node.getInfo() == element){ // On match, increment counter
			  count++;
		  }
		  node = node.getLink(); // go to next node.
	  }  
	  return count; // return number of instances of element.
  }
  
  public boolean uniqInsert(String element){
  /* This method will make use of the insert() and contains() methods already 
   * provided with the class. It will insert element into StringLog if unique 
   * and return true, otherwise do nothing and return false.
   */
	  if(this.contains(element)){ // if element already exists do nothing.
		  return false;
	  }
	  else{ // otherwise insert the element
		  this.insert(element);
		  return true;
	  }
  }
  
  public String smallest(){ 
  /* This method steps through the linked list and compares the information stored
   * in each node using the compareTo method provided in the String class. Each time
   * a smaller word is discovered, that word becomes the new smallest and we continue
   * until the end of the list. Then we return the smallest word. Precondition is 
   * that the list isn't empty.
   */
	  LLStringNode node = log;
	  String smallest = node.getInfo(); // initialize this to the first value in the list.
	  while(node != null){
		  if(node.getInfo().compareTo(smallest) < 0){ // compareTo returns -1 0 1 for < = > respectively.
			  smallest = node.getInfo();
		  }
		  node = node.getLink();
	  }
	  return smallest;
  }
  
  public String smallestByArray(){
  /* I'm unsure if this version of the method would actually be better, because
   * there would be the additional overhead of converting a linked list into an
   * array, but in doing so we'd be able to use the sort() methods of the array
   * class to quickly pull the smallest value of the linked list. 
   * 
   * I guess it would depend on if you kept the array instead of just generating 
   * it each time because you'd be parsing the linked list anyway. 
   * 
   * Just thought I'd toss this in for completeness.
   */
	  String[] sorted = this.logAsArray(); // Was trying to figure out a 1-liner for this
	  Arrays.sort(sorted);                 // but had to split it up in the end.
	  return(sorted[0]); 
	  // Precondition is that the list is not empty, index out of bounds error here if it is.
  }

  public String toString()
  // Modified method to use StringBuilder class (conserves stack space).
  {
    StringBuilder logString = new StringBuilder("Log: " + name + "\n");
    LLStringNode node;
    node = log;
    int count = 0;
    
    while (node != null)
    {
      count++;			
      logString.append(count);    		// Append method can only accept single input
      logString.append(". ");       	// so multiple lines must be used to format
      logString.append(node.getInfo()); // the resulting StringBuilder properly.
      logString.append("\n");
      node = node.getLink();
    }
    return logString.toString();
  }
}