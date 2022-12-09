package examples;

public class DataStructureExamples {

/////////////////////////////LINKED LISTS/////////////////////////////////////
	 static class ListNode {
		private int val;
		private ListNode next;
		
		public ListNode() {}
		
		public ListNode(int val) {
			this.val = val;
		}
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		
	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    
    }
	
	//TIME (N)
	//SPACE (N)
	 public ListNode reverseList(ListNode head) {
		 if (head == null || head.next == null)
			    return head;
		 
		//Reverse the list except me (descend to the bottom of the call stack or end of the ll)
		ListNode rest = reverseList(head.next);
		
		//Upward reversal set next nodes next to the head and then set the next to null
		head.next.next = head;
		head.next = null;
		
		//return upward
		return rest;
	    }
	 
	 
	 //TIME O(N)
	 //SPACE O(1)
	 public ListNode reverseListIterativley(ListNode head) {
		 ListNode prev = new ListNode();
		 ListNode curr = head;
		 ListNode next = new ListNode();
		 
		 while(curr != null) {
			 //Stash next as not to lose the link
			 //Set Curr to prev to reverse
			 //Advance prev
			 //Advance Curr
			 //return prev when curr == null
			 
			 //Stash Next so we can change pointer
			 next = curr.next;
			 //Change pointer of the currents next values to now be the previous (which will be null
			 // on first iteration) 
			 curr.next = prev;
			 //Move the list forward for next iteration by setting previous to current
			 prev = curr;
			 //curr is now the next value for next iteration
			 curr = next; 
		 }
		 return prev;
	    }
	 
	 
	 //TIME O(N)
	 //SPACE O(1)
	 public ListNode middleNode(ListNode head) {
		 //Use pointers based on the position of the list you are looking for
		 //slow computes at half the speed of fast which will in return result in the 
		 //middle of the list
		 ListNode slow = head, fast = head;
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
/////////////////////////END OF LINKED LISTS/////////////////////////////////////
	
	
}



