package Arrays;

public class MajorityElements {


    //Appears more than n/2 times
    static int majorityElement(int[] arr) {
        int candidate = 0, votes=0; //O(1)

        //o(N)
        for (int j : arr) {
            if (votes == 0) {
                candidate = j;
                votes=1;
            } else {
                if (j == candidate) votes++;
                else votes--;
            }
        }

        System.out.println("InBetween " + candidate);
        int count = 0;
        //o(N)
        for(int cand : arr) {
            if(cand == candidate) count++;
        }

        if(count>(arr.length/2)) return candidate;
        return -1;
    //O(N) + O(N) = ~O(N)
    }
    public static void main(String[] args) {
        int[] candidates = {5, 5, 1, 5, 2, 5, 3, 5, 4, 5, 6, 5, 7};

        System.out.println(majorityElement(candidates));

    }
}
