package N_NO20_valid90;

import java.util.Stack;

public class Solution {
	public boolean isValid(String s){
		Stack<Character> st = new Stack<>();
		char[] arr = s.toCharArray();
		
		if(arr.length == 0)
			return true;
		
		if(arr[0] != '[' && arr[0] != '(' && arr[0] != '{')
			return false;
		
		for(char a : arr){

		
			//不空 且 互补 则 就应该出栈了
			
				if(a == ')' && !st.empty() && st.peek() == '('){
					//System.out.println("if:" + a);
					
						
						st.pop();
					
					
				}else if(a == '}' && !st.empty() && st.peek() == '{'){
					//System.out.println("if:" + a);
					
						
						st.pop();
					
					
				}else if(a == ']' && !st.empty() && st.peek() == '['){	
					//System.out.println("if:" + a);
					
						
						st.pop();
					
					
				}else{	
					st.push(a);
				}
			
		}
			
		
		
		if(st.empty())//空栈
			return true;
		else{
			//while(!st.empty())
				//System.out.println(st.pop());
			return false;
					}
	}
}
