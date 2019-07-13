package isSymmetrical;

public class Solution{
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null) return true;

        return mirror(pRoot.left, pRoot.right);
        
    }
    // 左子树的左子树和右子树的右子树
    // 左子树的右子树和右子树的左子树
    // 比较数值
    private boolean mirror(TreeNode left, TreeNode right){
        if(left == null)    return right==null;
        if(right == null)   return false;
        if(left.val != right.val)   return false;
        return mirror(left.right, right.left) && mirror(left.left, right.right);
    }
}