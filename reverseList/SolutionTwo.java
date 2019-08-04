// Reverse a linked list from position m to n. Do it in one-pass.
public class SolutionTwo{
    /**
     * We can simply use these two pointers to reverse the link between A and B
     * But once we do this, we have no access to node C
     * That's why we need a third pointer that will help us continue the link reversal process
     * 
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)   return head;
        // Move the two pointers until they reach the proper starting point
        ListNode prev = null;
        ListNode curr = head;
        while(m>1){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections
        ListNode con = prev, tail = curr;
        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while(n>0){
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if(con!=null)   con.next = prev;
        else            head = prev;

        tail.next = curr;
        return head;

    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
}