package edu.brookdalecc.comp228;

public class EnhancedFor{
	final static int SIZE = 10;
	
	public static void main(String[] args) {
		int[] testArray = new int[SIZE];
		for (int i = 0; i < SIZE; i++){
			testArray[i]=(int)(Math.random()*10);
		}
		for (int i: testArray){
			System.out.println(testArray[i]);
		}
	}

}
