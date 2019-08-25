package NO2_addTwoNumbers;

public class review {
	
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        //逆序 非负
	    	//返回ListNode
	    	ListNode l = new ListNode(0);
	    	ListNode p = null;
	    	p = l;
	    	//进位只可能是 0 或者 1
	    	int carry = 0;
	    	//current表示当前这一位
	    	int current = 0;
	    	while(l1 != null && l2 != null){
	    		int temp = l1.val + l2.val + carry;
	    		carry = temp / 10;//进位
	    		current = temp % 10;//当前这位
	    		p.next = new ListNode(current);
	    		l1 = l1.next;
	    		l2 = l2.next;
	    		p = p.next;//p 指向最后一个非空结点
	    	}
	    	while(l1 != null){
	    		int temp = l1.val + carry;
	    		carry = temp / 10;
	    		current = temp % 10;
	    		p.next = new ListNode(current);
	    		l1 = l1.next;
	    		p = p.next;
	    	}
	    	while(l2 != null){
	    		int temp = l2.val + carry;
	    		carry = temp / 10;
	    		current = temp % 10;
	    		p.next = new ListNode(current);
	    		l2 = l2.next;
	    		p = p.next;
	    	}
	    	if(carry != 0)
	    		p.next = new ListNode(carry);
	    	return l.next;
	    }
	
}
