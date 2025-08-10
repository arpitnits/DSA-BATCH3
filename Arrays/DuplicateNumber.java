package Arrays;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNumber {

    static void hashingApproach(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>(); //SC = O(N)

        //TC = O(N)
        for(int num : arr) { //For each
            if(freq.containsKey(num))  {
                System.out.println("Duplicate is " + num);
                return;
            }
            freq.put(num, 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,4,6,5};
        hashingApproach(arr);
    }
}
