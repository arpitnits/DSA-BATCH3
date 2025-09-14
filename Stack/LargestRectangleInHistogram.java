package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    //heights = [2,1,5,6,2,3]
    static int[] nextSmaller(int[] arr) {
        int n = arr.length;

        int[] nextS = new int[n];

        Stack<Integer> s = new Stack<>(); //Monotonic increasing

        for(int i=0;i<n;i++) {
            while (!s.isEmpty() && arr[i] < arr[s.peek()]) {
                nextS[s.pop()] = i;  //Fill next Smallest with current i
            }
            s.push(i);
        }

        while(!s.isEmpty()) nextS[s.pop()] = n; //remaining in stack

        return nextS;
    }

    static int[] prevSmallest(int[] arr) {
        int n = arr.length;

        int[] nextS = new int[n];
        Stack<Integer> s = new Stack<>(); //Monotonic increasing

        for(int i=n-1;i>=0;i--) {
            while (!s.isEmpty() && arr[i] < arr[s.peek()]) {
                nextS[s.pop()] = i;  //Fill next Smallest with current i
            }
            s.push(i);
        }

        while(!s.isEmpty()) nextS[s.pop()] = -1; //remaining in stack

        return nextS;
    }

    static int getMaxAreaBruteForce(int[] arr) {
        int maxArea = 0, n= arr.length;

        for(int i=0; i<n;i++) {
            int currArea = arr[i];

            //Check on left while we have greater height bar
            for(int j=i-1; j>=0 && arr[j]>= arr[i]; j--) {
                currArea+= arr[i];
            }


            //Check on right while we have greater height bar
            for(int j=i+1; j<n && arr[j]>= arr[i]; j++) {
                currArea+= arr[i];
            }

            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}
