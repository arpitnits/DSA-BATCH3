package Backtracking;

public class FindBinaryNumbers {

    static void findBinaryRecursive(String s, int n) {
        if(s.length() == n) {
            System.out.print(s + " ");
            return;
        }

        findBinaryRecursive(s+"0", n);
        findBinaryRecursive(s+"1",n);
    }

    static void findBinary(int n) {
        findBinaryRecursive("", n);
    }
    public static void main(String[] args) {
        findBinary(4);
    }
}
