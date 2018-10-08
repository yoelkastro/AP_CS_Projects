package Ch8ProjectQuestions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) throws IOException{
		
		Scanner scan = new Scanner(System.in);
		File f = new File("src/words.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		int fLength = 0;
		br.mark(200000);
		while(br.readLine() != null){
			fLength ++;
		}
		
		Random rand = new Random();
		int w = rand.nextInt(fLength);
		
		fLength = 0;
		br.reset();
		while(fLength != w){
			fLength ++;
			 br.readLine();
		}
		
		char[] word = br.readLine().toCharArray();
		char[] guessed = new char[26];
		int guesses = 0;
		
		char[] game = new char[word.length];
		for(int i = 0; i < game.length; i ++){
			game[i] = '_';
		}
		
		while(cont(word, game)){
			
			System.out.println(game);
			
			char guess = scan.nextLine().charAt(0);
			if(Character.isAlphabetic((int) guess)){
				if(!contains(guessed, guess)){
					
					guesses ++;
					guessed[guesses] = guess;
					for(int i = 0; i < word.length; i ++){
						if(word[i] == guess){
							game[i] = guess;
						}
					}
					
				}
				else{
					System.out.println("Has been guessed before");
				}
			}
			else{ 
				System.out.println("Not alphabetic");
			}
			
			if(guesses > 30){
				System.out.println("You Lose");
				System.exit(0);
			}
			
		}
		System.out.println("You Win! \nTries: " + guesses);
		
	}
	
	static boolean contains(char[] x, char y){
		for(int i = 0; i < x.length; i ++){
			if(x[i] == y){
				return true;
			}
		}
		return false;
	}
	
	static boolean cont(char[] word, char[] game){
		for(int i = 0; i < word.length; i ++){
			if(word[i] != game[i]){
				return true;
			}
		}
		return false;
	}
	
}
