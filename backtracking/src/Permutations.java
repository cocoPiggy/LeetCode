import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Medium
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {
   // time O(n!*n) space O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        helper(res,new ArrayList<>(),nums);
        return res;
    }

    private static void helper(List<List<Integer>> res,List<Integer> list,int[] nums) {
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res,list,nums);
            list.remove(list.size()-1);
        }
    }
}
