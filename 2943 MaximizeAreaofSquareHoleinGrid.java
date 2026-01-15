class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxv = 0;
        int maxh = 0;
        int count = 0;

        for(int i = 0; i<hBars.length-1;i++){
            if(hBars[i+1]-hBars[i] == 1 ) count++;
            else count = 0;

            maxh = Math.max(maxh,count);
        }
        count = 0;
        for(int j = 0; j<vBars.length-1;j++){
            if(vBars[j+1]-vBars[j] == 1 ) count++;
            else count = 0;

            maxv = Math.max(maxv,count);
        }

        int side = Math.min(maxh,maxv)+2;

        return side * side;
    }
}
