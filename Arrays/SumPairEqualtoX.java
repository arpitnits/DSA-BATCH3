package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairEqualtoX {

    static void twoPointerApproach(int[] arr, int X) {
        Arrays.sort(arr); //O(nlogN)

        int l =0, r= arr.length-1;
        //O(N)
        while(l<r) {
            int pairSum = arr[l] + arr[r];
            if (pairSum == X) {
                //Found one
                System.out.println("First: "+ arr[l] + " Second: " + arr[r]);
                l++;
            } else if (pairSum < X) {
                l++;
            } else {
                r--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {-2,4,-1,3,2,9};
        int X = 7;
        //twoPointerApproach(arr, X);
    }
}
