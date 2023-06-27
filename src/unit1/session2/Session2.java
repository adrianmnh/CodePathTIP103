package unit1.session2;

import static unit1.session2.CanIWin.canIWin;
import static unit1.session2.IntegerReplacement.integerReplacement;

public class Session2 {


    public static void main(String[] args) {
        int[] ns = {8, 7, 4};
        System.out.println("Integer Replacement:");
        for (int n : ns)
            System.out.printf("input %d - output %d\n", n, integerReplacement(n));

        int[][] pairs = {{10, 11}, {10, 0}, {10, 1}};

        System.out.println(canIWin(10,11));
        System.out.println(canIWin(10,0));
        System.out.println(canIWin(10,1));
    }

}

//










