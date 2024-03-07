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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList=new ListNode();
        ListNode curr1=list1;
        ListNode curr2=list2;
        ListNode temp=mergedList;
        while(curr1!=null && curr2!=null){
            if(curr1.val<curr2.val){
                temp.next=curr1;
                temp=temp.next;
                curr1=curr1.next;
            } else {
                temp.next=curr2;
                temp=temp.next;
                curr2=curr2.next;
            }
        }
        while(curr1!=null){
            temp.next=curr1;
                temp=temp.next;
                curr1=curr1.next;
        }
        while(curr2!=null){
            temp.next=curr2;
                temp=temp.next;
                curr2=curr2.next;
        }
        return mergedList.next;
    }
}