package N_NO21_mergeTwoLists;

public class Solution {
	   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		   ListNode l3 = new ListNode(0);
		   ListNode pointer = l3;
		   while(l1 != null && l2 != null){
			   if(l1.val <= l2.val){
				  pointer.next = new ListNode(l1.val);
				  pointer = pointer.next;//pointer 时刻指向最后的null
				  l1 = l1.next;
			   }else{
				   pointer.next = new ListNode(l2.val);
				   pointer = pointer.next;//pointer 时刻指向最后的null
				   l2 = l2.next;
			   }   
		   }
		   while(l1 != null){
			   pointer.next = new ListNode(l1.val);
			   pointer = pointer.next;//pointer 时刻指向最后的null
			   l1 = l1.next;
		   }
		   while(l2 != null){
			   pointer.next  = new ListNode(l2.val);
			   pointer = pointer.next;//pointer 时刻指向最后的null
			   l2 = l2.next;
		   }
		   return l3.next;
	   }
}
