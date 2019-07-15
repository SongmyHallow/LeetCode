public class Solution{
  public ListNode deleteDuplication(ListNode pHead){
    if(pHead == null) return null;
    // To avoid the case that first two elements are same
    ListNode realHead = new ListNode(0);
    realHead.next = pHead;
    ListNode pre = realHead, cur = pHead;
    
    while(cur != null){
      // encounter same elements
      if(cur.next!=null && cur.val == cur.next.val){
        // find the next different element
        while(cur.next!=null && cur.val ==cur.next.val){
          cur = cur.next;
        }
        pre.next = cur.next;
        cur = cur.next;
      }
      else{
        pre = pre.next;
        cur = cur.next;
      }
    }
    return realHead.next;
  }
}