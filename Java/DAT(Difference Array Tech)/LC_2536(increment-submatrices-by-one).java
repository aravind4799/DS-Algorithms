class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // try to brute force
        // int[][] mat = new int[n][n];
        // for(int[] q: queries){
        //     int x = q[0];
        //     int y = q[1];
        //     int x1 = q[2];
        //     int y1 = q[3];
            
        //     for(int i=x;i<=x1;i++){
        //         for(int j=y;j<=y1;j++){
        //             mat[i][j]++;
        //         }
        //     }
        // }
        // // o(n^3)
        // return mat;

        // dat - technique -> in 1D
        // (l,r) -> add 1 
        // arr[l] +=1
        // if(r+1<n)
        // arr[r+1] -=1
        // then find cummulative sum

        // do the same for 2d array 

        int[][] mat = new int[n][n];
        for(int[] q: queries){
            int x  = q[0];
            int y  = q[1];
            int x1 = q[2];
            int y1 = q[3];
            for(int i=x;i<=x1;i++){
                mat[i][y]+=1;
                if(y1+1 < n) mat[i][y1+1]-=1;
            }
        }

        // find cummulative sum
        // row-wise
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] =  ( (j-1 < 0) ? 0 : mat[i][j-1] ) + mat[i][j];
            }
        }
        return mat;
    }
}