package blind75;

public class Day11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class solution11{
	 public int hammingWeight(int n) {
	        int count = 0;
	        
	        while(n != 0){
	            if((n & 1) == 1){
	                count++;
	            }
	            n = n >>> 1;
	        }
	        return count;
	    }
	 
	 public int hammingWeight1(int n) {
		 int count = 0;
		 
		 for(int i = 0; i< 32; i++){
	           if( (n & (1 << i)) == (1<<i)){
	               count++;
	           }
	       }
		 
		 return count;
	 }
	 
	 public int hammingWeight2(int n) {
		 int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        
        return count;
	 }
}