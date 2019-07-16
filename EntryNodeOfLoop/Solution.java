package EntryNodeOfLoop;

public class Solution{
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null || pHead.next==null || pHead.next.next==null) return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        // 判断是否有环
        while(fast != slow){
            if(fast.next != null && fast.next.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
            else{
                return null;
            }
        }
        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}