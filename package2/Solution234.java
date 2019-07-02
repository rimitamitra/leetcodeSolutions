/**

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
**/

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)
            return true;
         
        ListNode mid = getMiddle(head);
        ListNode secondHead = reverse(mid.next);
        
        while(head != null && secondHead != null){
            if(head.val != secondHead.val)
                return false;
            
            head = head.next;
            secondHead = secondHead.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode root){
        ListNode prev = null;
        ListNode curr = root;
        
        while(curr != null){
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        
        return prev;
    }
    
    public ListNode getMiddle(ListNode root){
        ListNode slow = root;
        ListNode fast = root;
        
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}