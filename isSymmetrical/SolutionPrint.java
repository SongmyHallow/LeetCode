package isSymmetrical;

import java.util.ArrayList;
import java.util.Stack;

public class SolutionPrint{
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        if(pRoot==null) return sol;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int level = 1;
        stack1.push(pRoot);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            if(level++%2 != 0){
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if(node.left!=null) stack2.push(node.left);
                    if(node.right!=null) stack2.push(node.right);
                }
            }
            else{
                while(!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if(node.right!=null) stack1.push(node.right);
                    if(node.left!=null) stack1.push(node.left);
                }
            }
            sol.add(list);
        }
        return sol;
    }
}