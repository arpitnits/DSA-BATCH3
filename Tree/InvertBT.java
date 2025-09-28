package Tree;

public class InvertBT {

    public TreeNode invertTree(TreeNode root) {
        if(root==null)  return null;

        //Swap and recursively call
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
