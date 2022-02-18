package C_LinkedList;

//https://leetcode.com/problems/linked-list-cycle-ii/

import java.util.HashSet;
import java.util.Set;
//Node@2c7b84de
public class J_start_of_the_cycle_in_LL {

	public static Node<Integer> createLinkedList(){
		Node<Integer> n1 = new Node<>(3);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(0);
		Node<Integer> n4 = new Node<>(-5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
//		System.out.println(n2);
		return n1;
	}
	//approach1* using hashset time-complexity:O(N) space-complexity:O(N)
	//we use a hashset to store the nodes
	// we iterate through the list and store the nodes in the set
	//while adding the nodes we check if the set contains this node already ? if it is not contain we add that node in the set else if the node is already present 
	//we return that node because that node is the starting of our linked list
	public static Node<Integer> detectLoop(Node<Integer> head){
		Node<Integer> dummy = head;
		Set<Node> set = new HashSet<Node>();
		while(dummy != null) {
			if(set.contains(dummy)) {
				return dummy;
			}else {
				set.add(dummy);
			}
			dummy = dummy.next;
		}
		return null;
	}
	
	
	
	
	
//	Distance traveled by fast pointer = 2 * (Distance traveled  by slow pointer)
//(m + n*x + k) = 2*(m + n*y + k)
//Note that before meeting the point shown above, fast
//was moving at twice speed.
//x -->  Number of complete cyclic rounds made by 
//fast pointer before they meet first time
//y -->  Number of complete cyclic rounds made by 
//slow pointer before they meet first time
	
//Basically what it means is:

//In the first iteration they will meet at k: by solving the equation we get m+k is a multiple of n.
//This suggests that it will be a full cycle at m+k.
//If the fast pointer starts again from k, it will need m to complete a full cycle or a multiple of a full cycle depending on the value of n.
//Since the fast pointer has already covered k it needs m steps to complete a cycle.
//We dont know what m is. hence we start the slow pointer from the start.
//When these two pointers meet fast pointer has travelled m+k in the loop and slow has travelled m. Hence we return slow as it is the start of the loop.
	public static Node<Integer> detectLoopP(Node<Integer> head){
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				slow = head;
				slow = slow.next;
				fast = fast.next;
				if(slow == fast) {
					return slow;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = createLinkedList();
		System.out.println(detectLoopP(head));
		

	}

}
