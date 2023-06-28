package unit4.session2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids){
        LinkedList<Integer> space = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
            for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if(asteroid<0) { // asteroid MOVING LEFT
                if(right.isEmpty()) space.addLast(asteroid); // nothing to collide with
                else {
                    while (!right.isEmpty() && Math.abs(asteroid) > right.getLast()) {
                        right.removeLast();
                    }
                    /// check stack and pop
                    if(right.isEmpty())
                        space.addLast(asteroid);
                    else if(!right.isEmpty() && Math.abs(asteroid) == right.getLast()){
                        right.removeLast();
                    }
                    else if(right.getLast() > Math.abs(asteroid)){
                        continue;
                    }
                }
            }
            else { //asteroid is moving RIGHT
                right.addLast(asteroid);
            }
        }
            if(!right.isEmpty()){
            space.addAll(right);
        }
    //        System.out.println(space);
        return space.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,1,-2,-1}))); // -2 -2 -1
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5}))); //   5 10
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8,-8}))); // 0
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5}))); // 10
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-1,1,2}))); // -2 -1 1 2
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,1,-2,1}))); // -2 -2 1
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,1,-1,-2}))); // -2 -2
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-1,1,-2}))); // -2 -1 -2
    }
}
