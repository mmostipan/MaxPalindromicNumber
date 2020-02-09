package maxpalindrome;

import java.util.ArrayList;

public class MaxPalindrome {

	private ArrayList<Integer> generatePrimeNumbers() {

		int dividers = 0;

		ArrayList<Integer> primeNumbers = new ArrayList<>();

		again: for (int i = 10000; i <= 99999; i++) {

			for (int j = 1; j <= i; j++) {

				if (i % j == 0)
					dividers++;

				if (dividers > 2) {
					dividers = 0;
					continue again;
				}

			}

			primeNumbers.add(i);
			dividers = 0;
		}

		return primeNumbers;
	}

	private ArrayList<PalindromeNumber> getPalindromes(ArrayList<Integer> primeNumbers) {

		ArrayList<PalindromeNumber> palindromeNumbers = new ArrayList<>();

		for (int primeNumber1 : primeNumbers) {

			for (int primeNumber2 : primeNumbers) {

				long number = (long) primeNumber1 * (long) primeNumber2;

				if (isPalindrome(String.valueOf(number))) {

					PalindromeNumber palindrom = new PalindromeNumber();

					palindrom.setPrimeNumber1(primeNumber1);

					palindrom.setPrimeNumber2(primeNumber2);

					palindrom.setPalindromeNumber(number);

					palindromeNumbers.add(palindrom);

				}

			}
		}

		return palindromeNumbers;
	}

	private boolean isPalindrome(String primeNumber) {

		int i = 0, j = primeNumber.length() - 1;

		while (i < j) {
			if (primeNumber.charAt(i) != primeNumber.charAt(j))
				return false;
			i++;
			j--;
		}

		return true;
	}

	private PalindromeNumber getMaxPalindrome() {
		
		long maxPalindrome = 0;
		
		PalindromeNumber maxPalindromeNumber = null;

		for (PalindromeNumber palindromeNumber : getPalindromes(generatePrimeNumbers())) {

			if (maxPalindrome < palindromeNumber.getPalindromeNumber()) {
				
				maxPalindrome = palindromeNumber.getPalindromeNumber();
				
				maxPalindromeNumber = palindromeNumber;
			}
				
		}

		return maxPalindromeNumber;
	}

	public void showResult() {

		System.out.println("Max palindrome number: " + getMaxPalindrome().getPalindromeNumber());
		System.out.println("First multiplayer: " + getMaxPalindrome().getPrimeNumber1());
		System.out.println("Second multiplayer: " + getMaxPalindrome().getPrimeNumber2());
		
	}
	
	 public static void quickSort(ArrayList<PalindromeNumber> arr, int start, int end){
		 
	        int partition = partition(arr, start, end);
	 
	        if(partition - 1 > start) {
	            quickSort(arr, start, partition - 1);
	        }
	        if(partition + 1 < end) {
	            quickSort(arr, partition + 1, end);
	        }
	    }
	 
	   public static int partition(ArrayList<PalindromeNumber> arr, int start, int end){
	        PalindromeNumber pivot = arr.get(end);
	 
	        for(int i = start; i < end; i++) {
	            if(arr.get(i).getPalindromeNumber() < pivot.getPalindromeNumber()){
	                PalindromeNumber temp = arr.get(start);
	                arr.set(start, arr.get(i));
	                arr.set(i, temp);
	                start++;
	            }
	        }
	 
	        PalindromeNumber temp = arr.get(start);
	        arr.set(start, pivot);
	        arr.set(end, temp);
	
	        return start;
	    }

	public static void main(String[] args) {

		new MaxPalindrome().showResult();

	}

}
