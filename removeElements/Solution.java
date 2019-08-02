/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Remove all elements from a linked list of integers that have value val.
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)    return null;
        ListNode cur = head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;

        while(cur != null && cur.next!=null){
            if(cur.val == val){
                pre.next = cur.next;
            }
            else{
                pre = pre.next;
            }
            cur = cur.next;
        }
        if(cur.val == val)  pre.next = null;
        return fake.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val=x; }
    }
}