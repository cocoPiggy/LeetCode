// 5. Longest Palindromic Substring
// Given a string s, find the longest palindromic substring in s. 
// You may assume that the maximum length of s is 1000.

// Example 1:

// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.

// Example 2:

// Input: "cbbd"
// Output: "bb"

public class LongestPalindromicSubstring {
	//timeO(n^2) spaceO(n^2)
	public String longestPalindrome(String s) {
		if(s==null||s.length()==0) return "";
		String res="";
		boolean[][] dp = new boolean[s.length()][s.length()];

		for(int j=0;j<s.length();j++){
			for(int i=0;i<=j;i++){
				dp[i][j]=s.charAt(i)==s.charAt(j)&&(j-i<=2||dp[i+1][j-1]);


				if(dp[i][j]&&j-i+1>res.length()){
					res=s.substring(i,j+1);
				}
			}
		}
		return res;
	}
}
