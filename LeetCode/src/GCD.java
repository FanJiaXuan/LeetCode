
public class GCD {
	public static int gg(int a, int b){
		return b==0?a:gg(b, a % b);
	}
	
	public static void main(String[] args) {
		System.out.println(gg(64, 48));
	}
}
