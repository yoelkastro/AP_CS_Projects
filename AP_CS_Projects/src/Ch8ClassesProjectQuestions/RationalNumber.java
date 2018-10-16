package Ch8ClassesProjectQuestions;

public class RationalNumber {

	int numerator, denominator;
	
	public RationalNumber(int numerator, int denominator){
		
		if(denominator == 0){
			throw new IllegalArgumentException();
		}
		
		this.numerator = numerator;
		this.denominator = denominator;
	
	}
	
	public RationalNumber(){
		
		this.numerator = 0;
		this.denominator = 1;
		
	}
	
	public int getDenominator(){
		return this.denominator;
	}
	
	public int getNumerator(){
		return this.numerator;
	}
	
	public String toString(){
		return numerator + "/" + denominator;
	}
	
}
