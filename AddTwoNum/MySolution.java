package AddTwoNum;

public class MySolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        int carry = 0;
        ListNode p = l1;
        ListNode q = l2;
        ListNode cur = head;
        while(p!=null || q!=null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x+y+carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum%10);
            cur.next = node;
            cur = cur.next;
            if(p!=null)    p = p.next;
            if(q!=null)    q = q.next;
        }
        if(carry==1){
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}
