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
    public ListNode mergeNodes(ListNode head) {
        ListNode node =new ListNode(-1);
        ListNode ansHead=node;
        ListNode curr=head;
        while(curr!=null){
            int sum=0;
            while(curr!=null && curr.val!=0){
                sum=(sum+curr.val);
                curr=curr.next;
            }
            if(sum!=0)
            {node.next=new ListNode(sum);
            node=node.next;}
            curr=curr.next;
        }
        return ansHead.next;
    }
}