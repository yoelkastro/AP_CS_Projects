package Ch8ProjectQuestions;

import java.util.Scanner;

public class Q5 {

	static int turns = 0;
	
	static char getVal(int x){
		switch(x){
		case 1: return 'x';
		case 2: return 'o';
		default: return ' ';
		}
	}
	
	static void printBoard(int[][] x){
		
		System.out.println(" " + getVal(x[0][0]) + " ║ " + getVal(x[0][1]) + " ║ " + getVal(x[0][2]));
		for(int i = 1; i < 3; i ++){
			System.out.println("═══╬═══╬═══");
			System.out.println(" " + getVal(x[i][0]) + " ║ " + getVal(x[i][1]) + " ║ " + getVal(x[i][2]));
		}
		
	}
	
	static boolean hasWon(int[][] x){
		
		for(int i = 0; i < 3; i ++){
			if(x[i][0] == x[i][1] && x[i][1] == x[i][2] && x[i][0] != 0|| x[0][i] == x[1][i] && x[1][i] == x[2][i] && x[0][i] != 0){
				printBoard(x);
				System.out.println(getVal((turns % 2) + 1) + " wins!");
				return true;
			}
		}
		for(int i = 0; i < 5; i += 2){ //Çalışmıyor
			if(x[i % 3][0] == x[(i + 1) % 3][1] && x[(i + 1) % 3][1] == x[(i + 2) % 3][2] && x[i % 3][0] != 0){
				printBoard(x);
				System.out.println(getVal((turns % 2) + 1) + " wins!");
				return true;
			}
		}
		
		int count = 0;
		for(int i = 0; i < x.length; i ++){
			for(int t = 0; t < x[0].length; t ++){
				if(x[i][t] != 0){
					count ++;
				}
			}
		}
		if(count == (x.length * x[0].length)){
			System.out.println("Draw!");
			System.exit(0);
		}
		
		return false;
		
	}
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int[][] board = new int[3][3];
		
		while(!hasWon(board)){
			printBoard(board);
			System.out.print("x position: ");
			int x = scan.nextInt();
			System.out.print("y position: ");
			int y = scan.nextInt();
			
			if(board[y][x] == 0){
				board[y][x] = (turns % 2) + 1;
				turns ++;
			}
			
		}
		
	}
	
}
