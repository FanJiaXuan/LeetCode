package weekly156;

import java.util.Stack;

public class _5206_xiaoxiaole {
	 public String removeDuplicates(String s, int k) {
		 //�õ���ջ��֪ʶ
		 char[] st = s.toCharArray();
		 Stack<Integer[]> stack = new Stack<>();
		 for(char a : st){
			 if(!stack.empty() && stack.peek()[0] == a - 'a'){//ջ ���� �� �����������һ����ͬ
				  stack.push(new Integer[]{stack.peek()[0], stack.peek()[1] + 1}); 
			 }else{
				 stack.push(new Integer[]{a - 'a', 1});
			 }
			 if(stack.peek()[1] == k){
				 for(int i = 0; i < k; i++)
					 stack.pop();
			 }
		 }
		 StringBuffer ans = new StringBuffer();
		 while(!stack.empty()){
			 ans.append((char)(stack.pop()[0] + 'a'));
			// stack.pop();
		 }
		 return ans.reverse().toString();
	 }
}
