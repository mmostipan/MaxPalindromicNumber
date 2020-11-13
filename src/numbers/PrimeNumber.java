package numbers;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class PrimeNumber {

	public boolean isPrime(int number, int certainty) {
		
		/*
		 * certainty - a measure of the uncertainty that the caller is willing to tolerate: 
		 * if the call returns true the probability that this BigInteger is prime exceeds (1 - 1/2^certainty). 
		 * The execution time of this method is proportional to the value of this parameter.
		 * 
		 */
		
		BigInteger bigInteger = BigInteger.valueOf(number);
		
		return bigInteger.isProbablePrime(certainty);
	}

	public boolean isPrime(int number) {
		
	    return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
	    		.noneMatch(n -> (number % n == 0));
	}

}
