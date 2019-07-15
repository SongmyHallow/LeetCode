package isSymmetrical;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionPrintLines{
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        if(pRoot == null)   return sol;

        Queue<TreeNode> layer = new LinkedList<>();
        ArrayList<Integer> layerlist = new ArrayList<>();
        layer.add(pRoot);
        int start = 0, end = 1;

        while(!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerlist.add(cur.val);
            start++;
            if(cur.left!=null)  layer.add(cur.left);
            if(cur.right!=null) layer.add(cur.right);
            // use end to record the number of points in each layer
            if(start==end){
                end = layer.size();
                start = 0;
                sol.add(layerlist);
                layerlist = new ArrayList<Integer>();
            }
        }
        return sol;
    }
}