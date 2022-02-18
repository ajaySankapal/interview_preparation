package C_LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/problems/palindrome-linked-list/
import java.util.Scanner;
import java.util.Stack;

public class I_isPallindrome_LL {

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

	// first approach using stack: Time-complexity: O(N) space-complexity:O(N)
	public static boolean isPallindromeA(Node<Integer> head) {
		Stack<Integer> stack = new Stack<Integer>();
		Node<Integer> dummy = head;
		boolean isPalindrome = false;
		while (dummy != null) {
			stack.push(dummy.data);
			dummy = dummy.next;
		}
		while (head != null) {
			int i = stack.pop();
			if (i == head.data) {
				isPalindrome = true;
			} else {
				isPalindrome = false;
				break;
			}
			head = head.next;
		}
		return isPalindrome;
	}

	// check whether linked list is pallindrome or not
	// second: optimized approach: time-complexity:O(N) space-complexity:O(1)
	// The only way to check for a palindrome in O(1) space would require us to be
	// able to access both nodes for comparison at the same time, rather than
	// storing values for later comparison. This would seem to be a challenge, as
	// the linked list only promotes travel in one direction.
	// what we can do is reverse the back half of the linked list and then compare
	// the first half with the second half if the values are same we will return true
	//  if not return false
	public static boolean isPallindrome(Node<Integer> head) {
		if (head == null || head.next == null)
			return true;
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		// midle of the linked list
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		// reverse back half of the LL
		slow.next = reverseList(slow.next);
		slow = slow.next;
		while (slow != null) {
			if (head.data != slow.data)
				return false;
			slow = slow.next;
			head = head.next;
		}
		return true;
	}

	public static Node<Integer> reverseList(Node<Integer> head) {
		if (head == null || head.next == null)
			return head;
		Node<Integer> smallHead = reverseList(head.next);
		Node<Integer> tail = head.next;
		tail.next = head;
		head.next = null;
		return smallHead;
	}

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
//		System.out.println(isPallindrome(head));
		System.out.println(isPallindromeA(head));

	}

}
