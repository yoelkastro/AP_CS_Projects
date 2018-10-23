package Quiz1;

public class Question5 {

	public String removeDoubleLetters(String in){
		char[] ca = in.toCharArray();
		String ret = "" + ca[0];
		for(int i = 1; i < in.length(); i ++){
			if(in.charAt(i) == in.charAt(i - 1)) ca[i] = '\0';
			ret += ca[i];
		}
		return ret;
	}
	
}
