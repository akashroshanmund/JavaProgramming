package blind75;
import java.util.*;
public class Day9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

 class ListNode {
	      int val;
	      ListNode next;
          ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }

class solution9{
	//206. Reverse Linked List
	 public ListNode reverseList(ListNode head) {
       Stack<ListNode> stk = new Stack<ListNode>();
      
       if(head == null){
           return head;
       }
       while(head != null){
           stk.push(head);
           head = head.next;
       }
      
       head = stk.pop();
       ListNode temp = head;
       while(stk.isEmpty() == false){
           temp.next = stk.pop();
           temp = temp.next;
       }
       temp.next = null;
        return head;
	 }
	 
	 public ListNode reverseList1(ListNode head) {
		 
	 
      
      if(head == null){
          return null;
      }
      
      ListNode prev = null;
      ListNode present = head;
      ListNode next = head.next;
      
      while(next != null){
          next = present.next;
          present.next = prev;
          prev = present;
          present = next;
      }
      
     return prev == null ? present : prev;
  }
	 
//141. Linked List Cycle
	 
	 public boolean hasCycle(ListNode head) {
		  Map<ListNode, Integer> map = new HashMap<ListNode,Integer>();
		 while(head != null){
	            if(map.containsKey(head)){
	                return true;
	            }else{
	                map.put(head, 0);
	            }
	            head = head.next;
	        }
	        return false;
	    }
	 
	 public boolean hasCycle1(ListNode head) {
	      
		  ListNode slow = head;
	        ListNode fast = head;
	        
	        while(fast != null){
	            slow = slow.next;
	            fast = fast.next;
	            if(fast == null){
	                return false;
	            }else{
	                fast = fast.next;
	            }
	            if(fast == slow){
	                return true;
	            }
	        }
	        return false;
	        
	    }
	 
	 
	 //21. Merge Two Sorted Lists
	 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode head = null;
	        ListNode prev = list1;
	        ListNode temp = null;
	        if(list1 == null) {
	        	return list2;
	        }
	        
	        while(list1 != null && list2 != null) {
	        	if(list2.val < list1.val) {
	        		if(head == null) {
                       
	        			head = list2;
	        			temp = list2.next;
	        			list2.next = list1;
                     // list1 = list2;
                        prev = list2;
	        			list2 = temp;
                       
                       
	        		}else {
	        			prev.next = list2;
	        			temp = list2.next;
	        			list2.next = list1;
	        			list2 = temp;
	        		}
	        	}else {
                  if(head == null){
                      head = list1;
                  }
	        		prev = list1;
	        		list1 = list1.next;
	        	}
	        }
	        if(list1 == null) {
	        	list1 = prev;
	        }
	       list1.next = list2;
	       
	       return head;
   }
	 
}
