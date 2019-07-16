import solution.TreeNode;

public class SolutionSerialize{
    String Serialize(TreeNode root){
        StringBuilder str = new StringBuilder();
        PreOrder(root, str);
        return str.toString();
    }

    private void PreOrder(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("#!");
            return;
        }

        str.append(root.value+"#");
        PreOrder(root.left, str);
        PreOrder(root.right, str);
    }

    TreeNode Deserialize(String str){
        
    }

}