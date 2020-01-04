// 3. Longest Substring Without Repeating Characters
// Medium
// HashTable, Two Pointer, String
// Given a string, find the length of the longest substring without repeating characters.

// Example 1:

// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 
// Example 2:

// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
// Time O(n) Space O(n)
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	//hashSet Time O(n) Space O(n)
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int left = 0;
		int result = 0;
		Set<Character> set = new HashSet<>();

		for (int right = 0; right < s.length(); right++) {
			char b = s.charAt(right);
			while (set.contains(b)) {
				set.remove(s.charAt(left++));
			}
			set.add(b);
			result = Math.max(result, right - left + 1);
		}
		return result;
	}
	//hashMap Time O(n) Space O(n)
	public int lengthOfLongestSubstring2(String s) {
		if(s==null||s.length()==0){
			return 0;
		}
		int res=0;
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0,j=0;i<s.length();i++){
			if(map.containsKey(s.charAt(i))){
				j=Math.max(j,map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i),i);
			res=Math.max(res,i-j+1);
		}
		return res;
	}

	public static void main(String[] args) {
		String input = "abcabcbb";
		int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(input);
		System.out.println(result);
	}
}
