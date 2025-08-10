package BitManipulation;

import java.util.Arrays;

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


    static void allPrimeLessThanN(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        for(int i=2; i<Math.sqrt(n); i++) {

            //iterate inner loop for prime number, because for
            // all the other non-prime numbers, prev number must marked it divisible number as non-prime
            if(prime[i]) {
                //mark all the other divisible numbers as non-prime
                for(int j=i*i; j<=n; j=j+i) {
                    prime[j] = false;
                }
            }
        }


        for(int i=2;i<=n;i++) {
            if(prime[i]) {
                System.out.println("This is prime " + i);
            }
        }
    }

    static void getIthBit(int n, int i) {
        if((n & (1<<i)) !=0 ) {
            System.out.println("Bit is set");
        } else {
            System.out.println("Bit is not set");
        }
    }

    static void setIthBit(int n, int i) {
        System.out.println(n | (1<<i));
    }

    static void clearIthBit(int n, int i) {
        System.out.println(n & (~(1<<i)));
    }

    public static void main(String[] args) {
        int n = 10, i=2;
        getIthBit(n, i);
        setIthBit(n, i);
        clearIthBit(n,i);
    }
}
