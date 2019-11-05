/**
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode curr = head;
        ListNode ahead = head;
        boolean loop = false;
        
        while(curr!=null && ahead != null && ahead.next != null){
            curr = curr.next;
            ahead = ahead.next.next;
            
            if(curr == ahead){
                loop = true;
                break;
            } 
        }
        
        ahead = head;
        if(loop){
            while(ahead != curr){
                ahead = ahead.next;
                curr = curr.next;
            }
            return curr; 
        }
        
        return null;
    }
}