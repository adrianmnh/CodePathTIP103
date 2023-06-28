package unit4.session2;

import java.util.Stack;

public class BasicCalculator {

    public static int calculate(String s){
        System.out.println(s);
        Stack<Object> stack = new Stack<>();
        int num=0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == ' ') continue;
            else if(curr == '+'){
                continue;
            }
            else if(curr == '(' || curr == '-'){
                stack.push(curr);
            } else{

                if(curr == ')') {
                    stack = evaluate(stack, true);
                    num = (int)stack.pop();
                    System.out.println("After evaluating parenthesis");
                }
                else if(curr>= '0' && curr <= '9'){
                    int start = i;
                    int end=i+1;
                    while( (i + 1) < s.length() && s.charAt(i+1) >= 0 + '0' && s.charAt(i+1)<=9 + '0' ){
                        i+=1;
                        end+=1;
                    }
                        num = Integer.parseInt(s.substring(start, end));
                        System.out.println(s.substring(start, end));
                }
                if(stack.size() >= 1 && stack.peek().equals('-') ) {
                    stack.pop();
                    num = num*-1;
                }
                stack.push(num);

            }

        }

        stack = evaluate(stack, false);

        return (int)stack.pop();
    }

    public static Stack<Object> evaluate(Stack<Object> stack, boolean parenthesis){
        int Rexp = (int)stack.pop();

        while( stack.size() >= 1 && !stack.peek().equals('(') ) {
            Rexp+=(int)stack.pop();
        }
        if(parenthesis) stack.pop();
        stack.push(Rexp);
        return stack;
    }

    public static void main(String[] args) {

        System.out.println(calculate("7-0+4"));
        System.out.println(calculate("(7)-(0)+(4)"));
        System.out.println(calculate("- (3 + (4 + 5))"));
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("-2+ 1"));
        System.out.println(calculate("(-112+(44+56+27)-3)-(6+8)"));






























    }
}
