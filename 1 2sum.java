import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer ,Integer> bag = new HashMap<Integer,Integer>();

        for(int i = 0; i<nums.length;i++){
            if (bag.containsKey(target-nums[i])){
                int j = bag.get(target-nums[i]);
                return new int[]{i,j};
            }
            bag.put(nums[i],i);
        }
        return null;
    }
}