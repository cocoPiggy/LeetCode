/**
 * 5. Longest Palindromic Substring
 * Medium
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    //time O(n^2) space (n^2)
    public String longestPalindrome(String s) {
        String res="";
        boolean[][] dp =new boolean[s.length()][s.length()];
        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1]);
                if(dp[i][j]&&j-i+1>res.length()){
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    // time O(n^2) space(1)
    String res="";
    public String longestPalindrome2(String s) {

        for(int i=0;i<s.length();i++){
            isPalindrome(s,i,i+1);
            isPalindrome(s,i,i);
        }

        return res;
    }
    private  void isPalindrome(String s,int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(j-i-1>res.length()) res=s.substring(i+1,j);
    }
}
