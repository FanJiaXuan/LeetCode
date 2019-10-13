package weekly158;

public class NO5222_balancedStringSplit {
	public int balancedStringSplit(String s) {
        int count = 0;
        int l = 0, r = 0;
        char[] a = s.toCharArray();
        for(int i = 0; i < a.length; i++){
        	if(a[i] == 'L'){
        		l++;
        	}else
        		r++;
        	if(l == r){
        		count++;
        		l = 0;
        		r = 0;
        	}
        }
        return count;
	}
}
