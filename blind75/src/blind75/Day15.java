package blind75;

public class Day15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

class solution15{
	
	//5. Longest Palindromic Substring
	
	 /*
    1.
    Find all the substrings  -- 2 nested for loops of length n -each
    check if a substring is a palindrome or not -- O(n)
    keep track of the longest palindrome
    
    Time complexity = O(n^3)
    Space Complexity = O(n)
    
    2.
    Loop through all the lements in the string - O(n)
    Check for each character what is the longest palindromic string possible O(n)
    keep track of longest palindromic string
    
    Time Complexity - O(n^2)
    Space Complexity - O(1)
    */
    
    public String longestPalindrome(String s) {
        
        int left = 0;
        int right = 0;
        
        String ret = s.charAt(0) +"";
        for(int i = 0 ; i< s.length() - 1 ; i++){
            String temp1 = CheckPalindrome(s, i, i + 1);
            String temp2 = CheckPalindrome(s, i , i );
            
            temp1 = temp1.length() >= temp2.length() ? temp1 : temp2;
            ret = temp1.length() >= ret.length() ? temp1 : ret;
         
        }
        return ret;
    }
    
    public String CheckPalindrome(String s, int left, int right){
     
        while(left >=0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                return s.substring(left+1, right);
            }
            left --;
            right ++;
        }
      return s.substring(left+1, right);
        
    }
}

}
