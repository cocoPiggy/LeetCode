import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * Medium
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //time O(2^n) space O(n)
        if(candidates==null||candidates.length==0) return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(res,new ArrayList<>(),candidates,target,0);

        return res;
    }

    private void backtracking(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int start){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList(list));
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start&&candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            backtracking(res,list,candidates,target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}
