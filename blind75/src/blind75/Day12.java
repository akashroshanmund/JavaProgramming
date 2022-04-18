package blind75;
import java.util.*;
public class Day12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class solution12{
	 /*
    Replacement count - k
    required - longest substring with repeating character
    
    "AABABBA"
     k = 1
     1. Sliding window
     keep track of maximum occuring character in the substring
     extra characters allowed apart from max element is k
     keep expanding till with in the error range
     start contracting if exceeding the maximum length
      
    */
    public int characterReplacement(String s, int k) {
      
        int left = 0;
        int right = 0;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        
        int maxLength = 0;
        int maxChar = 1;
        while(right < s.length()){
            
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            maxChar = Math.max(maxChar, map.getOrDefault(s.charAt(right),0));
            
            if((right - left +1 ) - maxChar > k){
                
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0)-1);
                maxLength = Math.max(maxLength, right - left +1);
                left++;
            }
            right++;
           
        }
        return  right-left ;
}
}
