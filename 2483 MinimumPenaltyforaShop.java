class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int p = 0;
        for (int i =0;i<n;i++){
            if(customers.charAt(i)=='Y'){
                p++;
            }
        }
        int minp = p;
        int ans = 0;
        for(int j =1;j<n+1;j++){
            if(customers.charAt(j-1)=='Y'){
                p++;
            }else{
                p--;
            }
            if(p>minp){
                minp = p;
                ans =j;
            }
        }
        return ans;
    }
}
