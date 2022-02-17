package C_LinkedList;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
public class D_delete_nth_node_from_end_of_the_list {

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
//	public static Node<Integer> deleteNthNode(Node<Integer> head,int k){
//		int count = 1;
//		Node<Integer> temp = head;
//		while(temp != null) {
//			count++;
//			temp = temp.next;
//		}
//		Node<Integer> temp2 = head;
//		int count2=1;
//		while(count2 < count-k && temp2 != null) {
//			count2++;
//			temp2 = temp2.next;
//		}
//			temp2.next = temp2.next.next;
////		    head = temp2;
//		
//		return head;
//	}
	
	public static Node<Integer> deleteNthNode(Node<Integer> head,int k){
		Node<Integer> start = head;
		Node<Integer> slow = start;
		Node<Integer> fast = start;
		for(int i=0;i<=k;i++) {
			fast = fast.next;
		}
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
		
		
	}
	
	//print using recursion
	public static void printR(Node<Integer> head) {
		if(head == null) return ;
		System.out.print(head.data+" ");
		printR(head.next);
	}
	
	public static void main(String[] args) {
		Node<Integer> head = createLinkedList();
         head = deleteNthNode(head,1);
         printR(head);
	}

}
