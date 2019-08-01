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
      
      return head;
  }
  public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
      val = x;
    }
  }
}