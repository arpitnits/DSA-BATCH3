package Stack;

import java.util.Stack;

public class StockSpan {

    public int[] calculateSpan(int[] stocks) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[stocks.length];

        for(int i=0;i<stocks.length;i++) {

            // remove all values lesser than current
            // till you find any bigger value than current
            while(!stack.isEmpty() && stocks[stack.peek()] <= stocks[i]) {
                stack.pop();
            }

            //is stack is empty --> all values on left are lesser --> i+1
            //else --> number of less value in between = current Index - stack Top
            span[i] = stack.isEmpty() ? (i+1) : i-stack.peek();

            // Add current index into stack
            stack.push(i);
        }
        return span;
    }
}
