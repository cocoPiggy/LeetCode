/**
 * 4. Median of Two Sorted Arrays
 * 
 * Hard
 * 
 * Array, Binary Search, Divide and Conquer
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 *
 */
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int sum = nums1.length + nums2.length;
		if (sum % 2 == 0) {
			return ((double) findKth(nums1, 0, nums2, 0, sum / 2) + (double) findKth(nums1, 0, nums2, 0, sum / 2 + 1))
					/ 2;
		} else {
			return findKth(nums1, 0, nums2, 0, (sum + 1) / 2);
		}

	}

	private int findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
		if (left1 >= nums1.length)
			return nums2[left2 + k - 1];
		if (left2 >= nums2.length)
			return nums1[left1 + k - 1];
		if (k == 1)
			return Math.min(nums1[left1], nums2[left2]);
		int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
		int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
		if (mid1 < mid2) {
			return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
		}
		return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);
	}

	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays2(nums2, nums1);
		}
		int len = nums1.length + nums2.length;
		int cut1 = 0;
		int cut2 = 0;
		int start = 0;
		int end = nums1.length;

		while (cut1 <= nums1.length) {
			cut1 = (end - start) / 2 + start;
			cut2 = len / 2 - cut1;
			System.out.println(cut1+"!"+cut2);
			double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
			double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
			double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
			double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];

			if (L1 > R2) {
				end = cut1 - 1;
			} else if (L2 > R1) {
				start = cut1 + 1;
			} else {
				if (len % 2 == 0) {
					return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
				} else {
					return Math.min(R2, R1);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums1 = { 2,3,4,5};
		int[] nums2 = { 1 };
		double result = new MedianofTwoSortedArrays().findMedianSortedArrays2(nums1, nums2);
		System.out.println(result);
	}
}
