package C_LinkedList;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
//https://practice.geeksforgeeks.org/problems/intersection-of-two-linked-list/1

//problem statement: we have to return the node where the reference node is same
public class G_intersection_of_two_linked_list {
	// create linked list
	public static Node<Integer> createLinkedList() {
		Node<Integer> n1 = new Node<>(4); // we are passing 10 in the constructor which passing 10 to the data
		Node<Integer> n2 = new Node<>(1);
		Node<Integer> n3 = new Node<>(8);
		Node<Integer> n4 = new Node<>(4);
		Node<Integer> n5 = new Node<>(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		return n1;
	}

	// second linked list
	public static Node<Integer> createLinkedList2() {
		Node<Integer> n1 = new Node<>(5); // we are passing 10 in the constructor which passing 10 to the data
		Node<Integer> n2 = new Node<>(6);
		Node<Integer> n3 = new Node<>(1);
		Node<Integer> n4 = new Node<>(8);
		Node<Integer> n5 = new Node<>(4);
		Node<Integer> n6 = new Node<>(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		return n1;
	}

	// find intersection of two linked list
//**approach1: extreme brute force approach
	// you start one of the linked list let say l2 and check all the nodes of the l1
	// check if both the nodes are the same(*remember both the nodes the
	// values:means is these node is pointed by two differente node or node: two
	// different node points to the same node)
	// if there is any same node we simply return these node
	// the time coplexity of this approach is O(M*N)

//**approach2: by using hashset :: time complexity->O(M+N)  space complexity->O(N) 
	// we will iterate through the first linked list and put the nodes in the hashset
	// then we will iterate throught the second linked list and see if the node of
	// the second linked is present in the hashset? if it is present return that
	// same node. this will be the first intersection node
	public static Node<Integer> findIntersectionOfTwoLL(Node<Integer> headA, Node<Integer> headB) {
		// create hashset to store the nodes of the first linked list
		Set<Node> visited = new HashSet<>();
		while (headA != null) {
			// iterate through the first linked list and store the nodes in the hashset
			visited.add(headA);
			headA = headA.next;
		}
		// iterate through the second linked list and check if the nodes of the second
		// linked list is present in the first linked list or not if it is present
		// return that node
		while (headB != null) {
			if (visited.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		// if the node is not found return null
		return null;
	}
	
//** approach3: best approach: time-complexity->O(2M) space-complexity->O(1)
//in this approach we will create dummy node1 and dummy node2 which will point to the head of the first and second list respectively
//then we will iterate through the linked lists by incrementing dummynode1 and dummynode2 by pos 1.
//the moment any of the list ends we assign node of that list to the second list: e.g l1 becomes null so we assign dummynode1 to l2 and vice versa and start the iteration by shifting dummynodes by one position
	
//code
	 public static Node<Integer> getIntersectionNode(Node<Integer> headA, Node<Integer> headB) {
		 //create two dummy nodes pointing to the head of the linked lists
		 Node<Integer> d1 = headA;
		 Node<Integer> d2 = headB;
		 //iterate through the linked till both the nodes becomes equal
	        while(d1 != d2){
	           if(d1 == null){
	        	   //if first list becomes null we assign dummynode1 to the second list
	               d1 = headB;
	           }else{
	        	   //we increment the dummynode1 by one position
	               d1 = d1.next;
	           }
	             if(d2 == null){
	            	//if second list becomes null we assign dummynode2 to the second list
	               d2 = headA;
	           }else{
	        	   //increment the dummynode2 by one position
	               d2 = d2.next;
	           }
	        }
	        return d1;
	    }
	public static void main(String[] args) {
		Node<Integer> headA = createLinkedList();
		Node<Integer> headB = createLinkedList2();
//		System.out.println(findIntersectionOfTwoLL(headA, headB));
		System.out.println(getIntersectionNode(headA, headB));

	}

}
