
public class GCD {
	public static int gg(int a, int b){
		return b==0?a:gg(b, a % b);
	}
	
	public static int dd(int a, int b){
		return a * b / gg(a, b);
	}
	
	public static void main(String[] args) {
		System.out.println("16��48�����Լ����: " + gg(64, 48));
		System.out.println("16��48����С��������: " + dd(64, 48));
	}
}
