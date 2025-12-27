class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int ta = 0;
        for (int a : apple){
            ta += a;
        }
        int c;
        for(int i=0;i<capacity.length;i++){
            for(int j=0;j<capacity.length-i-1;j++){
                if(capacity[j]>capacity[j+1]){
                    c=capacity[j];
                    capacity[j]=capacity[j+1];
                    capacity[j+1]=c;

                }
            }
        }
        int ans = 0;
        for (int i = capacity.length-1; i>= 0 && ta > 0 ;i--){
                ta -= capacity[i];
                ans++;
                if (ta <= 0) break;
        }
        return ans;
    }
}
