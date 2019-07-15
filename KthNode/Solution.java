import java.util.Stack;

public class Solution{
  TreeNode KthNode(TreeNode pRoot, int k){
    if(pRoot==null || k==0){
      return null;
    }
    Stack<TreeNode> stack = new Stack<>();
    int counter = 0;
    TreeNode node = pRoot;
    do{
      if(node!=null){
        stack.push(node);
        node = node.left;
      }
      else{
        node = stack.pop();
        counter++;
        if(counter==k){
          return node;
        }
        node = node.right;
      }
    }while(node!=null || !stack.isEmpty());
    return null;
  }

// Take advantage of the InOrder output is from bottom to top
  int k;
  TreeNode KthNodeTwo(TreeNode pRoot, int k){
    this.k = k;
    return InOrder(pRoot);
  }
 
  private TreeNode InOrder(TreeNode pRoot) {
        TreeNode temp = null;
        if (pRoot != null) {
            if ((temp = InOrder(pRoot.left)) != null) return temp;
            if (--k == 0) return pRoot;
            if ((temp = InOrder(pRoot.right)) != null) return temp;
        }
        return null;
    }
}