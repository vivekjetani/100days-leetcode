class Solution {
    public int longestBalanced(String s) {
        int max = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int freq[] = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if(j-i+1 > max && checkbalance(freq)){
                    max = j-i+1;
                }
            }
        }
        return max;
    }
    boolean checkbalance(int freq[]){
        int expect = 0;
        for(int f : freq){
            if(f==0)
                continue;
            if(expect==0)
                expect = f;
            else if(f!=expect)
                return false;
        }
        return true;
    }
}
