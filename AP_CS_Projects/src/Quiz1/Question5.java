package Quiz1;

public class Question5 {

	public static String removeDoubleLetters(String in){
		char[] ca = in.toCharArray();	//Turn the input String into a char[] for easy manipulation
		String ret = "" + ca[0];	//Initialize a String to return with the new value
		for(int i = 1; i < in.length(); i ++){	
			if(in.charAt(i) == in.charAt(i - 1)) ca[i] = '\0';	//If the a character is the same as the previous one, change it to an empty value
			ret += ca[i];	//Add the character to the end of the String
		}
		return ret;	//Return the String with the updated values of the char[]
	}
	
	public static void main(String[] args){
		System.out.println(removeDoubleLetters("tresidder"));
	}
	
}
