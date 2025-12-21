class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int n = strs.length;
        Boolean fixed[] = new Boolean[n];
        for(int i =0; i<strs[0].length();i++){
            boolean flage = false;
            int j =0;
            while(j<n-1){
                if(!fixed[j] && strs[j].charAt(i) > strs[j+1].charAt(i)){
                    flage = true;
                    break;
                }
                j++;
            }
            if(flage){
                count++;
                continue;
            }
            j=0;
            while(j<n-1){
                if(!fixed[j]&&strs[j].charAt(i)<strs[j+1].charAt(i)){
                    fixed[j] =true;
                }
                j++;
            }
        }
        return count;
    }
}