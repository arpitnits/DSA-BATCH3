package Stack;

import java.util.Stack;

public class CelebrityProblem {

    public int findCelebrity(int mat[][]) {
        int n = mat.length;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++)    s.push(i);
        int celeb=-1;

        //eliminate till there is more than 1 person
        while(s.size()>1) {
            int first = s.pop();
            int second = s.pop();

            //If first know second --> first will be not be celeb
            if(mat[first][second]==1) s.push(second);

            //If second know first --> second will be not be celeb
            if(mat[second][first]==1) s.push(first);

            //Othercase: Both know/doesn't know each other: both can be celeb
        }

        //If there is any possible celeb
        if(!s.isEmpty()) {
            celeb = s.pop();

            //celeb should not know anyone
            for(int col=0;col<n;col++) {
                if(celeb!=col && mat[celeb][col]==1)  return -1;
            }

            //everyone should know celeb
            for(int row=0;row<n;row++) {
                if(mat[row][celeb]==0)  return -1;
            }
        }
        return celeb;
    }
}
