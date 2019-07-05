package NO9_isPalindrome;

public class Solution {
	public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char []a = str.toCharArray();
        int s = 0;
        int e = str.length() - 1;
        while(s < e){
        	if(a[s] != a[e]){
        		return false;
        	}
        	s++;
        	e--;
        }
        return true;
    }
	
//	public static void main(String[] args) {
//		   
//        String sentence = "����,�ڽ���������8�λ�ɱ��,����� ���� �ĳƺ�";
//         
//        char c = sentence.charAt(0);
//         
//        System.out.println(c);
//           
//    }
}
