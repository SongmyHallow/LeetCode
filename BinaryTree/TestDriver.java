import BinaryTree.TreeNode;

public class TestDriver{
  public static void main(String[] args){
    int[] test = {0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
    BinaryTree head = new BinaryTree(test);
    head.depthOrderTraversal();
    head.levelOrderTraversal();
  }
}