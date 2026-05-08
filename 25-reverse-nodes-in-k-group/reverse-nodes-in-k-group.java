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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode groupPrev=dummy;
        while(true){
            ListNode kth=getKth(groupPrev,k);
            if(kth==null){
                break;
            }
            ListNode groupNext=kth.next;

            ListNode prev=groupNext;
            ListNode curr=groupPrev.next;
            ListNode temp=null;
            while(curr!=groupNext){
                temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }

            temp=groupPrev.next;
            groupPrev.next=kth;
            groupPrev=temp;
        }

        return dummy.next;
    }
    
    ListNode getKth(ListNode curr,int k){
        while(curr!=null&&k>0){
            curr=curr.next;
            k-=1;
        }
        return curr;
    }
}
