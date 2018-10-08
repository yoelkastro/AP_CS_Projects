package Ch8ProjectQuestions;

import java.util.Random;
import java.util.Scanner;

public class Q3 {

	public static void main(String[] args){
		
		int[] code = new int[4];
		Scanner scan = new Scanner(System.in);
		
		String codeS = "";
		
		for(int i = 0; i < 4; i ++){
			code[i] = new Random().nextInt(10);
			codeS += code[i];
		}
		
		System.out.println("MasterMind -\n0: Wrong digit, wrong place\t1: Right digit, wrong place\t2: Right digit, right place\nTry to guess the number");
		
		String ans = "";
		
		while(!ans.equals(codeS)){
			
			ans = scan.nextLine();
			ans = ans.replaceAll(" ", "");
			for(int i = 0; i < 4; i ++){
				int res = 0;
				if(codeS.contains(Character.toString(ans.charAt(i)))){
					if(codeS.charAt(i) == ans.charAt(i)){
						res ++;
					}
					res ++;
				}
				
				System.out.print(res + " ");
			}
			System.out.println();
		}
		
		System.out.println("You Win!");
		
	}
	
}
