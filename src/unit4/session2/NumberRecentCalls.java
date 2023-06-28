package unit4.session2;

import java.util.*;

public class NumberRecentCalls {
//    static class RecentCounter{
//        List<Integer> calls = new ArrayList<>();  // Time call arrived
//        int counter;
//        int ping(int t){
//            // return number of requests that have happened in [t-3000, t] inclusive
//            calls.add(t);
//            Iterator<Integer> itr = calls.iterator();
//            while(itr.hasNext()){
//                if(itr.next() < t - 3000){
//                    itr.remove();
//                }
//            }
//            System.out.println(calls.size());
//            return calls.size();
//        }
//        RecentCounter(){
//            counter = 0;
//        }
//    }

    static class RecentCounter{
        LinkedList<Integer> calls =  new LinkedList<>();
        int counter;
        int ping(int t){
            calls.addLast(t);
            // return number of requests that have happened in [t-3000, t] inclusive
            while(calls.getFirst() < t -3000)
                calls.removeFirst();
            System.out.println(calls.size());
            return calls.size();
        }
        RecentCounter(){
            counter = 0;
        }
    }

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));

    }
}
