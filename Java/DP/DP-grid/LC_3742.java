class Solution {
    int[][][] memo;
    private int dp(int[][] grid,int i,int j,int cost,int m,int n,int k,int[][][] memo){
        // out of bounds or exhausted cost 
        if(i>=m || j>=n || cost<0) return -10000;
        // at the last cell
        if(i==m-1 && j==n-1){
            // if not valid
           if(cost - Math.min(1,grid[i][j]) < 0) return -10000;
           // return the grid cost only if the cost is not exhausted
           return grid[i][j];
        }

        if(memo[i][j][cost]!=-1) return memo[i][j][cost];
        
        int down  = grid[i][j] + dp(grid,i+1,j,cost-Math.min(1,grid[i][j]),m,n,k,memo);
        int right = grid[i][j] + dp(grid,i,j+1,cost-Math.min(1,grid[i][j]),m,n,k,memo);

        return memo[i][j][cost] = Math.max(down,right); 
    }
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n][k+1];
        for(int[][] r: memo){
            for(int[] r1: r) Arrays.fill(r1,-1);
        }
        int res = dp(grid,0,0,k,m,n,k,memo);
        return res<0 ? -1 : res;
    }
}