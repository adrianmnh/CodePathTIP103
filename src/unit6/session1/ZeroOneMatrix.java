package unit6.session1;

import java.util.*;

public class ZeroOneMatrix {


        static class Pair{
            public int r,c;
            public Pair(int y, int x){
                this.r = y;
                this.c = x;
            }
        }
        public static int[][] updateMatrix(int[][] mat) {

            // int[][] res = new int[mat.length][mat[0].length];
            Deque<Pair> queue = new LinkedList<>();

            for(int r=0; r < mat.length; r++){
                for(int c=0; c< mat[0].length; c++){
                    if(mat[r][c]!=0)mat[r][c] = Integer.MAX_VALUE;
                    else queue.addLast(new Pair(r,c));
                }
            }
                            //up, down, left, right
            int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

            int length = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                length++;
                for (int i = 0; i < size; i++) {
                    Pair curr = queue.removeFirst();

                    for(int[] dir: dirs){
                        int r = curr.r + dir[0];
                        int c = curr.c + dir[1];

                        if(r<0 || r>= mat.length || c<0 || c>= mat[0].length || mat[r][c] != Integer.MAX_VALUE) continue;
                        mat[r][c] = length;
                        queue.addLast(new Pair(r,c));
                    }
                }

            }


            return mat;

        }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0,0,0},{0,1,0},{0,0,0}})));
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}})));
    }


}
