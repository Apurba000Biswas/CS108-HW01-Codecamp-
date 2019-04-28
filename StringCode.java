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
		int maxRun = 0;
		char currentChar;
		char previousChar = 0;
		int count = 1;
		
		for(int i=0; i<str.length(); i++) {
			currentChar = str.charAt(i);
			if(i>0) previousChar = str.charAt(i-1);
			if(currentChar == previousChar) {
				count++;
			}else {
				if(count > maxRun) maxRun = count;
				count = 1;
			}
		}
		return maxRun;
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
	public static boolean stringIntersect(String str1, String str2, int len) {
		
		Set<String> subStringsFor1 = getSubStrings(str1, len);
		Set<String> subStringsFor2 = getSubStrings(str2, len);
		
		for(String curSub : subStringsFor1) {
			if(subStringsFor2.contains(curSub)) {
				return true;
			}
		}
		return false;
	}
	
	private static Set<String> getSubStrings(String str, int len){
		Set<String> subStrings = new HashSet<String>();
		
		for(int i=0; i<=str.length()-len; i++) {
			String subString = buildSubString(str, i, len);
			subStrings.add(subString);
		}
		if(str.length() == len)subStrings.add(str);
		return subStrings;
	}
	
	private static String buildSubString(String str, int pos, int len) {
		StringBuilder sb = new StringBuilder();
		while(len > 0) {
			sb.append(str.charAt(pos));
			pos++;
			len--;
		}
		return sb.toString();
	}
}
