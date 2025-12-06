class Solution {
    public int countPartitions(int[] nums, int k) {
        int mod = 1000000007;
        int n = nums.length;
        long dp[] = new long[n+1];
        long prefix[] = new long[n+1];
        dp[0]=1;
        prefix[0] =1;
        ArrayDeque<Integer> maxq = new ArrayDeque<>();
        ArrayDeque<Integer> minq = new ArrayDeque<>(); 
        int left = 0;
        
        for(int right =0;right<n;right++){
            while(!maxq.isEmpty() && nums[maxq.peekLast()]<=nums[right]){
                maxq.pollLast();
            }
            maxq.addLast(right);
            while(!minq.isEmpty() && nums[minq.peekLast()]>=nums[right]){
                minq.pollLast();
            }
            minq.addLast(right);
            
            while((nums[maxq.peekFirst()]-nums[minq.peekFirst()]) > k){
            if(maxq.peekFirst() == left) maxq.pollFirst();
            if(minq.peekFirst() == left) minq.pollFirst();
            left++;
            }
            long ways = prefix[right];
            if(left>0){
                ways= ((ways-prefix[left-1])+mod)%mod;
            } 
            dp[right+1] = ways;
            prefix[right+1] = (prefix[right]+dp[right+1])%mod;
        }
        
        return (int)dp[n];
    }
    
}