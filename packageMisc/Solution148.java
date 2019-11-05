/**
*   Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

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
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next ==null)
            return head;
        
        int len = 0;
        ListNode res = new ListNode(-1);
        res.next = head;
        while(head !=null){
            head = head.next;
            len++;
        }
            
        for(int grp=1; grp<len; grp <<=1){
            ListNode prev = res;
            ListNode curr = res.next;
            while(curr!=null){
                ListNode left = curr;
                ListNode right = split(left, grp);
                curr = split(right, grp);
                prev = merge(left, right, prev);
            }
        }
        
        return res.next;
    }
    
    private ListNode split(ListNode head, int step){
        
        if(head==null)
            return head;
        
        for(int i=1; i<step && head.next != null; i++)
            head = head.next;
        
        ListNode temp = head.next;
        head.next = null;
        return temp;
    }
    
    private ListNode merge(ListNode left, ListNode right, ListNode root){
        
        ListNode curr = root;
        while(left!=null && right!=null){
            if(left.val<right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        
        if(left!=null)
            curr.next = left;
        else
            curr.next = right;
        
        while(curr.next != null)
            curr = curr.next;
        
        return curr;
    }
}