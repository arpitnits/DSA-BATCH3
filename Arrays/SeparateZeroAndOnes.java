package Arrays;

public class SeparateZeroAndOnes {

    static void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    static void twoPointer(int[] arr) {
        int l = 0, r=arr.length-1;

        while(l<r) {
            while(l<r && arr[l]==0) l++;
            while(l<r && arr[r]==1) r--;

            if(l<r)
                swap(arr, l, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0};

        twoPointer(arr);

        for(int num : arr)
            System.out.print(num + " ");
    }
}
