// 70. Climbing Stairs
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Note: Given n will be a positive integer.

// Example 1:

// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// Example 2:

// Input: 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

public class ClimbingStairs {
	// recursive
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);

	}

	// iterative
	public int climbStaris2(int n) {
		if (n <= 2) {
			return n;
		}
		int oneStep = 1;
		int twoStep = 2;
		int res = 0;
		for (int i = 3; i <= n; i++) {
			res = oneStep + twoStep;
			oneStep = twoStep;
			twoStep = res;
		}
		return res;
	}

	public static void main(String[] args) {
		ClimbingStairs test = new ClimbingStairs();
		System.out.println(test.climbStairs(5));
	}
}
