package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluationService {

	private static Object map;

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 */
	public String acronym(String phrase) {
		String letter = phrase;
		// System.out.println(text);
		String acronym = "";
		for (char c : letter.toCharArray())
			if (Character.isUpperCase(c))
				acronym += c;
//		System.out.println(acronym);
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo && sideTwo == sideThree && sideOne == sideThree) {

				return true;

			} else

				return false;

		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {

				return true;

			} else

				return false;

		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration

			if (sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree) {

				return true;

			} else

				return false;

		}

	}

	/**
	 * 4. Given a word, compute the S Scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int score_points = 0;
		//using a break to score T,G,Y,K,X,Z,C,B,G,E
		// Use a switch to run through all the elements while scoring at specific letters
		//used upper and lower case letter as an identify of the letters.
		// used this method because of efficiency and easy understanding

		for (int j = 0; j < string.length(); j++) {

			char letter = string.charAt(j);

			switch (letter) {

			case 'a':

			case 'A':

			case 'e':

			case 'E':

			case 'i':

			case 'I':

			case 'o':

			case 'O':

			case 'u':

			case 'U':

			case 'l':

			case 'L':

			case 'n':

			case 'N':

			case 'r':

			case 'R':

			case 's':

			case 'S':

			case 't':

			case 'T':

				score_points += 1;

				break;

			case 'd':

			case 'D':

			case 'g':

			case 'G':

				score_points += 2;

				break;

			case 'b':

			case 'B':

			case 'c':

			case 'C':

			case 'm':

			case 'M':

			case 'p':

			case 'P':

				score_points += 3;

				break;

			case 'f':

			case 'F':

			case 'h':

			case 'H':

			case 'v':

			case 'V':

			case 'w':

			case 'W':

			case 'y':

			case 'Y':

				score_points += 4;

				break;

			case 'k':

			case 'K':

				score_points += 5;

				break;

			case 'j':

			case 'J':

			case 'x':

			case 'X':

				score_points += 8;

				break;

			case 'q':

			case 'Q':

			case 'z':

			case 'Z':

				score_points += 10;

				break;

			}

		}

		return score_points;

	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String newernumber = "";

		for (int k = 0; k < string.length(); k++) {

			char digit = string.charAt(k);

			if (digit == '-' || digit == ' ' || digit == '(' || digit == ')' || digit == '.') {

				continue;

			}

			newernumber = newernumber + string.charAt(k);

		}

		return newernumber;

	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string @return+m1
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		HashMap<String, Integer> wordCounts = new HashMap<>();

		Scanner parser = new Scanner(string);

		parser.useDelimiter("[^a-zA-Z']+");
		String parsedString = "";

		while (parser.hasNext()) {
			parsedString = parser.next();

			if (wordCounts.containsKey(parsedString)) {
				wordCounts.put(parsedString, wordCounts.get(parsedString) + 1);
			} else {
				wordCounts.put(parsedString, 1);
			}
		}

		parser.close();

		return wordCounts;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration

		Pattern vowel = Pattern.compile("^([aeiou]|y[^aeiou]|xr)");

		Pattern consone = Pattern.compile("^([^aeiou]?qu|[^aeiouy]+|y(?=[aeiou]))");

		String PigLatin = "";
		for (String letters : string.split(" ")) {
			if (vowel.matcher(letters).find())
				PigLatin += letters;

			else {
				Matcher z = consone.matcher(letters);
				if (z.find())
					
					
					PigLatin += letters.substring(z.end()) + z.group();
			}
			PigLatin += "ay ";
		}

		return PigLatin.substring(0, PigLatin.length() - 1);
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration

		int digits = ((int) Math.log10(Math.abs((double) input))) + 1;

		double armstrongSum = 0;

		int digit = 0;

		for (int i = 0; i < digits; i++) {

			digit = (int) (input % Math.pow(10, i + 1) / Math.pow(10, i));

			armstrongSum += Math.pow(digit, digits);

		}

		return armstrongSum == (double) input;

	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */

	public List<Long> calculatePrimeFactorsOf(long P) {
		// TODO Write an implementation for this method declaration

		List<Long> primeFactors = new ArrayList<Long>();

		while (P % 2 == 0) {
			primeFactors.add(2l);
			P /= 2;
			System.out.println("here");
		}

		// n must be odd at this point. So we can
		// skip one element (Note i = i +2)
		for (long i = 3; i <= Math.sqrt(P
				); i += 2) {

			// While i divides n, print i and divide n
			while (P % i == 0) {
				primeFactors.add(i);
				P /= i;
			}

		}
		// This condition is to handle the case when
		// n is a prime number greater than 2
		if (P > 2) {
			primeFactors.add(P);
		}
		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int Int_key;

		public RotationalCipher(int key) {
			super();
			this.Int_key = key;
		}

		public String rotate(String string) {
			//uppercase: 65-90
			//lowercase: 97-122
			//for each character in string
			//if not uppercase or lowercase, do nothing
			//if uppercase, set start to 65
			//if lowercase, set start to 97
			//take char value, subtract start, add key, mode 26, add start
			//add to new answer string
			String answer = "";
			//int start;
			for(int i=0; i<string.length(); i++) {
				if(string.charAt(i) >= 65 && string.charAt(i) <= 90) {
					//start = 65;
					//answer += (char) ((string.charAt(i) - start + key) % 26 + start);
					answer += getRotatedChar(string.charAt(i), 65, Int_key);
				}
				else if(string.charAt(i) >= 97 && string.charAt(i) <= 122) {
					//start = 97;
					//answer += (char) ((string.charAt(i) - start + key) % 26 + start);
					answer += getRotatedChar(string.charAt(i), 97, Int_key);
				}
				else {
					answer += string.charAt(i);
				}
			}
			return answer;
		}
		
		public char getRotatedChar(char initial, int start, int key) {
			return (char) ((initial - start + key) % 26 + start);
		}

	}



	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration

		int primes = 0;

		int nthNumber = 0;


		if (i <= 0) {

			throw new IllegalArgumentException("hgrrwss hyytrdx bgtedgi: " + i);

		}

		while (primes < i) {

			nthNumber++;

			
			if (isPrime(nthNumber)) {

				primes++;

			}

		}

		return (int) nthNumber;

	}

	private boolean isPrime(int currentNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
	
				string = string.toLowerCase();
				
				String words = "";
				for(int i=0; i<string.length(); i++) {
					
					if(string.charAt(i) >= 97 && string.charAt(i) <= 122) {
						
						 words += (char) (122 - string.charAt(i) + 97); 
					}
					
					else if(string.charAt(i) >= 48 && string.charAt(i) <= 57) {
						words += string.charAt(i);
					}

				}
				
				String answer = "";
				
				for(int i=0; i<words.length(); i++) {
					
					answer += words.charAt(i);
					
					if((i+1) % 5 == 0 && i < words.length() - 1) {
						answer += " ";
					}
				}
				return answer;
			}
				
		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			//if char code is between 97-122 (lower case letter)
			String answer = "";
			for(int i=0; i<string.length(); i++) {
				
				if(string.charAt(i) >= 97 && string.charAt(i) <= 122) {

					answer += (char) (122 - string.charAt(i) + 97); 
				}
				else if(string.charAt(i) >= 48 && string.charAt(i) <= 57) {
					answer += string.charAt(i);
					System.out.println(i);
				}
			}
			return answer;
		}
	}
			

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		
			String input = string.replaceAll("\\-", "");
			char[] sA = input.toCharArray();
			int[] intA = new int[10];
			boolean bool = false, used = false, used1 = false, used2 = false, used3 = false, used4 = false, used5 = false, used6 = false, used7 = false, used8 = false, used9 = false;
			
			for(int i = 0; i < sA.length; i++) {
				String charToStr = String.valueOf(sA[i]);
				if(charToStr.matches("[0-9]")) {
					if(intA[0] == 0 && used == false) {
						intA[0] = Integer.parseInt(charToStr);
						used = true;
					}
					else if(intA[1] == 0 && used1 == false) {
						intA[1] = Integer.parseInt(charToStr);
						used1 = true;
					}
					else if(intA[2] == 0 && used2 == false) {
						intA[2] = Integer.parseInt(charToStr);
						used2 = true;
					}
					else if(intA[3] == 0 && used3 == false) {
						intA[3] = Integer.parseInt(charToStr);
						used3 = true;
					}
					else if(intA[4] == 0 && used4 == false) {
						intA[4] = Integer.parseInt(charToStr);
						used4 = true;
					}
					else if(intA[5] == 0 && used5 == false) {
						intA[5] = Integer.parseInt(charToStr);
						used5 = true;
					}
					else if(intA[6] == 0 && used6 == false) {
						intA[6] = Integer.parseInt(charToStr);
						used6 = true;
					}
					else if(intA[7] == 0 && used7 == false) {
						intA[7] = Integer.parseInt(charToStr);
						used7 = true;
					}
					else if(intA[8] == 0 && used8 == false) {
						intA[8] = Integer.parseInt(charToStr);
						used8 = true;
					}
					else if(intA[9] == 0 && used9 == false) {
						intA[9] = Integer.parseInt(charToStr);
						used9 = true;
					}
				}
				else if(charToStr.matches("X")) {
					if(intA[0] == 0 && used == false) {
						intA[0] = 10;
						used = true;
					}
					else if(intA[1] == 0 && used1 == false) {
						intA[1] = 10;
						used1 = true;
					}
					else if(intA[2] == 0 && used2 == false) {
						intA[2] = 10;
						used2 = true;
					}
					else if(intA[3] == 0 && used3 == false) {
						intA[3] = 10;
						used3 = true;
					}
					else if(intA[4] == 0 && used4 == false) {
						intA[4] = 10;
						used4 = true;
					}
					else if(intA[5] == 0 && used5 == false) {
						intA[5] = 10;
						used5 = true;
					}
					else if(intA[6] == 0 && used6 == false) {
						intA[6] = 10;
						used6 = true;
					}
					else if(intA[7] == 0 && used7 == false) {
						intA[7] = 10;
						used7 = true;
					}
					else if(intA[8] == 0 && used8 == false) {
						intA[0] = 10;
						used8 = true;
					}
					else if(intA[9] == 0 && used9 == false) {
						intA[9] = 10;
						used9 = true;
					}
				}
			//	System.out.println(intA[i]);
			}
			int result = (intA[0] * 10 + intA[1] * 9 + intA[2] * 8 + intA[3] * 7 + intA[4] * 6 + intA[5] * 5 + intA[6] * 4 + intA[7] * 3 + intA[8] * 2 + intA[9] * 1) % 11;
		//	System.out.println("this is the result: " + result);
			if(result == 0) {
				bool = true;
			}
		//	System.out.println(bool);
			return bool;
		}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		
			Map<Integer, Character> charMap1 = new HashMap<Integer, Character>();
			Map<Integer, Character> charMap2 = new HashMap<Integer, Character>();
			char[]stringA=string.toCharArray();

			charMap1.put(1, 'a');
			charMap1.put(2, 'b');
			charMap1.put(3, 'c');
			charMap1.put(4, 'd');
			charMap1.put(5, 'e');
			charMap1.put(6, 'f');
			charMap1.put(7, 'g');
			charMap1.put(8, 'h');
			charMap1.put(9, 'i');
			charMap1.put(10, 'j');
			charMap1.put(11, 'k');
			charMap1.put(12, 'l');
			charMap1.put(13, 'm');
			charMap1.put(14, 'n');
			charMap1.put(15, 'o');
			charMap1.put(16, 'p');
			charMap1.put(17, 'q');
			charMap1.put(18, 'r');
			charMap1.put(19, 's');
			charMap1.put(20, 't');
			charMap1.put(21, 'u');
			charMap1.put(22, 'v');
			charMap1.put(23, 'w');
			charMap1.put(24, 'x');
			charMap1.put(25, 'y');
			charMap1.put(26, 'z');

			for (int i = 0; i < stringA.length; i++) {
				char letter = stringA[i];
				switch (letter) {
				
				case 'a':
					if (!(charMap2.containsKey(1))) {
						charMap2.put(1, 'a');
					}
					break;
				case 'b':
					if (!(charMap2.containsKey(2))) {
						charMap2.put(2, 'b');
					}
					break;
				case 'c':
					if (!(charMap2.containsKey(3))) {
						charMap2.put(3, 'c');
					}
					break;
				case 'd':
					if (!(charMap2.containsKey(4))) {
						charMap2.put(4, 'd');
					}
					break;
				case 'e':
					if (!(charMap2.containsKey(5))) {
						charMap2.put(5, 'e');
					}
					break;
				case 'f':
					if (!(charMap2.containsKey(6))) {
						charMap2.put(6, 'f');
					}
					break;
				case 'g':
					if (!(charMap2.containsKey(7))) {
						charMap2.put(7, 'g');
					}
					break;
				case 'h':
					if (!(charMap2.containsKey(8))) {
						charMap2.put(8, 'h');
					}
					break;
				case 'i':
					if (!(charMap2.containsKey(9))) {
						charMap2.put(9, 'i');
					}
					break;
				case 'j':
					if (!(charMap2.containsKey(10))) {
						charMap2.put(10, 'j');
					}
					break;
				case 'k':
					if (!(charMap2.containsKey(11))) {
						charMap2.put(11, 'k');
					}
					break;
				case 'l':
					if (!(charMap2.containsKey(12))) {
						charMap2.put(12, 'l');
					}
					break;
				case 'm':
					if (!(charMap2.containsKey(13))) {
						charMap2.put(13, 'm');
					}
					break;
				case 'n':
					if (!(charMap2.containsKey(14))) {
						charMap2.put(14, 'n');
					}
					break;
				case 'o':
					if (!(charMap2.containsKey(15))) {
						charMap2.put(15, 'o');
					}
					break;
				case 'p':
					if (!(charMap2.containsKey(16))) {
						charMap2.put(16, 'p');
					}
					break;
				case 'q':
					if (!(charMap2.containsKey(17))) {
						charMap2.put(17, 'q');
					}
					break;
				case 'r':
					if (!(charMap2.containsKey(18))) {
						charMap2.put(18, 'r');
					}
					break;
				case 's':
					if (!(charMap2.containsKey(19))) {
						charMap2.put(19, 's');
					}
					break;
				case 't':
					if (!(charMap2.containsKey(20))) {
						charMap2.put(20, 't');
					}
					break;
				case 'u':
					if (!(charMap2.containsKey(21))) {
						charMap2.put(21, 'u');
					}
					break;
				case 'v':
					if (!(charMap2.containsKey(22))) {
						charMap2.put(22, 'v');
					}
					break;
				case 'w':
					if (!(charMap2.containsKey(23))) {
						charMap2.put(23, 'w');
					}
					break;
				case 'x':
					if (!(charMap2.containsKey(24))) {
						charMap2.put(24, 'x');
					}
					break;
				case 'y':
					if (!(charMap2.containsKey(25))) {
						charMap2.put(25, 'y');
					}
					break;
				case 'z':
					if (!(charMap2.containsKey(26))) {
						charMap2.put(26, 'z');
					}
					break;
				}
				if (charMap1.equals(charMap2)) {
					return true;
				}

			}

			return false;
		}
	
	
	

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
	
			try {
				LocalDateTime date = LocalDateTime.parse(given.toString());
				return date.plusSeconds(1000000000);
			} catch (Exception e) {
				LocalDate today = LocalDate.parse(given.toString());
				LocalDateTime now = today.atTime(0, 0, 0);
				return now.plusSeconds(1000000000);
			}
		}
			

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration

		int sum = 0;

		for (int o = 1; o < i; o++) {

			for (int k = 0; k < set.length; k++) {

				if (o % set[k] == 0) {

					sum += o;

				
					break;

				}

			}

		}

		return sum;

	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration

		// Holds the running result of the ISBN number validity formula

		int result = 0;

		int currentNumber = 0;

	

		boolean failed = false;

	

		char ch = '\0';

	

		int number = 0;

		

		for (int i = string.length() - 1; i >= 0; i--) {

			ch = string.charAt(i);

		

			if (ch == ' ') {

				continue;

			}

			
			else if (!Character.isDigit(ch)) {

				failed = true;

				break;

			}

		
			number = Character.digit(ch, 10);

			
			currentNumber++;

			if (currentNumber % 2 == 0) {

				number *= 2;

				

				if (number >= 10) {

					number -= 9;

				}

			}

	
			result += number;

		}

        System.out.println("failed");

		return !failed && result % 10 == 0;

	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		

			String string2 = string.replace("?", " ");
			String[] wordProblem = string2.split(" ");
			boolean isFilled = false;
			int[] numbers = new int[2];
			int sum = 0;
			
			for (int i = 0; i < wordProblem.length; i++) {
				if (wordProblem[i].charAt(0) == '-' || Character.isDigit(wordProblem[i].charAt(0))) {
					if (isFilled == false) {
						numbers[0] = Integer.parseInt(wordProblem[i]);
						isFilled = true;
					}
					if (isFilled == true) {
						numbers[1] = Integer.parseInt(wordProblem[i]);

					}

				}

			}
			if (string.contains("plus")) {
				sum = numbers[0] + numbers[1];
			}
			if (string.contains("minus")) {
				sum = numbers[0] - numbers[1];
			}
			if (string.contains("multiplied")) {
				sum = numbers[0] * numbers[1];
			}
			if (string.contains("divided")) {
			sum = numbers[0] / numbers[1];
		//	System.out.println("plus");
			}
			return sum;
			
		}
		
}