import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * Hard
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergekSortedLists {
    // time O(nlogk) space O(n)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        return sort(lists,0,lists.length-1);
    }
    public ListNode sort(ListNode[] lists,int start,int end){
        if(start>=end) return lists[start];
        int mid=(end-start)/2+start;
        ListNode l1=sort(lists,start,mid);
        ListNode l2=sort(lists,mid+1,end);
        return merge(l1,l2);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }
        l2.next=merge(l1,l2.next);
        return l2;
    }



}
