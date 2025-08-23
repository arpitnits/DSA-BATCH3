package Arrays;

public class BitonicPoint {

    static int findBitonicPoint(int[] arr) {
        int n = arr.length;

        int l=0, r=n-1, mid=0;

        while(l<=r) {
            mid=l+(r-l)/2;

            //Found
            if(mid>0 && mid<n-1 &&
                    arr[mid] > arr[mid-1] && arr[mid]>arr[mid+1]) {
                return mid;
            } else if(mid<n-1 && arr[mid]<arr[mid+1]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};

        System.out.println(findBitonicPoint(arr));
    }
}
