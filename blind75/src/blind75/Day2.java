package blind75;
import java.util.*;

public class Day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}

class solution2{
	private static final int HashMap = 0;

	public int maxProfit(int[] prices) {
		int buy_price = prices[0];
		int sell_price = 0;
		int profit = 0;
		
		if(prices.length == 1) {
			return 0;
		}
		for(int i = 1; i< prices.length ; i++) {
			
			sell_price = prices[i];
			if(profit < (sell_price - buy_price)) {
				profit = sell_price - buy_price;
			}
			
			if(buy_price > prices[i]) {
				buy_price = prices[i];
			}
		}
		
		return profit;
	}
	
	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0; i< nums.length; i++) {
			if(map.containsKey(nums[i])) {
				return true;
			}else {
				map.put(nums[i], 0);
			}
		}
		return false;
	}
}
