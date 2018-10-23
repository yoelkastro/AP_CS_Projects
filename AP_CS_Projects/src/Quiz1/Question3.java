package Quiz1;

import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int in = -1;
		ArrayList<Integer> vals = new ArrayList<Integer>();
		
		System.out.println("Enter values, one at a time. Enter \'0\' to end entering values.");
		
		while(in != 0){
			System.out.print("? ");
			in = scan.nextInt();
			if(in >= 0){
				vals.add(in);
			}
		}
		
		int[] largestSecondLargest = new int[2];
		largestSecondLargest[0] = findLargest(vals);
		vals.remove((Integer) largestSecondLargest[0]);
		largestSecondLargest[1] = findLargest(vals);
		
		System.out.println("The largest value is " + largestSecondLargest[0] + "\nThe second largest value is " + largestSecondLargest[1]);
		
		scan.close();
		
	}
	
	static int findLargest(ArrayList<Integer> t){
		
		int ret = t.get(0);
		for(int i = 0; i < t.size(); i ++){
			if(t.get(i) > ret) ret = t.get(i);
		}
		return ret;
		
	}
	
}
