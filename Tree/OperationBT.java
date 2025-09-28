package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class OperationBT {

    /*
    Do level Order Traversal and store whenever you find any position
     */
    //TC = O(N)
    //SC = O(W) ; W= (Max number of node at any level)
    public static TreeNode insert(TreeNode root, int data) {
        TreeNode newNode = new TreeNode(data);
        if(root==null)  return newNode; //Tree is empty

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();

            if(currNode.left==null) {
                //add new element to left and return
                currNode.left = newNode;
                break;
            } else {
                q.add(currNode.left);
            }

            if(currNode.right == null) {
                //add new element to right and return
                currNode.right = newNode;
                break;
            } else {
                q.add(currNode.right);
            }
        }
        return root;
    }

    public static TreeNode deleteBottomNode(TreeNode root, TreeNode delNode) {
        if(root==null||root==delNode)  return null;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode curr;
        while (!q.isEmpty()) {
            curr = q.poll();

            if(curr.left!=null) {
                if(curr.left==delNode) {
                    curr.left = null;
                    break;
                }
                q.add(curr.left);
            }

            if(curr.right!=null) {
                if(curr.right==delNode) {
                    curr.right = null;
                    break;
                }
                q.add(curr.right);
            }
        }
        return root;
    }

    public static TreeNode delete(TreeNode root, int data) {
        //Swap to be deleted node and bottom right most node
        // delete bottom right most node
        if(root==null)  return null;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode curr = null;
        TreeNode keyNode = null;

        while (!q.isEmpty()) {
            curr = q.poll();

            if(curr.data == data) {
                keyNode = curr;
            }

            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }

        //No key found
        if(keyNode==null) return root;
        if(keyNode!=curr) keyNode.data = curr.data;

        return deleteBottomNode(root, curr);
    }

    public static void main(String[] args) {
        int[] arr = {4,1,6,7,9,1,2};
        TreeNode root = null;

        for(int a : arr)
            root = insert(root, a);

        System.out.println(Traversal.levelOrder(root));

        root = delete(root, 6);
        System.out.println(Traversal.levelOrder(root));
    }
}
