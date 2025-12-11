class Solution {
    public int countCoveredBuildings(int n, int[][] build) {
        Map<Integer,List<Integer>> rows = new HashMap<>();
        Map<Integer,List<Integer>> cols = new HashMap<>();
        
        for(int[] b :build){
            rows.computeIfAbsent(b[0],k->new ArrayList<>()).add(b[1]);
            cols.computeIfAbsent(b[1],k->new ArrayList<>()).add(b[0]);
        }

        for(List<Integer> r:rows.values()){
            Collections.sort(r);
        }
        for(List<Integer> c:cols.values()){
            Collections.sort(c);
        }
        int count = 0;
        for(int[] b:build){
            int x = b[0], y = b[1];
            List<Integer> row = rows.get(x);
            List<Integer> col = cols.get(y);

            int rpos = Collections.binarySearch(row,y);
            int cpos = Collections.binarySearch(col,x);

            if(rpos>0 && rpos <row.size()-1 && cpos>0 && cpos<col.size()-1){
                count++;
            }
        }
        return count;
    }
}