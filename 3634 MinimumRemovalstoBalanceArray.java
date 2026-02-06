class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;

        int l = 0;
        int maxlen = 1;

        for(int r = 0;r<n;r++){
            while((long)nums[r] > (long)nums[l]*k){
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
        }

        return n - maxlen;
        
    }
}
