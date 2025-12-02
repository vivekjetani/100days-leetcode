class Solution {
    public int countTrapezoids(int[][] points) {
        long mod = 1000000007;

        Map<Integer,Integer> ycountmap = new HashMap<>();
        for(int[] point : points){
            int y = point[1];
            ycountmap.put(y, ycountmap.getOrDefault(y,0)+1);
        }

        List<Long> pairlist = new ArrayList<>();
        long totalPairs = 0;

        for(int count: ycountmap.values()){
            if(count >= 2){
                long pairaty = ((long)count*(count-1)/2)%mod;
                pairlist.add(pairaty);
                totalPairs = (totalPairs + pairaty)%mod;
            }
        }
        long ans = 0;

        for(long x : pairlist){
            totalPairs = (totalPairs - x + mod)%mod;
            ans = (ans + (x*totalPairs)% mod)%mod;
        }

        return (int)ans;
        
    }
}