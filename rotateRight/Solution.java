/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Given a linked list, rotate the list to the right by k places, 
 * where k is non-negative.
 */
class Solution {
    /**
     * 1. get the length
     * 2. move to the (i - n%i)th node
     * 3. do the rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)   return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        // get the total length
        for(i=0;fast.next!=null;i++)
            fast = fast.next;
        // get the the (i - n%i)th node
        for(int j=i-k%i; j>0; j--)
            slow = slow.next;
        // beaware of the order of operation
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
}