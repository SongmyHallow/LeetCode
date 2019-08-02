/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Given a linked list and a value x, partition it such that all 
 * nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes 
 * in each of the two partitions.
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode pless = less;
        ListNode more = new ListNode(0);
        ListNode pmore = more;
        while(head!=null){
            if(head.val < x){
                pless.next = head;
                pless = pless.next;
            }
            else{
                pmore.next = head;
                pmore = pmore.next;
            }

            head = head.next;
        }
        pmore.next = null;
        pless.next = more.next;
        return less.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
}