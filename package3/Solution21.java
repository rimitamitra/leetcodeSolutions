/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        
        if(h1==null || h2==null)
            return h1==null?h2:h1;
        
        ListNode res = new ListNode(-1);
        ListNode head = res;
        
        while(h1!=null && h2!=null){
            if(h1.val<=h2.val){
                res.next = h1;
                h1 = h1.next;
            }else{
                res.next = h2;
                h2 = h2.next;
            }
            res = res.next;
        }
        
        if(h1!=null){
            res.next = h1;
        }else{
            res.next = h2;
        }
        
        return head.next;
        
    }
}