package Ch5ProjectQuestions;

import java.util.Random;
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args){
		
		int upper = 10;
		int lower = 0;
		
		Scanner scan = new Scanner(System.in);
		char in = ' ';
		char range;
		
		Random rand = new Random();
		
		while(in != 'y'){
			in = ' ';
			range = ' ';
			
			int guess = rand.nextInt(upper - lower) + lower + 1;
			
			System.out.print("Is your number " + guess + "? (y/n)");
			
			while(in != 'n' && in != 'y'){
				in = scan.next().charAt(0);
				System.out.println(in);
				
			}
			if(in == 'y'){
				break;
			}
			
			System.out.print("Higher or lower? (h/l)");
			
			while(range != 'h' && range != 'l'){
				range = scan.next().charAt(0);
			}
			switch(range){
			case 'h':	lower = guess; break;
			case 'l':	upper = guess; break;
			}
			
		}
		
	}
	
}
