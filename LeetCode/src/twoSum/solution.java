package twoSum;

//用单链表  逆序表示两个非负整数
//相加
//返回新的逆序单链表
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。



public class solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pointer1 = l1;
		ListNode pointer2 = l2;
		ListNode res = new ListNode(0);
		ListNode pointer3 = new ListNode(0);
		Boolean first = true;
		int exceed = 0;
		
		while((pointer1 != null) && (pointer2 != null)){
			
			int temp = (pointer1.val + pointer2.val + exceed) % 10;
			//System.out.println("temp:" + temp);
			exceed = (pointer1.val + pointer2.val + exceed) / 10;
			if(first){
				first = false;
				res = new ListNode(temp);
				pointer3 = res;
			}else{
				pointer3.next = new ListNode(temp);
				pointer3 = pointer3.next;
			}
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
			
//			ListNode pointer = res;
//			while(pointer != null){
//				System.out.print("++"+pointer.val + "++");
//				pointer = pointer.next;
//			}
		}
		
		if(pointer1 == null && pointer2 == null && exceed != 0)
			pointer3.next = new ListNode(exceed);
		
		while(pointer1 != null){
			int temp = (pointer1.val + exceed) % 10;
			exceed = (pointer1.val + exceed) / 10;
			pointer3 = new ListNode(temp);
			pointer1 = pointer1.next;
			pointer3 = pointer3.next;
		}
		
		while(pointer2 != null){
			int temp = (pointer2.val + exceed) % 10;
			exceed = (pointer2.val + exceed) / 10;
			pointer3 = new ListNode(temp);
			pointer2 = pointer2.next;
			pointer3 = pointer3.next;
		}
		
		//System.out.println( "@" +res.val + "@");
		
		
		return res;
    }
}
