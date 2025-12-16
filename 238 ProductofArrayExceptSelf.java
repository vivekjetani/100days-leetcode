class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        Arrays.fill(ans,1);
        int l = 1;
        int r = 1;
        for(int i = nums.length-1;i>=0;i--){
            ans[i] = r;
            r *= nums[i];
        }
        for(int i =0;i<nums.length;i++){
            ans[i] *= l;
            l *= nums[i];
        }
        return ans;
    }
}