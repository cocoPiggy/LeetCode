import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 290. Word Pattern
 * 
 * Easy
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Example 1:
 * 
 * Input: pattern = "abba", str = "dog cat cat dog"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input:pattern = "abba", str = "dog cat cat fish"
 * 
 * Output: false
 * 
 * Example 3:
 * 
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * 
 * Output: false
 * 
 * Example 4:
 * 
 * Input: pattern = "abba", str = "dog dog dog dog"
 * 
 * Output: false
 * 
 * Notes:
 * 
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map index = new HashMap();
		for (Integer i = 0; i < words.length; ++i)
			if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
				return false;
		return true;
	}
	
	   public boolean wordPattern2(String pattern, String str) {
		     String[] words = str.split("\\s+");
		    if(pattern.length()!=words.length) return false;
		        Map<String, Integer> patternMap=new HashMap<>();
		        Map<String, Integer> wordMap=new HashMap<>();
		        for(Integer i=0; i<words.length;i++){
		            if(patternMap.put(pattern.charAt(i)+"",i)!=wordMap.put(words[i],i))
		            return false;
		        }
		        return true;
		    }
	
	public static void main(String[] args) {
	//	System.out.println(new WordPattern().wordPattern2("abba","dog cat cat dog"));
		System.out.println(new WordPattern().wordPattern2("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
				"s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"
));
	}
}
