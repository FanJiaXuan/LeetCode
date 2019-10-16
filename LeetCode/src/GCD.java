
public class GCD {
	public static int gg(int a, int b){
		return b==0?a:gg(b, a % b);
	}
	
	public static int dd(int a, int b){
		return a * b / gg(a, b);
	}
	
	public static void main(String[] args) {
		System.out.println("16和48的最大公约数是: " + gg(64, 48));
		System.out.println("16和48的最小公倍数是: " + dd(64, 48));
	}
}
