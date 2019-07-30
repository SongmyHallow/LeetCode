/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * To represent a cycle in the given linked list, we use an 
 * integer pos which represents the position (0-indexed) in the 
 * linked list where tail connects to. If pos is -1, then there 
 * is no cycle in the linked list.
 * 
 * Note: Do not modify the linked list.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(slow != fast){
            if(slow.next!=null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            else{
                return null;
            }
        }
        fast = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}