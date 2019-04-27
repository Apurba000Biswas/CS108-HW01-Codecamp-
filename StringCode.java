import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		return 0; // YOUR CODE HERE
	}
	
	public static void main(String[] args) {
		blowup("");
	}
	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		Queue<Character> frequencyQueue = new LinkedList<Character>();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(Character.isDigit(ch)) {
				if(i < str.length()-1) {
					int frequency = Character.getNumericValue(ch);
					char character = str.charAt(i+1);
					putInFrquencyQueue(frequency, character, frequencyQueue);
				}
			}
		}
		String result = getString(str, frequencyQueue);
		return result;
	}
	
	private static void putInFrquencyQueue(int freq, char character, Queue<Character> queue) {
		for(int i=0; i<freq; i++) {
			queue.add(character);
		}
	}
	
	private static String getString(String originalString, Queue<Character> freqQueue) {
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<originalString.length(); i++) {
			while(!freqQueue.isEmpty() && originalString.charAt(i) == freqQueue.peek()) {
				sb.append(freqQueue.remove());
			}
			char ch = originalString.charAt(i);
			if(!Character.isDigit(ch))sb.append(originalString.charAt(i));
		}
		return sb.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		return false; // YOUR CODE HERE
	}
}
