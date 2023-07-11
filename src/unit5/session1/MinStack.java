package unit5.session1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class MinStack {

    LinkedList<Map.Entry<Integer, Integer>> minSt; // < value, min >

    public MinStack(){
        minSt = new LinkedList<>();
    }

    public void push(int val){
        int minVal;
        if(minSt.size() == 0){
            minVal = val;
        } else {
            int prevMin = minSt.getFirst().getValue();
            if( val < prevMin ) minVal = val;
            else minVal = prevMin;
        }
        minSt.addFirst(Map.entry(val, minVal));
    }

    public void pop(){
        minSt.removeFirst();
    }

    public int top(){
        return minSt.peekFirst().getKey();
    }

    public int getMin(){
        return minSt.peekFirst().getValue();
    }


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.getMin();
        obj.pop();
        obj.top();
        obj.getMin();
    }
}


