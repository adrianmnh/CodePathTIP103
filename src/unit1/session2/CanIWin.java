package unit1.session2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CanIWin {

    /*
    Problem #2: Can I Win

    Original Problem on Leetcode: Can I Win

    In the "100 game" two players take turns adding,
    to a running total, any integer from 1 to 10.
    The player who first causes the running total to reach or exceed 100 wins.

    What if we change the game so that players cannot re-use integers?

    For example, two players might take turns drawing from
    a common pool of numbers from 1 to 15 without replacement
    until they reach a total >= 100.

    Given two integers maxChoosableInteger and desiredTotal,
    return true if the first player to move can force a win,
    otherwise, return false.
    Assume both players play optimally.

    */


    public static boolean canIWin(int maxChoosableInteger, int desiredTotal){

        if(desiredTotal <= maxChoosableInteger) return true;
        int sum = (maxChoosableInteger+1)*maxChoosableInteger/2;
        if(sum == desiredTotal) {
            return maxChoosableInteger % 2 == 1;
        } else if(sum < desiredTotal) return false;

        boolean[] used = new boolean[maxChoosableInteger+1];
        HashMap<String, Boolean> seen = new HashMap<>();

        return canWin(0, desiredTotal, used, seen);

    }

    public static boolean canWin(int currentSum, int desiredTotal, boolean[] used, HashMap<String, Boolean> seen){
        if(currentSum >= desiredTotal) return false;
        String bitRep = bitMap(used);
        System.out.println(bitRep);
        Boolean cachedStatus = seen.get(bitRep);
        if(cachedStatus != null){
            return cachedStatus;
        }
        for (int i = 1; i < used.length; i++) {
            if(used[i] == false){
                used[i] = true;
                cachedStatus = !canWin(currentSum+i, desiredTotal, used, seen);
                used[i] = false;
                if(cachedStatus == true) break;
            }
        }
        seen.put(bitRep, cachedStatus);
        return cachedStatus;

    }

    public static String bitMap(boolean[] used) {
//        System.out.println(used);
        int bit = 0;
        for (boolean v : used)  {
            bit = bit << 1;
//            System.out.println("First" + Integer.toBinaryString(bit));
            if (v) {
                bit = bit | 1;
//            System.out.println("sec" + Integer.toBinaryString(bit));
            }
        }
//        System.out.println(Integer.toBinaryString(bit));
        return Integer.toBinaryString(bit);
    }

    public static void main(String[] args) {
//        System.out.println(canIWin(4,10));
//        System.out.println(canIWin(5,15));
//        System.out.println(canIWin(10,0));
//        System.out.println(canIWin(10,11));
//        System.out.println(canIWin(10,1));
        System.out.println(canIWin(5,13));
//        boolean[] used = new boolean[5+1];
//        used[5] = true;
//        used[1] = true;
//        System.out.println(bitMap(used));
//        int a = 10;
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(a);
//        a = a << 1;
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(a);
//
//        a = a << 1;
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(a);


    }








































//    public static boolean canIWin(int max, int total){
//
//        if (total < max) return true;
//        else if( total - max < max - 1  ){
//            return false;
//        } else {
//            return canIWin(max--, total-max);
//        }
//
//    }
//    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
//        if (desiredTotal <= 0) return true;
//
//        //A special case is if the total sum is less than desiredTotal, none of the players can win
//        if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) return false;
//
//        char[] remain = new char[maxChoosableInteger + 1];
//        Arrays.fill(remain, '1');
//        Map<String, Boolean> map = new HashMap<>();
//        return canWin(remain, map, desiredTotal);
//    }

//    private static boolean canWin(char[] remain, Map<String, Boolean> map, int rem) {
//        if (rem <= 0) return false; //means the previous person has already reach the end
//        String status = new String(remain);
//        //System.out.println(status);
//        if (map.containsKey(status)) return map.get(status);
//
//        boolean res = false;
//
//        for (int i = 1; i < remain.length; i++) {
//            if (remain[i] == '0') continue;
//            remain[i] = '0';
//            if (!canWin(remain, map, rem - i)) {// if there exist one strategy, that by taking that stategy, the second player cannot win, just take that strategy...
//                res = true;
//            }
//            remain[i] = '1';
//            if (res) break;
//        }
//        map.put(status, res);
//        return res;
//    }

//    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
//        int[] usable = new int[maxChoosableInteger];
//        for (int i = 0; i < maxChoosableInteger; i++) {
//            usable[i] = i + 1;
//        }
//
//        if ((1 + maxChoosableInteger) * maxChoosableInteger <= desiredTotal) {
//            return false;
//        }
//
//        Map<String, Boolean> cache = new HashMap<>();
//        return hint(maxChoosableInteger, desiredTotal, usable, cache, 0);
//    }
//
//    private boolean hint(int maxChoosableInteger, int desiredTotal, int[] usable, Map<String, Boolean> cache, int already) {
//        if (usable.length == 0) {
//            return false;
//        }
//
//        String state = Arrays.toString(usable);
//        if (cache.containsKey(state)) {
//            return cache.get(state);
//        }
//
//        for (int i = 0; i < usable.length; i++) {
//            int chosenNumber = usable[i];
//            int[] newUsable = getNewUsable(usable, i);
//            if (chosenNumber + already >= desiredTotal || !hint(maxChoosableInteger, desiredTotal, newUsable, cache, already + chosenNumber)) {
//                cache.put(state, true);
//                return true;
//            }
//        }
//
//        cache.put(state, false);
//        return false;
//    }
//    private int[] getNewUsable(int[] usable, int index) {
//        int[] newUsable = new int[usable.length - 1];
//        int newIndex = 0;
//        for (int i = 0; i < usable.length; i++) {
//            if (i != index) {
//                newUsable[newIndex++] = usable[i];
//            }
//        }
//        return newUsable;
//    }

}
