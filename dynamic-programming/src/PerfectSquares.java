/***
 * 
 * 279. Perfect Squares
 * 
 * Medium
 * 
 * Share Given a positive integer n, find the least number of perfect square
 * numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
 * 
 * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
 * 
 * 
 * 
 * Space O(n) Time O(n)
 */
public class PerfectSquares {
	public int numSquares(int n) {
		if (n < 0) {
			return 0;
		}
		int[] res = new int[n + 1];
		res[0] = 0;
		for (int i = 1; i <= n; i++) {
			int local_res = Integer.MAX_VALUE;
			int j = 1;
			while (i - j * j >= 0) {
				local_res = Math.min(local_res, res[i - j * j] + 1);
				j++;
			}
			res[i] = local_res;
		}
		return res[n];
	}

	public static void main(String[] args) {
		PerfectSquares test = new PerfectSquares();
		System.out.println(test.numSquares(12));
	}
}
