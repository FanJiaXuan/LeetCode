package twoSum;

public class test {
	public static void main(String[] args) {
		polishedCode s = new polishedCode();
		ListNode l1, l2, pointer;
		l1 = new ListNode(2);//243, 564
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		l2 = new ListNode(5);//243, 564
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		//System.out.println(l1);
		pointer = s.addTwoNumbers(l1, l2);
		
		System.out.println("´ð°¸£º");
		while(pointer != null){
			System.out.print(pointer.val);
			pointer = pointer.next;
		}
		
		
		//System.out.println(s.addTwoNumbers(l1, l2));
	}
}
