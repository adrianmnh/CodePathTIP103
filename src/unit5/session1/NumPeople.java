package unit5.session1;

import java.util.Arrays;

public class NumPeople {

    public static int[][] canSee(int[][] heights){

        int rows = heights.length;
        int cols = heights[0].length;
        int[][] ans = new int[rows][cols];
        boolean stop;

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                int count = 0;
                stop = false;
                // right
                int r=j+1;
                while(r<cols && !stop){
                    if(heights[i][r] < heights[i][j]) ans[i][j]++;
                    else{
                        ans[i][j]++;
                        stop = true;
                    }
                    r++;
                }
                //down
                stop = false;
                int d=i+1;
                while(d < rows && !stop){
                    if(heights[d][j] < heights[i][j]) ans[i][j]++;
                    else{
                        ans[i][j]++;
                        stop = true;
                    }
                    d++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString( canSee(new int[][]{{3,1,4,2,5}}) )); // {2,1,2,1,0}
        System.out.println(Arrays.deepToString( canSee(new int[][]{{5,1},{3,1},{4,1}}) )); // {3,1}{2,1}{1,0}

    }
}
