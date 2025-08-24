package Backtracking;

public class TowerOfHanoi {

    static void towerOfHanoiRecursive(int n, char source, char destination, char aux) {
        if(n==1) {
            System.out.println("Move Disk 1 from " + source + " to " + destination);
            return;
        }

        towerOfHanoiRecursive(n-1, source, aux, destination); //A-->B using C
        System.out.println("Move Disk " + n + " from " + source + " to " + destination);
        towerOfHanoiRecursive(n-1, aux, destination, source); //B-->C using A
    }

    public static void main(String[] args) {
        int numDisk = 3;
        char sourcePeg = 'A';
        char destinationPeg = 'C';
        char auxPeg = 'B';

        towerOfHanoiRecursive(numDisk, sourcePeg, destinationPeg, auxPeg);
    }
}
