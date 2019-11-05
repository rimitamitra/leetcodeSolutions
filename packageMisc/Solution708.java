/*

Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.

// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        
        if(head==null){
            Node n = new Node(insertVal, null);
            n.next = n;
            return n;
        }
        
        Node curr = head;
        
        while(true){
            
            if(curr.val < curr.next.val){
                if(curr.val<=insertVal && insertVal<= curr.next.val){
                    curr.next = new Node(insertVal, curr.next);
                    break;
                }
            }else if(curr.val > curr.next.val){
                if(insertVal>=curr.val || insertVal<=curr.next.val){
                    curr.next = new Node(insertVal, curr.next);
                    break;
                }
            }else{
                if(curr.next == head){
                    curr.next = new Node(insertVal, curr.next);
                    break;
                }
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}