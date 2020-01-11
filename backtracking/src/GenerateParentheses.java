import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Medium
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {
    //time O(n!) Space O(n)
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, "", n, n);
        return res;
    }

    public void backtrack(List<String> res, String str, int left, int right){
        if(left>right) return;

        if(left==0&&right==0){
            res.add(str);
            return;
        }

        if(left >0)
            backtrack(res, str+"(", left-1, right);
        if(right>0)
            backtrack(res, str+")", left, right-1);
    }
}
