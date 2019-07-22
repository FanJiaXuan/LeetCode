package NO2_addTwoNumbers;

public class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2){
			//ģ��ӷ�  �����˼·
			ListNode dummy = new ListNode(0);
			int carry = 0;//carry ����0 ���� 1
			ListNode cur = dummy;
			while(l1 != null || l2 != null){//ֻҪ��һ����Ϊ��
				int x = (l1 == null) ? 0 : l1.val;
				int y = (l2 == null) ? 0 : l2.val;
				int temp = x + y + carry;//���19
				carry = temp / 10;//��λҲ��������
				cur.next = new ListNode(temp % 10);//��һλ��������
				cur = cur.next;
				if(l1 != null) l1 = l1.next;
				if(l2 != null) l2 = l2.next;
			}
			if(carry == 1)
				cur.next = new ListNode(carry);
			return dummy.next;
		}
}
