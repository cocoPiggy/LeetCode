/**
 * 31. Next Permutation
 * Medium
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * Accepted
 */
public class NextPermutation {
    // time O(n) sapce O(1)
    public void nextPermutation(int[] nums) {
        // time O(n) space O(1)
        if(nums==null||nums.length==0) return;
        int firstsmall=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                firstsmall=i;
                break;
            }
        }
        if(firstsmall==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        int firstlarge=-1;
        for(int i=nums.length-1;i>firstsmall;i--){
            if(nums[i]>nums[firstsmall]){
                firstlarge=i;
                break;
            }
        }
        swap(nums,firstsmall,firstlarge);
        reverse(nums,firstsmall+1,nums.length-1);
    }

    public void reverse(int[] nums, int start,int end){
        while(start<end){
            swap(nums,start++,end--);
        }
    }

    public void swap(int[] nums,int n1,int n2){
        int temp=nums[n1];
        nums[n1]=nums[n2];
        nums[n2]=temp;
    }
}
