class Solution {

    int parent[];
    int rank[];

    public int find (int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int a , int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return;
        if(rank[pa]<rank[pb]){
            parent[pa] = pb;
        }else if (rank[pa]>rank[pb]){
            parent[pb] = pa;
        }else{
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public void rest(int x){
        parent[x] = x;
        rank[x] = 0;
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        Arrays.sort(meetings,(a,b)-> a[2]-b[2]);

        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        union(0,firstPerson);

        int i=0;
        int m = meetings.length;

        while(i<m){
            int time = meetings[i][2];
            List<Integer> lists = new ArrayList<>();

            while(i<m && meetings[i][2] == time){
                union(meetings[i][0],meetings[i][1]);
                lists.add(meetings[i][0]);
                lists.add(meetings[i][1]);
                i++;
            }
            for(int p : lists){
            if(find(0) != find(p)){
                rest(p);
            }
        }
        }
        List<Integer> ans = new ArrayList<>();
        for(int p=0; p<n ;p++){
            if(find(0) == find(p)){
                ans.add(p);
            }
        }
        return ans;
    }
}