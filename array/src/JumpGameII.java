
/***
 * 45. Jump Game II
 * 
 * Hard
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4]
 * 
 * Output: 2
 * 
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
 * step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 *
 * 
 */
//Time O(n) Space O(1)
public class JumpGameII {
	public int jump(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int maxNext = 0;
		int curMaxArea = 0;
		int step = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			maxNext = Math.max(maxNext, i + nums[i]);
			if (i == curMaxArea) {
				step++;
				curMaxArea=maxNext;
			}
		}
		return step;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		JumpGameII test = new JumpGameII();
		System.out.println(test.jump(nums));
	}
}
