/***
 * 152. Maximum Product Subarray
 * 
 * Medium
 * 
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * Input: [2,3,-2,4]
 * 
 * Output: 6
 * 
 * Explanation: [2,3] has the largest product 6.
 * 
 * Example 2:
 * 
 * Input: [-2,0,-1]
 * 
 * Output: 0
 * 
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
public class MaximumProductSubarray {
	//time O(n) space O(1)
	public int maxProduct(int[] nums) {
	    if (nums.length == 0) {
	        return 0;
	    }
	    
	    int max = nums[0];
	    int min = nums[0];
	    int res = nums[0];
	    
	    for (int i = 1; i < nums.length; i++) {
	        max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
	        min = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
	        res = Math.max(max, res);
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		int[] nums = { 2,3,-2,4};
		System.out.println(new MaximumProductSubarray().maxProduct(nums));
	}
}
