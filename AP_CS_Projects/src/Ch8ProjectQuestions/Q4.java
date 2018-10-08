package Ch8ProjectQuestions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Q4 {

	public static void main(String[] args) throws IOException{
		
		char[][] poss = {{'I', 'E'}, {'N', 'S'}, {'F', 'T'}, {'P', 'J'}};
		
		String key = "1223344122334412233441223344122334412233441223344122334412233441223344";
		File f = new File("src/Myers-Briggs Sample Input.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String[][] in = new String[2][2];
		
		for(int i = 0; i < in.length; i ++){
			in[i][0] = br.readLine();
			in[i][1] = br.readLine();
		}
		
		int[][] results = new int[in.length][4];
		
		for(int i = 0; i < in.length; i ++){
			for(int t = 0; t < key.length(); t ++){
				if(in[i][1].charAt(t) == 'A'){
					results[i][Integer.parseInt("" + key.charAt(t)) - 1] ++;
				}
			}
		}
		
		for(int i = 0; i < in.length; i ++){
			System.out.println(in[i][0]);
			System.out.print("[");
			for(int t = 0; t < 4; t ++){
				results[i][t] = (results[i][t] * 100) / (key.length() - key.replace("" + (t + 1), "").length());
				System.out.print(results[i][t] + "%");
				if(t < 3) System.out.print(", ");
			}
			System.out.println("] = " + poss[0][results[i][0] / 50] + poss[1][results[i][1] / 50] + poss[2][results[i][2] / 50] + poss[3][results[i][3] / 50]);
			
		}
		
	}
	
}
