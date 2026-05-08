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
    public void reorderList(ListNode head) {
        if(head.next==null)return;

        Stack<ListNode> st=new Stack<>();
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode end=slow;

        while(slow!=null){
            st.push(slow);
            slow=slow.next;
        }

        ListNode temp=head;
        ListNode next=null;
        while(temp!=end){
            next=temp.next;
            temp.next=st.pop();
            temp=temp.next;
            temp.next=next;
            temp=temp.next;
        }
        end.next=null;
    }
}
