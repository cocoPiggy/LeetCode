/**
 * 10. Regular Expression Matching
 * Hard
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class RegularExpressionMatching {
    //space O(m*n) time O(m*n)
    public boolean isMatch(String s, String p) {
        //time O(n*m) space O(n*m)
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=2;i<=p.length();i++){
            dp[0][i]=p.charAt(i-1)=='*'&&dp[0][i-2];
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]&&isMatch(s.charAt(i-1),p.charAt(j-2))||dp[i][j-2];
                }else{
                    dp[i][j]=dp[i-1][j-1]&&isMatch(s.charAt(i-1),p.charAt(j-1));
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean isMatch(char s, char p){
        return s==p||p=='.';

    }
}
