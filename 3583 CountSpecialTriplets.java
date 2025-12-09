class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1000000007;
        Map<Integer,Long> left = new HashMap<>();
        Map<Integer,Long> right = new HashMap<>();

        for (int x :nums){
            right.put(x,right.getOrDefault(x,0L)+1);
        }
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            int mid = nums[i];
            right.put(mid,right.get(mid)-1);
            int d = mid*2;

            long leftcount = left.getOrDefault(d,0L);
            long rightcount = right.getOrDefault(d,0L);

            ans = (ans +(leftcount*rightcount)%mod)%mod;

            left.put(mid,left.getOrDefault(mid,0L)+1);
            
        }
        return (int) ans;
    }
}