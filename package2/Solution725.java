/*Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        
        int len = 0;
        ListNode ptr = root;
        while(ptr!=null){
            len++;
            ptr = ptr.next;
        }
        
        int elements = len/k;
        int remainder = len%k;
        ListNode[] res = new ListNode[k];
        int step = 0;
        ListNode prev = new ListNode(-1);
        prev.next = root;
        
        while(step<k){
            int counter = step<remainder? elements+1 : elements;
            res[step] = root;
            for(int i=0; i<counter && root!=null; i++){
                prev = root;
                root = root.next;
            }
            prev.next = null;
            step++;
        }
        
        return res;
    }
}