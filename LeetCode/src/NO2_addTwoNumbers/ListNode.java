package NO2_addTwoNumbers;

public class ListNode {
	
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}

 @Override
public String toString() {
// TODO Auto-generated method stub
	 ListNode p = this;
	 while(p != null){
		 System.out.println(p.val);
		 p = p.next;
	 }
	 return "ok";
}
}
