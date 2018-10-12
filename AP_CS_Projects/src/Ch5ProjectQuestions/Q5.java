package Ch5ProjectQuestions;

import java.util.Random;
import java.util.Scanner;

public class Q5 {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int repeats = 5;
		
		System.out.println("Let's play rock paper scissors. (2: Rock, 1: Paper, 0: Scissors");
		
		for(int i = 0; i < repeats; i ++){
			
			int cChoice = rand.nextInt(3);
			System.out.println("What will you shoot?");
			int pChoice = scan.nextInt() % 3;
			String result = "";
			System.out.println(pChoice - cChoice);
			if(pChoice - cChoice < 0){
				result = ", you won!";
			}
			else if(pChoice - cChoice > 0){
				result = ", I won!";
			}
			else{
				result = ", we tied!";
			}
			
			System.out.println("You chose " + getVal(pChoice) + ", I chose " + getVal(cChoice) + result);
			
		}
		
	}
	
	static String getVal(int y){
		switch(y){
		case 2: return "Rock";
		case 1: return "Paper";
		default: return "Scissors";
		}
	}
	
}
