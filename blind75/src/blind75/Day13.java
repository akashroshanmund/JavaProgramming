package blind75;
import java.util.*;
public class Day13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class solution13{
	
	//242. Valid Anagram
	
	 /*1: 2 * array[128] - s,t
    loop and push each character with frequency
    cehck if both table are same at the end or not
    
    2: (won't workd)
    array[128] - keep updating the index for both strings. 
    check if frequency of each index is 0 at the end
    
   [XXXX] 3: (won't work) for example s = aa and t = bb
    take a map : if new push it else remove it
    if size == 0 at the end, return true else false
    
    4: 
    Sort the strings and compare if both are same after sorting return true else false
    O(nlog n)
    */
    public boolean isAnagram(String s, String t) {
        
        int[] count = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        
        for(int i = 0; i< s.length() ; i++){
           count[s.charAt(i) - 'a']++;
           count[t.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i<26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
	
	
	//49. Group Anagrams
	
	/*
    1:
    loop through elements in the array and sort all elements - O(n* klog k), k -> maxlen of element
    sort the array - O(nlog n)
    combine the same elements as groups
    
    2:
    match each element against all other and check for anagram - (n^2 * k), k -> maxLen of element
    
    3:
    Loop through and keep a HashMap list and check for anagram for each input
    O(n*n*k)
    */
    
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> map = new HashMap<String,List<String>>();
        
        for(int i = 0; i< strs.length ; i++){
            String anagram = checkAnagram(map, strs[i]);
          
            
            if(anagram == null){
                List<String> lst = new ArrayList<String>();
                lst.add(strs[i]);
                map.put(strs[i], lst);
            }else{
                List<String> lst = map.get(anagram);
                lst.add(strs[i]);
                map.put(anagram, lst);
            }
        }
        
        List<List<String>> retlist = new ArrayList<List<String>>();
        
        for(Map.Entry<String,List<String>> e : map.entrySet()){
            retlist.add(e.getValue());
        }
        
        return retlist;
    }
    
    public String checkAnagram(Map<String, List<String>> map, String s){
        int[] counter;
        for(Map.Entry<String,List<String>> e: map.entrySet()){
            String t = e.getKey();
            counter = new int[26];

            if(t.length() != s.length()){
                continue;
            }
            for(int i = 0; i< t.length(); i++){
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }
            int i = 0;
            for( i = 0; i< 26 ; i++){
                if(counter[i] != 0){
                    break;
                }
                
            }
            if(i == 26){
                return t;
            }
            
            
        }
        return null;
    }
}
