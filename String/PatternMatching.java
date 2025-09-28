package String;

import java.util.ArrayList;
import java.util.List;

public class PatternMatching {


    public static List<Integer> slidingWindow(String txt, String pat) {
        List<Integer> matches = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        for(int i=0;i<=n-m;i++) {
            int j;
            for(j=0;j<m;j++) {
               if(txt.charAt(i+j) != pat.charAt(j)) break;
            }
            if(j==m) matches.add(i);
        }

        return matches;
    }

    public static List<Integer> rapinKarp(String txt, String pat) {
        List<Integer> matches = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        int q = 101;

        int t = 0, p = 0;

        int h = 1, d = m + n;
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        //Calculate hashValue
        for (int i = 0; i < m; i++) {
            t += txt.charAt(i) + (int) Math.pow(q, i);
            p += pat.charAt(i) + (int) Math.pow(q, i);
        }

        for (int i = 0; i <= n - m; i++) {
            //Check for hash Value
            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) break;
                }
                if (j == m) {
                    System.out.println("Pattern matches: " + i);
                    matches.add(i);
                }
            }

            // Calculate the hash value for next window : adding trailing digit
            //and remove leading digit
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                //converting negative value of hash_t to positive.
                if (t < 0) t = (t + q);
            }
        }
        return matches;
    }

    private static int[] computeLPS(String pat, int m) {
        int j=0,i=1;

        int[] lps = new int[m];
        lps[0]=0; //First Char can't have any prefix

        while(i<m) {

            if (pat.charAt(j) == pat.charAt(i)) {
                j++;
                lps[i] = j; //lps[i++] = ++j;
                i++;
            } else {
                //Character don't matches
                if(j!=0) {
                    j=lps[j-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void kmpAlgo(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[] lps = computeLPS(pat, m);

        int i=0, j=0;

        //the number of character remaining in text is more than pattern
        while((n-i) >= (m-j)) {
            if( txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if(j==m) {
                System.out.println("Pattern matches at Index:" + i);
                return;
            }

            if(i<n && txt.charAt(i) != pat.charAt(j)) {
                if(j!=0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String txt = "abeabecdfg";
        String pat = "abe";

        //System.out.println(slidingWindow(txt, pat));
        System.out.println(rapinKarp(txt, pat));
    }
}
