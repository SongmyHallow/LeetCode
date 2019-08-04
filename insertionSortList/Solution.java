/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Sort a linked list using insertion sort.
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)  return null;
        
        ListNode cur = head;                // the node will be inserted
        ListNode fake = new ListNode(0);    // new starter of the sorted list
        ListNode prev = fake;               // insert node between prev and prev.next
        ListNode next = null;               // the next node will be inserted

        while(cur!=null){
            next = cur.next;
            // find the right place to insert
            while(prev.next!=null && prev.next.val<cur.val){
                prev = prev.next;
            }
            // Insert between prev and prev.net
            cur.next = prev.next;
            prev.next = cur;
            // reset
            prev = fake;
            // move to the next element
            cur = next;
        }
        return fake.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
}