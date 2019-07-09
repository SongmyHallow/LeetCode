package FindFirstCommonNode;

public class Solution{
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        ListNode commonNode = new ListNode(0);
        if(pHead1==null || pHead2==null)    return commonNode;

        int flag = 0;
        while(true){
            if(pHead1.equals(pHead2)==true){
                commonNode = pHead1;
                return commonNode;
            }else{
                if(pHead1.next==null || pHead2.next==null)  break;
                if(flag==0){
                    pHead1 = pHead1.next;
                    flag = 1;
                }else{
                    pHead2 = pHead2.next;
                    flag = 0;
                }
            }
        }
        return commonNode;
    }
}