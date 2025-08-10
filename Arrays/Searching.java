package Arrays;

public class Searching {

    // TC = O(N)
    static int linearSearch(int[] arr, int target) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int l=0, r=arr.length-1;
        if(target < arr[l] || target>arr[r]) return -1;

        while(l<=r) {
            int mid = l+ (r-l)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                //target lies on left side
                r = mid - 1;
            } else {
                //target lies on right side
                l = mid + 1;
            }
        }
        return -1;
    }


    static int binarySearchRec(int[] arr, int target, int l, int r) {
        if(l>r) return -1; //base case or terminating condition

        int mid = l+(r-l)/2;

        if(arr[mid]==target)
            return mid; //element found

        if(target < arr[mid])
            return binarySearchRec(arr, target, l, mid-1); //reducing right boundary

        return binarySearchRec(arr, target, mid+1, r); //reducing left boundary
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,8,9,10};
        System.out.println(binarySearch(arr, 7));
    }
}
