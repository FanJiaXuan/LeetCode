
public class 正向fab纳妾数列 {
	public int fab(int x){
		if(x == 1)
			return 1;
		if(x == 2)
			return 2;
		
		int first = 1;
		int second = 2;
		for(int i = 3; i <= x; i++){
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}
}
