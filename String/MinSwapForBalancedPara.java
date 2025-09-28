package String;

import java.util.Stack;

public class MinSwapForBalancedPara {

    //TC = O(N)
    //SC = O(N) --> stack
    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if (ch == '[') stack.push(ch); //If Open bracket --> add to stack
            else {
                //If close bracket then check stack top can have '[' and
                // we can form one perfect pair and remove this
                if (!stack.isEmpty() && stack.peek() == '[') {
                    //forms a perfect pair
                    stack.pop();
                }
            }
        }
        return (int)Math.ceil(stack.size()/2.0); //One swap fixes 2 pairs and stack will have only open brackers
    }

    public static int minSwapsWithoutStack(String s) {
        int open=0;
        for(char ch : s.toCharArray()) {
            if(ch=='[') open++;
            else {
                if(open>0) open--; //remove one open bracket
            }
        }
        return (int)Math.ceil(open/2.0);  //open can be odd, so doing ceil
    }

}
