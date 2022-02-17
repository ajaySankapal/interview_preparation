package C_LinkedList;

import java.util.Scanner;

public class B_find_middle_of_linked_list {

	// take input of the linked list
	public static Node<Integer> takeInput() {
		Scanner s = new Scanner(System.in);
		Node<Integer> head = null, tail = null;
		int data = s.nextInt();
		while (data != -1) {
			Node<Integer> currentNode = new Node<>(data);
			if (head == null) {
				head = currentNode;
				tail = currentNode;
			} else {
				tail.next = currentNode;
				tail = tail.next;
			}

			data = s.nextInt();
		}
		return head;
	}
	//print using recursion
	public static void printR(Node<Integer> head) {
		if(head == null) return ;
		System.out.print(head.data+" ");
		printR(head.next);
	}
	
	//middle of linked list
	public static int middle(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		if(head==null || head.next == null) return head.data;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}
	
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		System.out.println(middle(head));

	}

}
