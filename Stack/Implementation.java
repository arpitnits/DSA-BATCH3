package Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Implementation {

    public class ArrayImplementation {

        int top = -1;
        int[] arr =  new int[10000];

        void push(int x) {
            arr[++top] = x;
        }

        int pop() {
            return arr[top--];
        }

        int peek() {
            return arr[top];
        }

        boolean isEmpty() {
            return top==-1;
        }

        int size() {
            return top+1;
        }

    }

    public class UsingQueue {

        Queue<Integer> queue = new LinkedList<>();
        public UsingQueue() {

        }

        //Push operation costly
        public void push(int x) {
            queue.add(x);
            int i=0;
            while(i<queue.size()-1) {
                queue.add(queue.remove());
                i++;
            }
        }

        public int pop() {
            if(!queue.isEmpty())
                return queue.remove();
            return Integer.MIN_VALUE;
        }

        public int top() {
            if(!queue.isEmpty())
                return queue.peek();
            return Integer.MIN_VALUE;
        }

        public boolean empty() {
            return queue.size()==0;
        }
    }
}
