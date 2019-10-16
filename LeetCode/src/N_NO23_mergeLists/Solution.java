package N_NO23_mergeLists;



public class Solution {
	public ListNode merge2(ListNode l1, ListNode l2){
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
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0 ) 
			return null;
		if(lists.length == 1 ) 
			return lists[0];
		ListNode l3 = merge2(lists[0], lists[1]);
		for(int i = 2; i < lists.length; i++){
			l3 = merge2(l3, lists[i]);
		}
		return l3;
    }
}
