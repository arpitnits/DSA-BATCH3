package Tree;

public class CousinsBT {

    public boolean isSiblings(TreeNode root, int x, int y) {
        if(root==null)  return false;

        if ((root.left!=null && root.right!=null) &&
                ((root.left.data==x && root.right.data==y) ||
                    (root.left.data==y && root.right.data==x)))
            return true;

        return isSiblings(root.left, x, y) || isSiblings(root.right, x, y);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        LevelBT levelBT = new LevelBT();
        int l1 = levelBT.getLevel(root, x);
        int l2 = levelBT.getLevel(root, y);

        if(l1==-1 || l2==-1)    return false;

        if(l1==l2 && !isSiblings(root, x, y)) {
            return true;
        }
        /*
        Cousin

        1. Same Level --> getLevel(root, x)
        2. Not Siblings -->
        */
        return false;
    }
}
