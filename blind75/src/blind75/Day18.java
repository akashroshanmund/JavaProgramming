package blind75;
import java.util.*;
public class Day18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
}

class solution18{
	/*
    Facts:
    1. infinite number of given demominations
    2. Find the the minimum count
    3 Target given
    
    Approach:
    1. coins: [1, 2, 5], target: 11
    1- 10, [1,2,5] : 1- 9, [1,2,5]..... 1- 1 [ 1,2,5]
    
    target  - T
    Find each ways to reach the target T, then store the minimum count
    
    Time Complexity: T^N , T - target, N - number of coins given
    Space Complexity: T, we need T recursive calls to be stored in the stack
    */
    public int coinChange(int[] coins, int amount) {
        if(amount  < 0)
            return -1;
        if(amount == 0)
            return 0;
        
        int minCount = Integer.MAX_VALUE;
        
        for(int i = 0; i< coins.length; i++){
            int count = coinChange(coins, amount - coins[i]);
            
            if(count == -1)
                continue;
            minCount = Math.min(minCount, count + 1);
        }
        
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
}
