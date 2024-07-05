/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static int first=-1,minDis=Integer.MAX_VALUE,last=-1,prevIndex=-1;;
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        first = -1;
        minDis = Integer.MAX_VALUE;
        last = -1;
        prevIndex = -1;

        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        helperFun(head);
        if (minDis == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{minDis, last - first};
    }
    public static void helperFun(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        int i=0;
        while(curr!=null && curr.next!=null){
            i++;
            ListNode next=curr.next;
            if(prev!=null && curr!=null){
                if((curr.val>prev.val && curr.val>next.val) || (curr.val<prev.val && curr.val<next.val)){
                    if(first==-1){
                        first=i;
                    }
                    prevIndex=last;
                    last=i;
                    if(first!=last && prevIndex!=-1)
                        minDis=Math.min(minDis,last-prevIndex);
                }
            }
            prev=curr;
            curr=next;
        }
    }
}