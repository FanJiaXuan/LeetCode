package twoSum;

public class polishedCode {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode pointer1 = l1, pointer2 = l2, pointer = dummyHead;
		int carry = 0;
		while(pointer1 != null || pointer2 != null){
			int s1 = (pointer1 != null) ? pointer1.val : 0;
			int s2 = (pointer2 != null) ? pointer2.val : 0;
			int sum = carry + s1 + s2;
			carry = sum / 10;
			pointer.next = new ListNode(sum % 10);
			pointer = pointer.next;
			if(pointer1 != null)
				pointer1 = pointer1.next;
			if(pointer2 != null)
				pointer2 = pointer2.next;
		}
		if(carry != 0)
			pointer.next = new ListNode(carry);
		return dummyHead.next;
	}
}
