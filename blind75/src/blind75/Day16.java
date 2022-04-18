package blind75;
import java.util.*;

public class Day16 {

}

class solution16{
	 /*
    1 2 3 4 5 
    1 5 2 4 3
    
    1.
    find the middle point of the linkedlist
        count the number of node and get the middle node (two pass) or
        Slow pointer and a fast pointer (one pass)
    push the second half into a stack (one pass)
    reassign pointers to each node starting from first node (one pass)
    
    Time complexity O(n)
    space complexity O(n)
    
    2.(reduce space complexity)
    find the middle pointer and store it
    loop till end node from middle each time and re assign the node pointers starting from the start
    
    for n/2 first half find last node in n/2 second half - O(n/2 * n/2) - O(n^2)
    
    Time complexity - O(n^2)
    Space complextiy - O(1)
    
    */
    public void reorderList(ListNode head) {
       
        
        Stack<ListNode> stk = new Stack<ListNode>();
        
        ListNode tempNode = findMiddleNode(head);
        
        while(tempNode != null){
            stk.push(tempNode);
            tempNode = tempNode.next;
        }
       
        ListNode nextNode = null;
        tempNode = head;
        while(stk.isEmpty() == false){
            nextNode = tempNode.next;
            tempNode.next = stk.pop();
            tempNode.next.next = nextNode;
            tempNode = nextNode;
        }
        tempNode.next = null;
        
    }
    
    ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
}