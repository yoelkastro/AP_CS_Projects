package Ch8ProjectQuestions;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		String a = scan.nextLine();
		String b = scan.nextLine();
		
		int[] num1 = new int[a.length()];
		int[] num2 = new int[b.length()];
		
		for(int i = 0; i < num1.length; i ++){
			num1[i] = Integer.parseInt("" + a.charAt(i));
		}
		for(int i = 0; i < num2.length; i ++){
			num2[i] = Integer.parseInt("" + b.charAt(i));
		}
		
		int[] sum = add(num1, num2);
		
		int i = 0;
		while(sum[i] == 0){
			i ++;
		}
		
		for(i = i; i < sum.length; i ++){
			System.out.print("" + sum[i]);
		}
		
	}
	
	static int[] add(int[] x, int[] y){
		
		int[] ret = new int[x.length * 2];
		
		int rec = 0;
		int l;
		for(l = 0; l < Integer.min(x.length, y.length); l ++){
			
			ret[ret.length - l - 1] = ((x[x.length - l - 1] + y[y.length - l - 1] + rec) % 10);
			rec = ((x[x.length - l - 1] + y[y.length - l - 1] + rec) / 10);
			
		}
		for(int i = l; i < Integer.max(x.length, y.length); i ++){
			
			ret[ret.length - i - 1] = ((x.length > y.length? x:y)[(x.length > y.length? x:y).length - l - 1] + rec) % 10;
			rec = ((x.length > y.length? x:y)[(x.length > y.length? x:y).length - l - 1] + rec) / 10;
			l ++;
			
		}
		ret[ret.length - l - 1] = rec;
		
		return ret;
	}
	
}
