package Arrays;

public class MissingNumber {

    static int XORApproach(int[] arr, int n) {
        int xorOfNumber = 0;
        for(int i=1;i<=n;i++) {
            xorOfNumber^= i;
        }

        for(int num: arr) {
            xorOfNumber^= num;
        }

        return xorOfNumber;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,4,6,3,7,8};

        System.out.println(XORApproach(arr, 8));
    }
}
