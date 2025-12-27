class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        // int h;
        // for(int i=0;i<happiness.length;i++){
        //     for(int j=0;j<happiness.length-i-1;j++){
        //         if(happiness[j]>happiness[j+1]){
        //             h=happiness[j];
        //             happiness[j]=happiness[j+1];
        //             happiness[j+1] = h;
        //         }
        //     }
        // }

        Arrays.sort(happiness);
        long ans = 0;
        int dec = 0;

        for (int i = happiness.length - 1; i >= 0 && k > 0; i--) {
            int val = happiness[i] - dec;
            if (val <= 0) break;

            ans += val;
            dec++;
            k--;
        }
        return ans;
    }
}
