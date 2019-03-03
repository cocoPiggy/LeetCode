
/***
 * 239. Sliding Window Maximum
 * 
 * Hard
 * 
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * 
 * Example:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * 
 * Output: [3,3,5,5,6,7]
 * 
 * Explanation:
 * 
 * Window position Max
 * 
 * --------------- -----
 * 
 * [1 3 -1] -3 5 3 6 7 3
 * 
 * 1 [3 -1 -3] 5 3 6 7 3
 * 
 * 1 3 [-1 -3 5] 3 6 7 5
 * 
 * 1 3 -1 [-3 5 3] 6 7 5
 * 
 * 1 3 -1 -3 [5 3 6] 7 6
 * 
 * 1 3 -1 -3 5 [3 6 7] 7
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty
 * array.
 * 
 * Follow up:
 * 
 * Could you solve it in linear time?
 *
 */

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	// Time O(n) space O(n)
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k+1];
		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.poll();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.removeLast();
			}
			deque.offerLast(i);
			if ((i + 1) >= k) {
				res[i+1-k] = nums[deque.peek()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		SlidingWindowMaximum test = new SlidingWindowMaximum();
		for (int i = 0; i < test.maxSlidingWindow(nums, 3).length; i++)
			System.out.println(test.maxSlidingWindow(nums, 3)[i]);
	}
}
