package NO2_addTwoNumbers;

public class review {
	
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        //���� �Ǹ�
	    	//����ListNode
	    	ListNode l = new ListNode(0);
	    	ListNode p = null;
	    	p = l;
	    	//��λֻ������ 0 ���� 1
	    	int carry = 0;
	    	//current��ʾ��ǰ��һλ
	    	int current = 0;
	    	while(l1 != null && l2 != null){
	    		int temp = l1.val + l2.val + carry;
	    		carry = temp / 10;//��λ
	    		current = temp % 10;//��ǰ��λ
	    		p.next = new ListNode(current);
	    		l1 = l1.next;
	    		l2 = l2.next;
	    		p = p.next;//p ָ�����һ���ǿս��
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
