package N_NO14_longestCommonPrefix;

public class Solutions2 {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return "";
		String it = strs[0];
		for(int i = 1; i < strs.length; i++){
			while(strs[i].indexOf(it) != 0){
				it = it.substring(0, it.length() - 1);
				if(it.length() == 0)
					return "";
			}
		}
		return it;
	}
}
