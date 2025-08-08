package BitManipulation;

public class PlayWithBITS {

    //TC = O(min(a,b))
    static int findGCD(int a, int b) {
        int result = Math.min(a,b);
        while(result > 0) {
            if(a%result==0 && b%result==0) {
                break;
            }
            result--;
        }
        return  result;
    }

    static int findGDCEuclideanAlgo(int bigger, int smaller) {
        if(smaller==0)
            return bigger;
        return findGDCEuclideanAlgo(smaller, bigger%smaller);
    }

    //TC = O(sqrt(n))
    static boolean isPrime(int n) {
        for(int i=2;i<Math.sqrt(n);i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a=60, b=36;
        System.out.println(isPrime(13));
    }
}
