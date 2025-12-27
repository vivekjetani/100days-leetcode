class Solution {
    public int mostBooked(int n, int[][] meeting) {
        int mc[] = new int [n];
        long et[] = new long[n];
        Arrays.sort(meeting,(a,b)->a[0]-b[0]);

        for(int meetings[] : meeting){
            int start = meetings[0];
            int end = meetings[1];
            int duration = end - start;
            int free =-1;
            for(int i=0;i<n;i++){
                if(et[i]<=start){
                    free = i;
                    break;
                }
            }
            if(free != -1){
                et[free] = start + duration;
                mc[free]++;
            }else{
                int er =0;
                long time = et[0];
                for(int i=1;i<n;i++){
                    if(et[i]<time){
                        time = et[i];
                        er = i;
                    }
                }
                et[er] = time + duration;
                mc[er]++;
            }
        }
        int max = 0; int room = 0;
        for(int i =0; i<n;i++){
            if(mc[i]>max){
                max = mc[i];
                room = i;
            }
        }
        return room;
    }
}
