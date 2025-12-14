class Solution {
    public int numberOfWays(String corridor) {
        long ans = 1;
        int p=0;
        int seat = 0;
        final int mod = 1000_000_007;
        
        for(int i =0; i<corridor.length();i++){
            char c = corridor.charAt(i);
            if(c == 'S'){
                seat++;
                if(seat>2 && seat%2==1){
                    ans = ans*(i-p)%mod;
                }
                p = i;
            }
        }
        return seat > 1 && seat % 2 == 0 ? (int)ans : 0;
    }
}