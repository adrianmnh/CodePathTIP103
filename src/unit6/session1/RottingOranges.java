package unit6.session1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Deque;

public class RottingOranges {

    static class Pair{
        public int r,c;
        public Pair(int y, int x){
            this.r = y;
            this.c = x;
        }

        @Override
        public String toString() {
            return "(" + r + "," + c + ")";
        }
    }


    public static int orangeRotting(int[][] grid){

        int fresh = 0;

        //Build queue to add rotten oranges
        Deque<Pair> queue = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) fresh++;
                if(grid[r][c] == 2) queue.addLast(new Pair(r,c));
            }
        }
        if(fresh==0) return 0;

        int[][] dirs = {{-1,0}, {1,0}, {0,-1},{0,1}};
        // up down left right
        int time = -1;
        while(!queue.isEmpty()){
            time++;
//            System.out.println(Arrays.asList(queue));
//            System.out.println("Time: " + time);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair rotten = queue.removeFirst();
                for(int[] dir: dirs){
                    // check bounds, and if fresh apple
                    int r = rotten.r+dir[0];
                    int c = rotten.c+dir[1];
                    if(r<0 || r>= grid.length || c < 0 || c>=grid[0].length || grid[r][c]!=1) continue;
                    queue.addLast(new Pair(r,c));
                    grid[r][c] = 2;
                    fresh--;
                }
            }
        }
//        System.out.println(fresh);

        return fresh > 0 ? -1 : time;
    }

    public static void main(String[] args) {
        System.out.println(orangeRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(orangeRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println(orangeRotting(new int[][]{{0,2}}));
    }
}
