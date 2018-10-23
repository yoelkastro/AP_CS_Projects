package Quiz1;

import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in); //Initialize Scanner for user input
		
		int in = -1;	//Create the variable to check and save the user input
		ArrayList<Integer> vals = new ArrayList<Integer>();	//Create a list of all inputs
		
		System.out.println("Enter values, one at a time. Enter \'0\' to end entering values.");
		
		while(in != 0){		//Repeats until the user enters '0'
			System.out.print("? ");
			in = scan.nextInt();	//Scan the user input and assign it to in
			if(in >= 0){	//Add the user input value to the list only if it is a positive integer
				vals.add(in);
			}
		}
		
		int[] largestSecondLargest = new int[2];	//Create an array to put the largest and second largest values in
		largestSecondLargest[0] = findLargest(vals);	//Find the largest value
		vals.remove((Integer) largestSecondLargest[0]);	//Remove the largest value
		largestSecondLargest[1] = findLargest(vals);	//Find the largest value again to get the second larges value
	
		System.out.println("The largest value is " + largestSecondLargest[0] + "\nThe second largest value is " + largestSecondLargest[1]);
		
		scan.close();
		
	}
	
	static int findLargest(ArrayList<Integer> t){	//Finds the largest value in an ArrayList
		
		int ret = t.get(0);	//Create a variable to store the largest value in, initialize it as the first value in the list
		
		for(int i = 0; i < t.size(); i ++){
			if(t.get(i) > ret) ret = t.get(i);	//Cycle through each value in the list and compare it to the last largest value
		}
		return ret;	//Return the largest value
		
	}
	
}
