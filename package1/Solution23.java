/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            
            public int compare(ListNode n1, ListNode n2){
                if(n1.val<n2.val)
                    return -1;
                else if(n1.val>n2.val)
                    return 1;
                else
                    return 0;
            }
        });
        
        ListNode res = new ListNode(-1);
        ListNode pointer = res;
        
        for(ListNode n: lists){
            if(n!=null)
                pq.add(n);
        }
            
        
        while(!pq.isEmpty()){
            pointer.next = pq.poll();
            pointer = pointer.next;
            
            if(pointer.next != null)
                pq.add(pointer.next);
        }
        
        return res.next;
    }
}