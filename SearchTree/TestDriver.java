public class TestDriver {

  public static void main(String[] args) {
      TreeNode sol = new TreeNode(10);
      int[] numlst = {20, 15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
      for(int i=0; i<numlst.length;i++){
        sol.AddNode(numlst[i]);
      }
      // sol.traverseInOrder();
      Solution test = new Solution();
      TreeNode head = test.Convert(sol);
      while(head!=null){
        System.out.println(head.val);
        head = head.right;
      }
  }

}