class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;

        int column = n-1;
        int row = 0;
        int ans = 0;

        while(row < m && column >=0){
            if(grid[row][column]<0){
                ans += (m-row);
                column--;
            }else{
                row++;
            }

        }
        return ans;
        
    }
}
