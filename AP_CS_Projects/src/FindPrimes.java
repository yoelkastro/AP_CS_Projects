import java.util.ArrayList;

public class FindPrimes {

	static Integer[] findPrimeNumbers(int max){
		
		ArrayList<Integer> primes = new ArrayList<Integer>(); //Create new Integer ArrayList to store prime numbers
		primes.add(2); //Add the first prime number (2)
		
		for(int i = 3; i < max; i += 2){ //Cycle all odd numbers in the specified limit
			
			boolean isPrime = true;
			
			for(Integer t : primes){ //Check if the value is prime by dividing it to all previous prime numbers
				
				if(i % t == 0){ //break the loop if it is prime
					isPrime = false;
					break;
				}
				
			}
			
			if(isPrime){ //Add the value to the list if it is a prime number
				primes.add(i);
			}
		}
		
		Integer[] ret = new Integer[primes.size()]; //Create a new array to return
		ret = primes.toArray(ret); //Transform the ArrayList to an array
		
		return ret; //return the array
	}
	
	public static void main(String[] args){
		
		Integer[] a = findPrimeNumbers(100000);
		for(int i = 0; i < a.length; i ++){
			System.out.print(a[i] + " ");
		}
		
	}
	
}
