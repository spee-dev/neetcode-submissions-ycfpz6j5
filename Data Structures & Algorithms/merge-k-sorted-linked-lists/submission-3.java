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

public class Solution {    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        while(lists.length>1){
            List<ListNode>mergedList=new ArrayList<>();
            for(int i=0;i<lists.length;i+=2){
                ListNode l1=lists[i];
                ListNode l2=i+1<lists.length?lists[i+1]:null;
                mergedList.add(merge(l1,l2));
            }
            lists=mergedList.toArray(new ListNode[0]);
        }
        return lists[0];
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
                curr=curr.next;

            }
            else{
                curr.next=l2;
                l2=l2.next;
                curr=curr.next;
            }
        }
        if(l1!=null){
            curr.next=l1;curr=curr.next;}

        if(l2!=null){
            curr.next=l2;
            curr=curr.next;
        }
        return dummy .next;
    }
}
