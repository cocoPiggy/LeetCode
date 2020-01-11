import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Medium
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsofaPhoneNumber {
    // time O(4^n) space O(n)
    String[] keys={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0) return new ArrayList<>();
        List<String> res=new ArrayList<>();
        backTracking(digits,res,new StringBuilder(),0);
        return res;
    }

    public void backTracking(String digits,List<String> res,StringBuilder sb,int offset){
        if(offset==digits.length()){
            res.add(sb.toString());
            return;
        }
        String key=keys[digits.charAt(offset)-'0'];
        for(int i=0;i<key.length();i++){
            sb.append(key.charAt(i));
            backTracking(digits,res,sb,offset+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
