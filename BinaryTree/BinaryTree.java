import java.util.ArrayDeque;

public class BinaryTree{
  static class TreeNode{
    int value;
    TreeNode right;
    TreeNode left;

    public TreeNode(int value){
      this.value = value;
    }
  }
  TreeNode root;
  // 构造方法
  public BinaryTree(int[] arr){
    root = makeBinaryTreeByArray(arr,1);
  }
  
  // 递归创建二叉树，构造后是二叉树的二叉链表表示法
  // 剔除值为0的元素
  public static TreeNode makeBinaryTreeByArray(int[] arr, int index){
    if(index < arr.length){
      int value = arr[index];
      if(value!=0){
        TreeNode t = new TreeNode(value);
        arr[index] = 0;
        t.left = makeBinaryTreeByArray(arr, index*2);
        t.right = makeBinaryTreeByArray(arr, index*2+1);
        return t;
      }
    }
    return null;
  }

  // DFS 深度优先非递归实现
  public void depthOrderTraversal(){
    if(root==null){
      System.out.println("Empty tree\n");
      return;
    }
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while(stack.isEmpty() == false){
      TreeNode node = stack.pop();
      System.out.println(node.value + " ");
      if(node.right!=null){
        stack.push(node.right);
      }
      if(node.left!=null){
        stack.push(node.left);
      }
    }
    System.out.println('\n');
  }

  // BFS 广度优先非递归实现
  public void levelOrderTraversal(){
    if(root==null){
      System.out.println("Empty tree\n");
      return;
    }
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while(queue.isEmpty() == false){
      TreeNode node = queue.remove();
      System.out.println(node.value + " ");
      if(node.right!=null){
        queue.add(node.right);
      }
      if(node.left!=null){
        queue.add(node.left);
      }
    }
    System.out.println("\n");
  }

}