package main;

import searching.PalindromicNumberSearcher;
import searching.data.PalindromicNumber;

public class App {

	public static void main(String[] args) {
		PalindromicNumberSearcher palindromicNumberSearcher = new PalindromicNumberSearcher();
		
		PalindromicNumber palindromicNumber = palindromicNumberSearcher.search(10000, 100000, 100);
		
		System.out.println(palindromicNumber.getPrimeNumber1());
		
		System.out.println(palindromicNumber.getPrimeNumber2());
		
		System.out.println(palindromicNumber.getPalindromicNumber());
	}

}
