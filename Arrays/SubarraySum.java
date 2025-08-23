package Arrays;

public class SubarraySum {

    static int[] slidingWindow(int[] arr, int targetSum) {
        /*

        [2,4,6,1,8]

        l=0,r=0

        sum = 2 < target
        --> l=0,r=1

        sum=6 < target
        --> l=0, r=2

        sum=12 > target
        --> l=1, r=2

        sum = 10 < taret
        --> l=1, r=3

        sum = 11 == target
            --> return
         */

        int l=0,r=0, n= arr.length, currSum=0;
        while(l<=r && r<n) {
            if(currSum == targetSum) {
                return new int[]{l,r-1};


            }
            else if(currSum<targetSum) {
                //increasing
                currSum = currSum + arr[r];
                r++;
            } else {
                //reducing
                currSum = currSum - arr[l];
                l++;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] arr = {2,4,6,1,8};
        int[] indexes = slidingWindow(arr, 11);

        for(int val : indexes)
            System.out.print(val + " ");

    }
}
