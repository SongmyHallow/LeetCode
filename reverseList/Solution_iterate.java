/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_iterate {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            // you must store its previous element beforehand
            ListNode nextTemp = curr.next;
            curr.next = prev;
            //need another pointer to store the next node before changing the reference
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
}