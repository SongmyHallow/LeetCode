public class SolutionSerialize{
    // String object is unmutable, so we use Stringbuilder here
    String Serialize(TreeNode root){
        StringBuilder str = new StringBuilder();
        PreOrder(root, str);
        return str.toString();
    }

    private void PreOrder(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("#,");
            return;
        }

        str.append(root.val+",");
        PreOrder(root.left, str);
        PreOrder(root.right, str);
    }

    TreeNode Deserialize(String str){
        if(str.length()<1 || str==null) return null;
        String[] strs = str.split(",");
        TreeNode root = DePreOrder(strs);
        return root;
    }
    // 每次递归时能够用不同的字符串来建立根结点
    int index = 0;
    private TreeNode DePreOrder(String[] strs){
        // blank node
        // index始终都要向后移动，用来追踪String数组里的元素
        if("#".equals(strs[index])){
            index++;
            return null;
        }
        else{
            TreeNode node = new TreeNode(0);
            node.val = Integer.parseInt(strs[index]);
            index++;
            node.left = DePreOrder(strs);
            node.right = DePreOrder(strs);
            return  node;
        }

    }

}