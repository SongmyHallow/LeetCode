public class IsBalanced{
    public boolean solution(TreeNode root){
        if(root==null)  return true;
        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <=1 && solution(root.left) && solution(root.right);
    }

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