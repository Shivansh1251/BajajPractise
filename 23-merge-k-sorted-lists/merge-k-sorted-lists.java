/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode l:lists){
            if(l!=null){
                pq.offer(l);
            }
        }

        ListNode dummy=new ListNode();
        ListNode temp=dummy;

        while(!pq.isEmpty()){
            ListNode curr=pq.poll();

            temp.next=curr;
            temp=temp.next;

            if(curr.next!=null){
                pq.offer(curr.next);
            }
        }

        return dummy.next;
    }
}