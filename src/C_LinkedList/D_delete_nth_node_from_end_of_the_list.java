package C_LinkedList;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
public class D_delete_nth_node_from_end_of_the_list {

	//linked list
	public static Node<Integer> createLinkedList(){
		Node<Integer> n1 = new Node<>(1); // we are passing 10 in the constructor which passing 10 to the data
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);
		Node<Integer> n5 = new Node<>(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		return n1;
	}
	
	//problem statement:Given the head of a linked list, remove the nth node from the end of the list and return its head.
	//1->2->3->4->5->X
	//1->2->3---->5->X
	//      s
	//->create one dummy node start which initially stores 0
	//->create two pointers which is initially at start;
	//->move fast pointer till pos k (remember, loop will start from 0)
	//->now fast is at 3
	//1->2->3->4->5->X
//  s       f
	//run a while loop till fast becomes null
	//1->2->3->4->5->X
	//      s        f
	//now make slow's next to the slows next next(it will break the connection of 3 with 4 and make it point to 5
	//1->2->3--->5->X
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
//	
	//print using recursion
	public static void printR(Node<Integer> head) {
		if(head == null) return ;
		System.out.print(head.data+" ");
		printR(head.next);
	}
	
	public static void main(String[] args) {
		Node<Integer> head = createLinkedList();
         head = deleteNthNode(head,2);
         printR(head);
	}

}
