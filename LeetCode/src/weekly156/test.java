package weekly156;

public class test {
	public static void main(String[] args) {
//		_5205_uniqueOccurrences s = new _5205_uniqueOccurrences();
//		System.out.println(s.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
//		int a = 'c' - 'a';
//		System.out.println(a);
		_5207_equalSubstring s = new _5207_equalSubstring();
		System.out.println(s.equalSubstring("abcd", "bcdf", 3));
		System.out.println(s.equalSubstring("abcd", "cdef", 3));
		System.out.println(s.equalSubstring("abcd", "acde", 0));
	}
}
