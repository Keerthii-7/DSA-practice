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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int partSize = len / k;
        int remainder = len % k;

        ListNode[] ans = new ListNode[k];
        curr = head;
        
        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(0); 
            ListNode temp = dummy;
            int currentPartSize = partSize + (remainder > 0 ? 1 : 0);
            remainder--;  

            for (int j = 0; j < currentPartSize; j++) {
                temp.next = curr;
                if (curr != null) curr = curr.next;
                temp = temp.next;
            }
            
            if (temp != null) temp.next = null;  

            ans[i] = dummy.next;
        }
        
        return ans;
    }
}