package Stack;

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
}
