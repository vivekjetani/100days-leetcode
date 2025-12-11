class Solution {
    public int countPermutations(int[] complexity) {
        int mod = 1000000007;
        int n = complexity.length;
        for(int i=1;i<n;i++){
            if(complexity[i] <= complexity[0]){
                return 0;
            }
        }
        long ans = 1;
        for(int i=1;i<=n-1;i++){
            ans = (ans*i)%mod;
        }
        return (int) ans;
    }
}