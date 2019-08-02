/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 */
public class SolutionTwo {
  public ListNode deleteDuplicates(ListNode head) {
      if(head==null)  return null;
      ListNode fakeHead = new ListNode(0);
      fakeHead.next = head;
      ListNode pre = fakeHead;
      ListNode cur = head;
      
      while(cur!=null){
        // skip duplicates
        while(cur.next!=null && cur.val==cur.next.val){
          cur = cur.next;
        }
        if(pre.next==cur) pre = pre.next;       // not skip
        else              pre.next = cur.next;  // skipped
        cur = cur.next;
      }
      return fakeHead.next;
  }
  public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
      val = x;
    }
  }
}