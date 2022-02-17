package C_LinkedList;
//delete a given node from the linked list when only the node to be deleted is given
//approach: copy the next element to the node and point node.next to the node.next.next
//https://leetcode.com/problems/delete-node-in-a-linked-list/submissions/
public class E_delete_given_node_from_LL {

	//linked list
	public static Node<Integer> createLinkedList(){
		Node<Integer> n1 = new Node<>(2); // we are passing 10 in the constructor which passing 10 to the data
		Node<Integer> n2 = new Node<>(5);
		Node<Integer> n3 = new Node<>(9);
		Node<Integer> n4 = new Node<>(8);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		return n1;
	}
	
	//delete node from the linked list
	public static void delete(Node<Integer> node){
		node.data = node.next.data;
		node.next = node.next.next;
		
	}
	
	//print using recursion
	public static void printR(Node<Integer> head) {
		if(head == null) return ;
		System.out.print(head.data+" ");
		printR(head.next);
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Node<Integer> head = createLinkedList();
		
		Node<Integer> node = new Node<>(5);
		delete(node);
		printR(head);

	}

}
