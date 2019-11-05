/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null) {
          return head;
        }
        
        int len = 1;
        ListNode ptr = head;
        while(ptr.next!=null){
            len++;
            ptr = ptr.next;
        }
        ptr.next = head;
        
        int moves = k%len;
        if (moves == 0) {
          ptr.next = null;
          return head; 
        }
        
        for(int i=0;i<len - moves -1;i++)
            head = head.next;
        
        ListNode newHead = head.next;
        head.next = null;
        
        return newHead;
    }
}