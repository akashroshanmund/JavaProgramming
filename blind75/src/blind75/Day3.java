package blind75;

public class Day3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class solution3{
	public int[] productExceptSelf(int[] sums) {
		
		int[] ret = new int[sums.length];
		
		ret[0] = 1;
		
		int left_index = 1;
		int rightValue = 1;
		
		while(left_index < sums.length) {
			ret[left_index] = ret[left_index - 1] * sums[left_index -1];
			left_index++;
		}
		
		for(int i = sums.length-1; i >= 0 ; i--) {
			ret[i] = ret[i] * rightValue;
			rightValue *= sums[i];
		}
		
		return ret;
		
	}
}
