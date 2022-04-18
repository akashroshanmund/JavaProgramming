package blind75;
import java.util.*;
public class Day14 {

}

class solution14{
	
	//20. Valid Parentheses
	  /*
    ({[]})
    
    1.
    create a stack
    if open parantheses push to the stack
    if close parantheses pop one element from the stack and check for validation
    */
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character, Character>();
        
        map.put(')',  '(');
        map.put('}',  '{');
        map.put(']',  '[');
        
        int i = 0;
        while(  i < s.length()){
            char temp = s.charAt(i);
            
            if(temp == '(' || temp == '{' || temp == '['){
                stk.push(temp);
            }
             else if(stk.isEmpty() == true || map.get(temp) != stk.pop()){
                    return false;
                }
            
            i++;
        }
        return stk.isEmpty();
    }
	
	
	//125. Valid Palindrome
	 /*
    1.
    convert the string to lowercase
    make sure only considering the lower case alpha numeric data
    
    create a left pointer and a right pointer
    if character at left pointer and right pointer are alphanumeric check if equal
    
    if yes
      left++ right--
    else
      return false
    abba
    */
    public boolean isPalindrome(String s) { 
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            
            if(Character.isLetterOrDigit(l) == false){
                left++;
                continue;
            }
            if(Character.isLetterOrDigit(r) == false){
                right--;
                continue;
            }
            
            if(Character.toLowerCase(l) == Character.toLowerCase(r)){
                left++;
                right--;
            }else{
                return false;
            }
            
        }
        return true;
    }
}