package blind75;

import java.util.*;
public class Day5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//3. Longest Substring Without Repeating Characters
class solution5{
	public int lengthOfLongestSubstring(String s) {
		 int ret = 1;	
			int start = 0;
	       
			if(s.length() == 0){
	            return 0;
	        }
			Map<String, Integer> map = new HashMap<String,Integer>();
		
			for(int i = 0; i< s.length(); i++) {
				
				if(map.containsKey(s.charAt(i)+"")) {
					
					ret = Math.max(ret, i-start);
					int x = map.get(s.charAt(i) +"");
	                if( x + 1 > start){
					    start =x +1;
	                }
					
					
				}
	            map.put(s.charAt(i)+"", i);
			}
	      
	        ret = Math.max(ret, s.length() -start);
			return ret;
			
	}
}