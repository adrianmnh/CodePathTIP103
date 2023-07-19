package unit6.session1;

import java.util.Arrays;

public class MaxIslandArea {

    public static int size = 0;

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;

        for(int r=0; r<grid.length ; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == 1){
                    //explore neighbors
                    dfs(grid, r, c);
                }
                result = Math.max(size, result);
                size = 0;

            }
        }
        return result;
    }


    public static void dfs(int[][] grid, int r, int c){
        if(grid[r][c]==1){
            size+=1;
            grid[r][c] = 0;

            if(r-1 >= 0){ // left
                dfs(grid, r-1, c);
            }
            if(c-1 >= 0){ // up
                dfs(grid, r, c-1);
            }

            if( r+1 < grid.length){ // down
                dfs(grid, r+1, c);
            }
            if( c+1 < grid[0].length){ // right
                dfs(grid, r, c+1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("MaxIslandArea:");
        int[][] grid ={ {0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] grid2 = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,0,1,1}, {0,0,0,1,1}};

        System.out.println(maxAreaOfIsland(grid)); // 6
        System.out.println(maxAreaOfIsland(grid2)); // 4

    }
}