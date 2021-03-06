/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode prev = dummy;
        prev.next = head;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            if (next != null) {
                if (current.val == next.val) {
                    while (next != null && current.val == next.val) {
                        next = next.next;
                    }
                    prev.next = next;
                } else {
                    prev = current;
                }
            }
            current = next;
        }
        return dummy.next;
    }
}
 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        boolean duplicate = false;
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
        	while (current.next != null && current.next.val == current.val) {
        		duplicate = true;
        		current.next = current.next.next;        		
        	}
        	if (duplicate) {
        		prev.next = current.next;
        		duplicate = false;
        	} else {
        		prev = current;
        	}
        	current = prev.next;
        }
        
        return dummy.next;
    }
}
