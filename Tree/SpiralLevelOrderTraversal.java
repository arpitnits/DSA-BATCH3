package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SpiralLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>(); //left-->right
        Stack<TreeNode> s2 = new Stack<>(); //right-->left

        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {

            //Iterate s1
            while (!s1.isEmpty()) {
                TreeNode curr = s1.pop();
                temp.add(curr.data);

                if(curr.left!=null) s2.push(curr.left);
                if(curr.right!=null) s2.push(curr.right);
            }
            if (!temp.isEmpty()) finalList.add(temp);
            temp = new ArrayList<>();

            //Iterate s2
            while (!s2.isEmpty()) {
                TreeNode curr = s2.pop();
                temp.add(curr.data);

                if(curr.right!=null) s1.push(curr.right);
                if(curr.left!=null) s1.push(curr.left);
            }
            if (!temp.isEmpty()) finalList.add(temp);
            temp = new ArrayList<>();
        }
        return finalList;
    }
}
