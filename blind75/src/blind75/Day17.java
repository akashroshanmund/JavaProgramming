package blind75;
import java.util.*;
public class Day17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class solution17{
	
	//19. Remove Nth Node From End of List
	  /*
    nth node from the end - (length - n)th node from the beginning
    
    1.
    count the number of nodes in the list - one pass O(n)
    locate the (length - n)th node in the list - one pass O(n)
    delete the node by adjusting pointer - O(1)
    return headNode
    
    Time Complexity - O(2*n) - O(n)
    Space Complexity - O(1)
    
    2.
    slow pointer / fast pointer concept
    initialize slow pointer at head
    initialize fast pointer (n + 1)th node head of slow pointer
    if fast pointer reach null       - O(n)
      slow - desired node
      reset pointer to delete the node  - O(1)
      
    Time Complexity - O(n)
    Space Complexity - O(1)
    */
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        
        while(n > 0 ){
           
            fast = fast.next;
            n--;
        }
     
      
        if(fast == null){
            return head.next;
        }
        
        while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        
       prev.next = slow.next;
        
        return head;
    }
    
    
    
    //73. Set Matrix Zeroes
    
    /*
    If matrix[i][j] = 0 -> matrix[i][0..n] = 0 and matrix[0..n][j] = 0
    1.
    store co-ordinates of each position valued '0' - O(m * n)
    loop through all the co-ordinates and set the corresponding row and column to 0 - O(m * n * (m+n))
    if m = n - o(n^3)
    
    time complexity - O(n^3)
    space Complexity - o(1)
    2.
    keep track of nullified rows and column
    m*n /(m+n)
    consider m and n
    need to check only (n/2) * (2n) = n^2
    
    Time complexity - O(n^2)
    Space Complexity - O(m + n)
    
    */
    
    public void setZeroes(int[][] matrix) {
        
        Map<Integer,Integer> VisitedRow = new HashMap<Integer, Integer>();
        Map<Integer, Integer> VisitedColumn = new HashMap<Integer,Integer>();
        
        Map<Integer,points> zeros = new HashMap<Integer,points>();
        int count = 0;
        
        for(int row = 0; row< matrix.length; row++){
            for(int column = 0; column < matrix[0].length; column++){
                if(matrix[row][column] == 0){
                  
                   zeros.put(count++,new points(row,column));
                }
            }
        }
        
        for(Map.Entry<Integer,points> e : zeros.entrySet()){
            
            int row = e.getValue().row;
            int column = e.getValue().column;
         
             if(!VisitedRow.containsKey(row)){
                        VisitedRow.put(row,1);
                        for(int i = 0; i< matrix[0].length; i++){
                            matrix[row][i] = 0;
                        }
                    }else{
                        
                    }
                    
                    if(!VisitedColumn.containsKey(column)){
                        VisitedColumn.put(column,1);
                        for(int i = 0; i< matrix.length; i++){
                            matrix[i][column] = 0;
                        }
                    }else{
                        
                    }
        }
        
    }
}
class points{
    int row;
    int column;
    points(int row, int column){
        this.row = row;
        this.column = column;
    }
}
