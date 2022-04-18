package blind75;

public class Day4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class solution4{
	
	 public int maxSubArray(int[] nums) {
 		int ret = Integer.MIN_VALUE;
		int sum = 0;
		int leftIndex = 0;
		int rightIndex = nums.length-1;
		
		int tempLeft= 0;
	
		for(int i = 0; i<nums.length; i++) {
			sum += nums[i];
	     if(sum < 0) {
				sum = 0;
				tempLeft = i+1;
			
				
			}
			if(sum >= ret) {
				ret = sum;
				rightIndex = i;
	         leftIndex = tempLeft;
				
			}
			
		}
		System.out.println(leftIndex+" "+rightIndex);
		return ret;
}
}
