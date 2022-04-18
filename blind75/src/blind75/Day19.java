package blind75;

public class Day19 {

}

class solution19{
	
	//647. Palindromic Substrings
	  /*
    Number of palindromic substrings.
    abcdcba
    1.
      loop through all the elements  -  O(n)
      take each element as a center and expand left and right to check palindromic behaviour O(n)
      keep count of panlindromic strings 
      return the count
      
      Time Complexity - O(n^2)
      Space Complexity - O(1)
    */
    public int countSubstrings(String s) {
        int i = 0;
        int retValue = 0;
        while(i < s.length()){
            int count = getSubstringCount(s, i-1, i +1) + 1;
            retValue += count;
            count = getSubstringCount(s,i,i+1);
            retValue += count;
            i++;
        }
        return retValue;
    }
    
    public int getSubstringCount(String s, int left, int right){
        int count = 0;
        
        if(left < 0 || right >= s.length()){
            return 0;
        }
        
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                count++;
            }else{
                break;
            }
            left--;
            right++;
        }
        
        return count;
    }
}
