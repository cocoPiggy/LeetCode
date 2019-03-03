/**
 * 58. Length of Last Word
 * 
 * Easy
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * Input: "Hello World"
 * 
 * Output: 5
 *
 */
public class LengthofLastWord {
	// time O(1) space O(1)
	public int lengthOfLastWord(String s) {
		return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
	}

	public static void main(String[] args) {
		LengthofLastWord test = new LengthofLastWord();
		System.out.println(test.lengthOfLastWord("Hello World"));
	}
}
