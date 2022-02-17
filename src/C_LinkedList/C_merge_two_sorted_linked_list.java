package C_LinkedList;

//https://leetcode.com/problems/merge-two-sorted-lists/submissions/
//https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
public class C_merge_two_sorted_linked_list {

	//create linked list
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
		
		//second linked list
		public static Node<Integer> createLinkedList2(){
			Node<Integer> n1 = new Node<>(3); // we are passing 10 in the constructor which passing 10 to the data
			Node<Integer> n2 = new Node<>(4);
			Node<Integer> n3 = new Node<>(5);
			
			n1.next = n2;
			n2.next = n3;
			
			return n1;
		}
		
		//merge two sorted linked list
		public static Node<Integer> mergeTwoSortedLL(Node<Integer> l1,Node<Integer> l2){
			while(l1.data>l2.data) {
				Node<Integer> temp = l1;
				l1=l2;
				l2=temp;
			}
			Node<Integer> res = l1;
			while(l1 != null && l2 != null) {
				Node<Integer> tmp = null;
				while(l1 != null && l1.data<=l2.data) {
					tmp = l1;
					l1 = l1.next;
				}
				tmp.next = l2;
				
				//swap
				Node<Integer> temp = l1;
				l1 = l2;
				l2 = temp;
				
			}
			return res;
		}
		
		//print using recursion
				public static void printR(Node<Integer> head) {
					if(head == null) return ;
					System.out.print(head.data+" ");
					printR(head.next);
				}
	
	public static void main(String[] args) {
		Node<Integer> l1 = createLinkedList();
		Node<Integer> l2 = createLinkedList2();
        Node<Integer> head = mergeTwoSortedLL(l1, l2);
        printR(head);
	}

}
