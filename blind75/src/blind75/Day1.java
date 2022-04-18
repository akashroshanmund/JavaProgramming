package blind75;
import java.util.*;

public class Day1 {

	public static void main(String[] args) {
		

	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0; i< nums.length; i++) {
			map.put(nums[i], 0);
		}
		
		for(int i = 0; i<nums.length; i++) {
			int x = target - nums[i];
			if(map.containsKey(x)) {
				ret[0] = nums[i];
				ret[1] = x;
				return ret;
			}
		}
		return ret;
	}
	
	public static int[] twoSum2(int[] nums, int target) {
	    Arrays.sort(nums);
	    int ret[] = new int[2];
	    for(int i = 0; i< nums.length; i++) {
	    	int x = target - nums[i];
	    	int index = binarySearch(nums,0,nums.length-1, target);
	    	if( index != -1) {
	    		ret[0] = i;
	    		ret[1] = index;
	    		return ret;
	    	}
	    }
	    return ret;
	}
	
	public static int binarySearch(int[] nums, int l, int r, int target) {
		int m = (l + r)/2;
		
		if(l>=r) {
			return -1;
		}
		if(nums[m] == target ) {
			return m;
		}
		else if(nums[m] < target) {
			return binarySearch(nums, m+1,r, target);
		}else {
			return binarySearch(nums, l, m, target);
		}
	
	}

}
