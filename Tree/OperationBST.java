package Tree;

public class OperationBST {

    public static TreeNode insert(TreeNode curr, int data) {
        if(curr==null)  return new TreeNode(data);

        if(data< curr.data)
            curr.left = insert(curr.left, data);
        else
            curr.right = insert(curr.right, data);
        return curr;
    }

    public static TreeNode search(TreeNode root, int data) {
        TreeNode curr = root;
        while(curr!=null) {
            if(curr.data == data)
                return curr;
            else if(data< curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return null;
    }

    public static TreeNode delete(TreeNode curr, int key) {
        if(curr==null)  return null;

        if(key<curr.data) curr.left = delete(curr.left, key);
        else if(key>curr.data) curr.right = delete(curr.right, key);

        //key Found
        else {
            //Case I: No child
            if(curr.left==null && curr.right==null) return null;

            //Case II: Single Child
            if(curr.left!=null && curr.right==null) return curr.left;
            if(curr.left==null && curr.right!=null) return curr.right;

            //Case III: Two Child --> replace with successor (next value in Inorder traversal)
            TreeNode successorParent = curr;
            TreeNode successor = curr.right;

            while (successor.left!=null) {
                successorParent = successor;
                successor = successor.left;
            }

            if(successorParent == curr) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            curr.data = successor.data;
            return curr;
        }
        return curr;
    }
    public static void main(String[] args) {

    }
}
