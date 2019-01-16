// 54. Spiral Matrix

// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// Example 1:

// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:

// Input:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return res;
		int top = 0;
		int bottom = matrix.length - 1;
		int right = matrix[0].length - 1;
		int left = 0;
		while (true) {
			for (int i = top; i <= right; i++) {
				res.add(matrix[top][i]);
			}
			top++;
			if (top > bottom || left > right)
				break;
			for (int i = top; i <= bottom; i++) {
				res.add(matrix[i][right]);
			}
			right--;
			if (top > bottom || left > right)
				break;
			for (int i = right; i >= left; i--) {
				res.add(matrix[bottom][i]);
			}
			bottom--;
			if (top > bottom || left > right)
				break;
			for (int i = bottom; i >= top; i--) {
				res.add(matrix[i][left]);
			}
			left++;
			if (top > bottom || left > right)
				break;

		}
		return res;

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(new SpiralMatrix().spiralOrder(matrix).toString());

	}

}
