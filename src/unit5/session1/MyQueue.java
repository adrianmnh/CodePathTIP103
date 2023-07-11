package unit5.session1;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stIn;
    Stack<Integer> stOut;

    public MyQueue(){
        stIn = new Stack<>();
        stOut = new Stack<>();
    }

    // <---- remove [Front]                           [End] <-- insert

    public void push(int x) {
        stIn.push(x);
        System.out.println("Push: " + x);
    }

    public int pop() {
        if(stOut.empty()){
            while(!stIn.empty()){
                stOut.push(stIn.pop());
            }
        }
        System.out.println("Pop:  " + stOut.peek());
        return stOut.pop();
    }

    public int peek() {
        if(stOut.empty()){
            while(!stIn.empty()){
                stOut.push(stIn.pop());
            }
        }
        System.out.println("Peek: " + stOut.peek());
        return stOut.peek();
    }

    public boolean empty() {
        System.out.println("Empty: " + (stIn.empty() && stOut.empty()));
        return stIn.empty() && stOut.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}
