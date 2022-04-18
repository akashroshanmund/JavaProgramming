package blind75;

import java.util.*;
public class Day8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class solution8{
	public int[][] merge(int[][] intervals){
		List<int[]> output = new LinkedList<int[]>();
		
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
		
		for(int i = 0;  i < intervals.length; i++) {
			output.add(intervals[i]);
		}
		
		int len = 0;
		
		while(len < output.size()-1) {
			int[] temp = output.get(len);
			int[] temp2 = output.get(len+1);
			System.out.println(temp[0]+" "+ temp2[0]);
			if(temp2[0] <= temp[1]) {
				temp[1] = Math.max(temp[1], temp2[1]);
				output.set(len, temp);
				output.remove(len+1);
			}else {
				len++;
			}
		}
	
		return output.toArray(new int[output.size()][]);
	}
	
	public int[][] merge2(int[][] intervals){
		List<int[]> output = new LinkedList<int[]>();
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
		
		output.add(intervals[0]);
		
		for(int i = 1; i< intervals.length; i++) {
			int[] temp1 = intervals[i-1];
			int[] temp2 = intervals[i];
			
			if(temp2[0] <= temp1[1]) {
				temp1[1] = Math.max(temp1[1], temp2[1]);
				output.set(output.size() - 1, temp1);
			}else {
				output.add(temp2);
			}
		}
		return output.toArray(new int[output.size()][]);
	}
}
