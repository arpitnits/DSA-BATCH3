package Tree;

public class DiameterBT {

    int diameter=0;

    public int getHeightAndUpdateDiameter(TreeNode root) {
        if(root==null)  return 0;

        int leftHeight =  getHeightAndUpdateDiameter(root.left);
        int rightHeight = getHeightAndUpdateDiameter(root.right);

        diameter = Math.max(diameter, leftHeight+rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int findDiameter(TreeNode root) {
        getHeightAndUpdateDiameter(root);
        return diameter;
    }
}
