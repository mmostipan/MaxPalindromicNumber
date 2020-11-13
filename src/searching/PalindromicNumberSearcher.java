package searching;

import java.util.stream.IntStream;

import numbers.PrimeNumber;
import searching.data.PalindromicNumber;

public class PalindromicNumberSearcher {
	
	public PalindromicNumber start(int startInclusive, int endInclusive, int certainty) {
		
		PrimeNumber primeNumber = new PrimeNumber();

		int[] primeNumbers = IntStream.rangeClosed(startInclusive, endInclusive)
				.filter(number -> primeNumber.isPrime(number, certainty))
				.toArray();
		
		return getMaxPalindromicNumber(primeNumbers);

	}
	
	private PalindromicNumber getMaxPalindromicNumber(int[] primeNumbers) {

		PalindromicNumber maxPNumber = new PalindromicNumber();

		for (int primeNumber1 : primeNumbers) {

			for (int primeNumber2 : primeNumbers) {

				long number = ((long) primeNumber1) * ((long) primeNumber2);

				if (isPalindrome(String.valueOf(number)) && maxPNumber.getPalindromicNumber() < number) {

					maxPNumber.setPrimeNumber1(primeNumber1);

					maxPNumber.setPrimeNumber2(primeNumber2);

					maxPNumber.setPalindromicNumber(number);

				}

			}
		}

		return maxPNumber;
	}
	
	private boolean isPalindrome(String primeNumber) {
		
		int start = 0;

		int end = primeNumber.length() - 1;

		while (start < end) {

			if (primeNumber.charAt(start) != primeNumber.charAt(end)) {

				return false;

			}

			start++;

			end--;
		}

		return true;
	}

}
