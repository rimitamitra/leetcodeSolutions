/*
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
Input: [1,2,3]
Output: [1,2,4]

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
    public ListNode plusOne(ListNode head) {
        
        ListNode res = new ListNode(-1);
        ListNode curr = reverse(head);
        res.next = curr;
        ListNode prev = res;
        int carry = 0;
        
        while(curr!=null){
            int sum = carry+curr.val;
            carry = sum/10;
            curr.val = sum%10;
            curr = curr.next;
            prev = prev.next;
        }
        
        if(carry!=0){
            prev.next = new ListNode(carry);
        }
        
        return reverse(res.next);
        
    }
    
    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}