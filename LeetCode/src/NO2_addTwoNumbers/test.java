package NO2_addTwoNumbers;

public class test {
		public static void main(String[] args) {
			
//			Solution s = new Solution();
//			s.addTwoNumbers(l1, l2);
			ListNode l1 = new ListNode(2);
			l1.next = new ListNode(4);
			l1.next.next = new ListNode(3);
			
			ListNode l2 = new ListNode(5);
			l2.next = new ListNode(6);
			l2.next.next = new ListNode(4);
			
			review r = new review();
			System.out.println(r.addTwoNumbers(l1, l2));
			
		}
}
