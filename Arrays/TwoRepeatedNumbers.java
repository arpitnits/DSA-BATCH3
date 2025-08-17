package Arrays;

public class TwoRepeatedNumbers {

    /*
    1. Take XOR of array with (1..n)
    2. Here we get XOR = c (a^b)
    3. Now to separate out a and b, we will split it into 2 bucket &
       reduce the problem to single duplicate
    4. To separate, add check rightMostSetBit number
     */
    static void xorApproach(int[] arr, int n) {

        int xor = 0;

        //XOR of complete array
        for(int num : arr) xor^= num;

        //XOR from 1..n
        for(int num=1;num<=n;num++) xor^= num;

        int rightMostSetBitNumber = xor & ~(xor-1);

        int num1=0, num2=0;

        //Split array
        for(int num : arr) {
            if((rightMostSetBitNumber & num) == 0)
                num1^= num;
            else
                num2^= num;
        }

        //Split 1..n
        for(int num=1;num<=n;num++) {
            if((rightMostSetBitNumber & num) == 0)
                num1^= num;
            else
                num2^= num;
        }

        System.out.println("First:"+ num1 + " Second:"+num2);
    }
    static void indexApproach(int[] arr, int n) {
        for(int i=0;i<arr.length;i++) {
            int index = Math.abs(arr[i]);
            if(arr[index] > 0) arr[index] = -arr[index];
            else System.out.println("Repeated: " + index);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 3};

        /*
        {, , , , , }
        {1, , 3, }
        11  --> split
        01  --> split
        10

        xor = 2 (1^3)
        a
        b
        10

        {1, 2, 1, 3, 4, 3}
        {1, 2, 3, 4}

        1 --> {2, 3, 2,3, 3}  = 3
        0 --> {1, 4, 1, 1, 4} = 1
         */

        xorApproach(arr, 4);
    }
}
