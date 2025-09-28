package Tree;

public class BalancedBT {

    //TC = O(N)
    //SC = O(H)
    private int maxHeight(TreeNode curr) {
        if(curr==null)  return 0;

        int left = maxHeight(curr.left);
        int right = maxHeight(curr.right);

        if(left==-1 || right==-1 || Math.abs(left-right)>1) return -1;

        return Math.max(left,right)+1;
    }

    public boolean isBalanced(TreeNode root) {
        return maxHeight(root)!=-1;
    }
}
