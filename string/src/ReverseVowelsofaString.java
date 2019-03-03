/***
 * 345. Reverse Vowels of a String
 * 
 * Easy
 * 
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * Input: "hello"
 * 
 * Output: "holle"
 * 
 * Example 2:
 * 
 * Input: "leetcode"
 * 
 * Output: "leotcede"
 * 
 * Note:
 * 
 * The vowels does not include the letter "y".
 *
 */
public class ReverseVowelsofaString {
	public String reverseVowels(String s) {
		String vowel = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			while (left < right && !vowel.contains(chars[left] + "")) {
				left++;
			}
			while (left < right && !vowel.contains(chars[right] + "")) {
				right--;
			}
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		String input = "hello";

		System.out.println(new ReverseVowelsofaString().reverseVowels(input));
	}
}
