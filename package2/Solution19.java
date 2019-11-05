/**
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
    if(head.next == null){
        return null;
    }  
    
    ListNode res = new ListNode(-1);
    res.next = head;    
    ListNode forward = res;
    ListNode pointer = res;

    int idx=0;
    while(idx<n && forward.next !=null){
        forward = forward.next;
        idx++;
    }

    while(forward.next!=null){
        forward = forward.next;
        pointer = pointer.next;
    }

    pointer.next = pointer.next.next;

    return res.next;
    }
}