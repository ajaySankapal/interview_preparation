package C_LinkedList;
//https://leetcode.com/problems/reverse-linked-list/

//problem statement : we have given the head of the linked list we have to return the reversed linked list

import java.util.Scanner;

//there are two approaches for this problem : approach1:iterative  :aproach2:recursive

public class A_reverse_linked_list {

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

	// print using recursion
	public static void printR(Node<Integer> head) {
		if (head == null)
			return;
		System.out.print(head.data + " ");
		printR(head.next);
	}

	// approach1* using iteration
//  1->2->3->4->5->X 
// X<-1<-2<-3<-4<-5 
//in this problem we have to reverse the direction of the arrows 
//-> create a dummy node which initially is null
//-> we iterate through the list and have to make point the first node to  null 
// in linked list there is a important point to remember "make before break" 
//we want to break the connection of the node want to point it to null . so before doing this we just store the next node in another temp node next. bcz if we do'nt do this we will lost the connection of the next nodes.
//-> create a temp node which will store the node next to the head
//-> iterate through the list till head becomes null 
//-> assign next to the next of the head and head next to the dummy node
//->at last return the dummy node
	
	public static Node<Integer> reverseI(Node<Integer> head) {
		//dummy node initialize to null
		Node<Integer> newHead = null;
		//iterate through the list till head becomes null
		while (head != null) {
			//create temporary node which will store the next nodes
			//will store the nodes next to head
			Node<Integer> next = head.next;
			//will point the next of the head to this dummy node
			head.next = newHead;
			//will shift the dummy node to head
			newHead = head;
			//will shift the head to the next
			head = next;
		}
		return newHead;
	}

	// approach2* using recursion
	public static Node<Integer> reverseR(Node<Integer> head) {
		//the concept of recursion of recursion is solely based on the fact that what is the least amount of work we have to do to give the solution of a problem 
		//so in this case we have to reverse the linked list. so what is the list amount of work we can do to reverse a list
		//so if we have been given a single node list we will return that node because the reverse of the single node is the node itself
		// so this will become our base case
		if (head == null || head.next == null) ///base case if the empty list or single node is given we will just return that node
			return head;
		//now we pass the next nodes in this recursion function which will give us the reversed list 
		Node<Integer> smallHead = reverseR(head.next);
		//we have to just make sure that it will point reversely
		Node<Integer> tail = head.next;
		tail.next = head;
		head.next = null;
		return smallHead;
	}
	

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
//		head = reverseI(head);
//		head = reverseR(head);
		
		printR(head);

	}

}
