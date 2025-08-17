package Arrays;

public class SortingAlgo {

    static void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped = false;

        for(int i=0;i<n;i++) {
            swapped = false;
            for(int j=0;j<n-i-1; j++) {
                if(arr[j+1] < arr[j]) {
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if(!swapped)    break;
        }
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        int min_index;

        for(int i=0;i<n;i++) {
            min_index = i;

            //Check the min value on right side
            for(int j=i+1;j<n;j++) {
                if(arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            //as now we min possible on righ side, swap
            swap(arr, i, min_index);
        }
    }

    //TC- O(N^2)
    static void insertionSort(int[] arr) {
        int n= arr.length, value, hole;
        for(int i=1;i<n;i++) {
            value = arr[i];
            hole = i-1;

            while(hole >=0 && arr[hole]>=value) {
                arr[hole+1] = arr[hole]; //shifting by 1 position to right
                hole--;
            }
            arr[hole+1] = value; //place the value at correct hole
        }
    }

    //SC = O(N)
    static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid-l+1;
        int n2 = r-mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        //Creating left temp Array
        for(int i=0;i<n1;i++) left[i] = arr[i+l];

        //Creating right temp array
        for(int i=0;i<n2;i++) right[i] = arr[i+mid+1];

        //Compare both temp array and add the lesser value
        int i=0,j=0,k=l;
        while(i<n1 && j<n2) {
            if(left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        //Dump remaining values
        while(i<n1) arr[k++] = left[i++];
        while(j<n2) arr[k++] = right[j++];
    }

    static void splitAndMerge(int[] arr, int l, int r) {
        int mid;
        //O(logn)
        if(l<r) {
            mid = l+(r-l)/2;
            splitAndMerge(arr, l, mid);
            splitAndMerge(arr, mid+1, r);
            merge(arr, l, mid, r); //O(n)
        }
    }

    //TC = O(nLogn)
    static void mergeSort(int[] arr) {
        splitAndMerge(arr, 0, arr.length-1);
    }

    static int partition(int[] arr, int l, int r) {
        int pivotValue = arr[r], i=l,j=l-1;

        while(i<r) {
            if(arr[i]<pivotValue) {
                j++;
                swap(arr, j, i);
            }
            i++;
        }
        j++;
        swap(arr, i, j);
        return j;
    }

    static void partitionAndSort(int[] arr, int l, int r) {
        if(l<r) {
            int pivot = partition(arr, l, r);  //O(n)

            //split the remaining
            partitionAndSort(arr, l, pivot-1); //O(logN)
            partitionAndSort(arr, pivot+1, r);
        }
    }

    //TC=O(NlogN)
    static void quickSort(int[] arr) {
        int l=0, r=arr.length-1;
        partitionAndSort(arr, 0, r);
    }


    public static void main(String[] args) {
        int[] arr = {5,2,1,9,3};
        quickSort(arr);

        for(int num:arr) System.out.print(num+" ");
    }
}
