package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelBT {

    //TC = O(N)
    int getLevel(TreeNode root, int data) {
        if(root==null) return 0;

        // Write your code here
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        int level=1;

        while(!q.isEmpty()) {
            int qSize = q.size(); //

            while(qSize>0) { //
                TreeNode currNode  = q.poll(); //retrieve and remove

                if(currNode.data==data) return level; //

                if(currNode.left!=null) q.add(currNode.left);
                if(currNode.right!=null) q.add(currNode.right);

                qSize--;
            }
            level++;

        }
        return level>0 ? level : -1;
    }
}
