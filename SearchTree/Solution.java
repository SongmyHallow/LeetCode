// 二叉搜索树转排序双向链表
public class Solution{
  TreeNode head = null;
  TreeNode realHead = null;

  public TreeNode Convert(TreeNode pRootOfTree){
    ConvertHelper(pRootOfTree);
    return realHead;
  }
  
  public void ConvertHelper(TreeNode pRootOfTree){
    if(pRootOfTree==null) return;
    ConvertHelper(pRootOfTree.left);
    if(head==null){
      head = pRootOfTree;
      realHead = pRootOfTree;
    }
    else{
      head.right = pRootOfTree;
      pRootOfTree.left = head;
      head = pRootOfTree;
    }
    ConvertHelper(pRootOfTree.right);
  }
}