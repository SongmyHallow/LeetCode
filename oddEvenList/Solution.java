/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Given a singly linked list, group all odd nodes together 
 * followed by the even nodes. Please note here we are talking 
 * about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in 
 * O(1) space complexity and O(nodes) time complexity.
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)   return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode head_even = even;
        
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = head_even;
        return head;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
}