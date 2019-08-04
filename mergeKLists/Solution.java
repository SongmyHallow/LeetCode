/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Merge k sorted linked lists and return it as one sorted 
 * list. Analyze and describe its complexity.
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode ans = null;
        for(int i=0; i<lists.length; i++){
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode fake = new ListNode(0);
        ListNode p1 = l1, p2 = l2;
        ListNode curr = fake;
        while(p1!=null && p2!=null){
            if(p1.val <= p2.val){
                curr.next = p1;
                curr = curr.next;
                p1 = p1.next;
            }
            else{
                curr.next = p2;
                curr = curr.next;
                p2 = p2.next;
            }
        }

        if(p1!=null){
            while(p1!=null){
                curr.next = p1;
                curr = curr.next;
                p1 = p1.next;
            }
        }
        else{
            while(p2!=null){
                curr.next = p2;
                curr = curr.next;
                p2 = p2.next;
            }
        }

        return fake.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
}