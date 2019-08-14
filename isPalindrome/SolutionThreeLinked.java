// Given a singly linked list, determine if it is a palindrome.

public class SolutionThreeLinked{
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return false;
        if(head.next==null)
            return true;

        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // odd nodes: let right half smaller
        if(fast!=null)
            slow = slow.next;

        slow = reverse(slow);
        fast = head;

        while(slow != null){
            if(fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;

    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}