package blind75;

import java.util.Arrays;

public class Day7 {

	//57. Insert Interval
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

	
}

class solution7{
		   int[][] ret;
		    int retIndex = 0;
			public int[][] insert(int[][] intervals, int[] newInterval){
				
		        if(intervals.length ==0){
		            int[][] x = {{newInterval[0],newInterval[1]}};
		            return x;
		        }
		        
		        
				ret = new int[intervals.length+1][2];
				int newLeft = newInterval[0];
		        int leftIndex = 0;
		         if(intervals.length == 1){
		            if(intervals[0][0] < newInterval[0] ){
		                ret[0] = intervals[0];
		                ret[1] = newInterval;
		            }else{
		                ret[1] = intervals[0];
		                ret[0] = newInterval;
		            }
		        }else if(newInterval[0] < intervals[0][0]){
		             ret[0] = newInterval;
		             for(int i = 0; i < intervals.length; i++){
		                 ret[i+1] = intervals[i];
		             }
		            
		         }else if(newInterval[0] > intervals[intervals.length -1][1]){
		            
		             for(int i = 0; i < intervals.length; i++){
		                 ret[i] = intervals[i];
		             }
		              ret[intervals.length] = newInterval;
		             return ret;
		         }
		        else{
				 leftIndex = Math.max(insertNewIntervar(intervals, newInterval),0);
		    }
		        for(int i = 0; i< ret.length; i++){
		            System.out.println(ret[i][0]+" "+ret[i][1]);
		        }
				int length = insertOverlap(ret,newInterval, leftIndex);
		        
		         System.out.println(length);
		        
				for(int i = 0; i< length; i++){
		            System.out.println(ret[i][0]+" "+ret[i][1]);
		        }
		       // System.out.println(retIndex+" "+newInterval.length);
		        
		       int result[][] = new int[length][2];
		       
		        for(int i = 0 ; i< length; i++){
		            result[i] = ret[i];
		        }
		        
				return result;
				
			}
		    
			
			public int insertOverlap(int[][] intervals, int[] newInterval, int leftIndex) {
				for(int i = leftIndex + 1; i < ret.length; i++){
		            
		          if(ret[i][0] <= ret[leftIndex][1] && ret[i][1] <= ret[leftIndex][1]){
		              ret[i] = ret[leftIndex];
		          }else if(ret[i][0] <= ret[leftIndex][1] && ret[i][1] >= ret[leftIndex][1]){
		              ret[leftIndex][1] = ret[i][1];
		             
		          }else{
		              ret[leftIndex+1] = ret[i];
		              leftIndex++;
		          }
		        }
		        return leftIndex+1;
			}
			public int insertNewIntervar(int[][] intervals, int[] newInterval) {
				int right = 0;
				int newLeft = newInterval[0];
				int newRight = newInterval[1];
				
		        boolean flag = true;
		        int index = intervals.length-1;
				for(int i = 0; i< intervals.length; i++) {
					if(intervals[i][1] >= newLeft  && flag) {
		                flag = false;
						if(intervals[i][0] > newLeft) {
							ret[i] = newInterval;
							ret[i+1] = intervals[i]; 
		                    retIndex = i+2;
							index = i - 1;
						}else {
							
							intervals[i][1] = Math.max(newRight,intervals[i][1]);
							ret[i] = intervals[i];
		                    retIndex = i + 1;
							index = i;
						}
					}else {
						ret[retIndex++] = intervals[i];
		                
					}
				}
				return index;
			}
		}
