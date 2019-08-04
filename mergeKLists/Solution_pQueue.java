import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_pQueue{
    public ListNode mergeKLists(List<ListNode> lists){
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(),new Comparator<T>() {
            @Override
            public int compare(ListNode l1, ListNode l2){
                // less -> negative
                if(l1.val < l2.val)         return -1;
                // equal -> zero
                else if(l1.val == l2.val)   return 0;
                // greater -> positive
                else                        return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node:lists)
            if(node!=null)
                queue.add(node);
        
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;

            if(tail.next!=null)
                queue.add(tail.next);
        }

        return dummy.next;
    }


    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
}