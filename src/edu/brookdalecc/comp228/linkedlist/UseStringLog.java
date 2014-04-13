package edu.brookdalecc.comp228.linkedlist;
//----------------------------------------------------------------------------
// UseStringLog.java           by Dale/Joyce/Weems                   Chapter 2
//
// Simple example of the use of a StringLog.
//----------------------------------------------------------------------------

public class UseStringLog
{
  public static void main(String[] args)
  { 
    LinkedStringLog log;
	 log = new LinkedStringLog("Example Use");
    log.insert("Elvis");
    log.insert("King Louis XII");
    log.insert("Captain Kirk");
    System.out.println(log);
    System.out.println("The size of the log is " + log.size());
    System.out.println("Elvis is in the log: " + log.contains("Elvis"));
    System.out.println("Santa is in the log: " + log.contains("Santa"));
  }
}
