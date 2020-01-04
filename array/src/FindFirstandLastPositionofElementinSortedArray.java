/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Medium
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstandLastPositionofElementinSortedArray {
    //time log(n) space O(1)
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int start =firstGreaterEqual(nums,target);
        if(start==nums.length||nums[start]!=target){
            return new int[]{-1,-1};
        }

        return new int[]{start,firstGreaterEqual(nums,target+1)-1};
    }

    private static int firstGreaterEqual(int[] nums,int target){
        int start=0;
        int end=nums.length;
        while(start<end){
            int mid=(end-start)/2+start;
            if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
}

