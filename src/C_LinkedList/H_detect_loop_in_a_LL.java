package C_LinkedList;

import java.util.HashSet;
import java.util.Set;

//https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1

//problem statement: we have been given a Linked list we have to check if there is any loop in this linked list and return true if there is loop or return false if there is not

//approach1: by hashset hashset.
//-> we create a hashset to store the node of the LL
//-> we iterate through the list and add the nodes to the set 
//-> and check if the nodes if present in this set or not
//-> if there is any node we come acrose while iterating through the list which is present in the set then we return true: (because it will only happen if there is any loop is there in the cycle)
//-> else we return false;

//approach2: by taking two pointers
//-> we initialize two pointers fast and slow.initially it will point to the head of the linked list
//-> we iterate through the linked list till head becomes null
//-> move fast by two positions and slow by one position
//-> if there is any loop present in the list the two pointers will collide 
//-> means if slow == fast we return true 
//-> else return false;

public class H_detect_loop_in_a_LL {

	//approach1:code
	 public static boolean detectLoopHashSet(Node head){
	        // Add code here
	       Set<Node> visited = new HashSet<>();
	       if(head == null || head.next == null) return false;
	       while(head != null && head.next != null){
	           visited.add(head);
	           head = head.next;
	           if(visited.contains(head)){
	               return true;
	           }
	       }
	       return false;
	    }
	
	//approach2:code
	public static boolean detectLoop(Node head){
        // Add code here
       if(head == null || head.next == null) return false;
       Node slow = head;
       Node fast = head;
       while(fast.next != null && fast.next.next != null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow){
               return true;
           }
       }
       return false;
    }
	
	 //linked list
	public static Node<Integer> createLinkedList(){
		Node<Integer> n1 = new Node<>(2); // we are passing 10 in the constructor which passing 10 to the data
		Node<Integer> n2 = new Node<>(4);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		return n1;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = createLinkedList();
      //System.out.println(detectLoopHashSet(head));    
		System.out.println(detectLoop(head));

	}

}
