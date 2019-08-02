/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Given a linked list, remove the n-th node from the 
 * end of list and return its head.
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)    return head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode cur = fake;
        ListNode pre = fake;
        int count = 0;
        while(cur!=null){
            if(count<=n){
                cur = cur.next;
                count++;
            }
            else{
                cur = cur.next;
                pre = pre.next;
            }
        }
        pre.next = pre.next.next;
        return fake.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}