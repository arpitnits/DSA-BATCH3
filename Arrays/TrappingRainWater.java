package Arrays;

public class TrappingRainWater {

    static int preComputeApproach(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = 0;
        //preCompute leftMax array
        for(int i=1;i<n;i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);
        }

        rightMax[n-1] = 0;
        //preCompute rightMax array
        for(int i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], arr[i+1]);
        }

        //find save water for each block
        int totalWaterSaved =0;
        for(int i=1;i<n-1;i++) {
            int MinOfLeftAndRight = Math.min(leftMax[i], rightMax[i]);

            //If current height is less than max of left and right Height
            if(arr[i] < MinOfLeftAndRight) {
                totalWaterSaved += MinOfLeftAndRight - arr[i];
            }
        }
        return totalWaterSaved;
    }


    static int twoPointer(int[] arr) {
        int n = arr.length;
        int l=0,r=n-1;
        int leftMax = 0, rightMax=0;
        int totalWater=0;

        while(l<r) {

            //if left height is smaller then right can't help here
            if(arr[l] < arr[r]) {
                if(arr[l] >= leftMax)   leftMax = arr[l]; //update boundary
                else totalWater+= leftMax-arr[l]; //trapped water
                l++; //move inward
            } else {
                if(arr[r] >= rightMax)   rightMax = arr[r];
                else totalWater+= rightMax-arr[r];
                r--; //move inward
            }
        }
        return totalWater;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(twoPointer(arr));
    }
}
