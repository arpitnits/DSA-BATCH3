package Stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s;
    int minEle = -1;
    public MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        if(s.isEmpty()) {
            minEle = val;
            s.push(val);
        } else if(val <= minEle) {
            s.add(2*val -minEle);
            minEle = val;
        } else {
            s.add(val);
        }
    }

    public void pop() {
        if(!s.isEmpty()) {
            int val = s.pop();
            if(val <=minEle)
                minEle = 2*minEle - val;
        }
    }

    public int top() {
        if(s.isEmpty()) return -1;

        int val = s.peek();
        if(val<=minEle) return minEle;
        else return val;
    }

    public int getMin() {
        return minEle;
    }
}
