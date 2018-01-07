
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i])){
                res[1]=m.get(target-nums[i]);
                res[0]=i;
                break;
            }
            if(map.containsKey(numbers[i])) {
                continue;
            }
            m.put(nums[i],i);
        }
        return res;
    }
}
