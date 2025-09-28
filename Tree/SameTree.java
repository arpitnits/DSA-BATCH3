package Tree;

public class SameTree {

    /*
    TC: O(MIN(N,M))
    SC: O(H)
    H= Min height of both trees
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)  return true;

        if(p!=null && q==null) return false;
        if(p==null && q!=null)  return false;

        return p.data==q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
