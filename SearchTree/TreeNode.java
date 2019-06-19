public class TreeNode{
  int val;
  public TreeNode right;
  public TreeNode left;
  
  public TreeNode(int x){
    this.val = x;
  }
  // 传入单个数，逐步构建BST，BST不能递归构建
  public void AddNode(int num){
    if(num < this.val){
      if(this.left != null){
        this.left.AddNode(num);
      }else{
        this.left = new TreeNode(num);
      }
      return;
    }
    if(this.right != null){
      this.right.AddNode(num);
    }else{
      this.right = new TreeNode(num);
    }
    return;
  }

  public void traversePreOrder(){
    System.out.println(this.val);
    if(this.left!=null) this.left.traversePreOrder();
    if(this.right!=null)  this.right.traversePreOrder();
  }
  // 中序遍历本身就是从小到大排列
  public void traverseInOrder(){
    if(this.left!=null) this.left.traverseInOrder();
    System.out.println(this.val);
    if(this.right!=null)  this.right.traverseInOrder();
  }

  public void traversePostOrder(){
    if(this.left!=null) this.left.traversePostOrder();
    if(this.right!=null)  this.right.traversePostOrder();
    System.out.println(this.val);
  }
}