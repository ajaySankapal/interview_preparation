package C_LinkedList;


public class L_rotate_linked_list_by_k {

	    // linked list
		public static Node<Integer> createLinkedList(){
			Node<Integer> n1 = new Node<>(1); // we are passing 10 in the constructor which passing 10 to the data
			Node<Integer> n2 = new Node<>(2);
			Node<Integer> n3 = new Node<>(3);
			Node<Integer> n4 = new Node<>(4);
			Node<Integer> n5 = new Node<>(5);
			Node<Integer> n6 = new Node<>(6);
			n1.next = n2;
			n2.next = n3;
			n3.next = n4;
			n4.next = n5;
			n5.next = n6;
			return n1;
		}
		
		//rotate linked list by k
		public static Node<Integer> rotateLL(Node<Integer> head,int k){
			if(head == null || head.next == null || k == 0) return head;
			//initialize dummy node cur to head
			//iterate until cur becomes null and count the length of the linked list
				Node<Integer> cur = head;
				int length = 1;
				while(cur.next != null) {
					length++;
					cur = cur.next;
					
				}
				//after this loop cur is at last node
				// we want to rotate the list by k so last node have to come at start so 
				// we make last node cur to point at head
				cur.next = head;
				//in order to decrease number of rotation for k greater than the size of the list 
				//we hadle this case by k % length
				k = k%length;
				// 1->2->3->4->5->X
				// 4->5->1->2->3->X
				//if we notice closely k = 2 length = 5 the k-length's node is pointing to null
				//we store k-length's value in k 
				// k =3
				k = length -k;
				//travel through k till 3 
				while(k-- >0) {
					cur = cur.next;
				}
				//now our cur is at node 3. our task is to point this cur to null. so before breaking the link we have to make the link
				// we assign head to the  cur's next and cur's next to the null 
				head = cur.next;
				cur.next = null;
			
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
	    head = rotateLL(head,2);
		printR(head);

	}

}
