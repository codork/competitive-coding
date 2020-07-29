package AddTwoNumbers;

// 08/07/2020

/* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
-------------------------------------------------------------
    * Definition for singly-linked list.
    */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

	// Set value of head node of result LL
        ListNode head = new ListNode();
        head.val = l1.val + l2.val + carry;
        if(head.val > 9) {	//if value exceeds 9, set carry
            carry = 1;
            head.val = head.val - 10;
        }
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
	// prev keeps track of result LL
        ListNode prev = head;
        
        while(ptr1 != null && ptr2 != null) {
            ListNode curr = new ListNode();
            curr.val = ptr1.val + ptr2.val + carry;
            if(curr.val > 9) {
                carry = 1;
                curr.val = curr.val - 10;
            }
            else {
                carry = 0;
            }
            prev.next = curr;
            prev = prev.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
	// If either LL is over...
        while(ptr1 != null) {
            ListNode curr = new ListNode();
            curr.val = ptr1.val + carry;
            if(curr.val > 9) {
                carry = 1;
                curr.val = curr.val - 10;
            }
            else {
                carry = 0;
            }
            prev.next = curr;
            prev = prev.next;
            ptr1 = ptr1.next;
        }
        
        while(ptr2 != null) {
            ListNode curr = new ListNode();
            curr.val = ptr2.val + carry;
            if(curr.val > 9) {
                carry = 1;
                curr.val = curr.val - 10;
            }
            else {
                carry = 0;
            }
            prev.next = curr;
            prev = prev.next;
            ptr2 = ptr2.next;
        }
        
	// If both LLs are over but carry is still set
        if(ptr1==null && ptr2==null && carry!=0) {
            ListNode curr = new ListNode(carry);
            prev.next = curr;
        }
        return head;
    }
}