public class Solution{
    public int TreeDepth(TreeNode root){
        int depth = 0;
        if(root != null){
            int leftDepth = TreeDepth(root.left);
            int rightDepth = TreeDepth(root.right);
            depth = leftDepth > rightDepth ? leftDepth+1 : rightDepth + 1;
        }
        return depth;
    }
}