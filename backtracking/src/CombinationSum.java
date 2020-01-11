import java.util.ArrayList;
import java.util.List;

/***
 * 39. Combination Sum
 * Medium
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * Accepted
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //time O(2^n) space O(n)
        if(candidates==null||candidates.length==0) return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        backtracking(res,new ArrayList<>(),candidates,target,0);
        return res;
    }


    private void backtracking(List<List<Integer>> res,List<Integer> list,int[] candidates, int target,int start){
        if(target==0){
            res.add(new ArrayList(list));
            return;
        }
        if(target<0) return;
        for(int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            backtracking(res,list,candidates,target-candidates[i],i);
            list.remove(list.size()-1);
        }
    }
}
