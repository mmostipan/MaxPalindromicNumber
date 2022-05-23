package numbers;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class PrimeNumber {
	
	private PrimeNumber() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * This method checks if this given number is prime. 
	 * 
	 * @param number - value for checking.
	 * @param certainty - a measure of the uncertainty that the caller is willing to tolerate: 
	 * 	if the call returns true the probability that this BigInteger is prime exceeds (1 - 1/2^certainty).
	 * @return true - if it`s prime number or false - if not.
	 */
	public static boolean isPrime(int number, int certainty) {
		return BigInteger.valueOf(number).isProbablePrime(certainty);
	}

	public static boolean isPrime(int number) {
	    return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number))
	    		.noneMatch(n -> (number % n == 0));
	}

}
