package C_LinkedList;

//https://leetcode.com/problems/add-two-numbers/

public class F_add_two_numbers_given_as_LL {

	       //first linked list
			public static Node<Integer> createLinkedList(){
				Node<Integer> n1 = new Node<>(2); // we are passing 10 in the constructor which passing 10 to the data
				Node<Integer> n2 = new Node<>(4);
				Node<Integer> n3 = new Node<>(3);
				n1.next = n2;
				n2.next = n3;
				return n1;
			}
			
			//second linked list
			public static Node<Integer> createLinkedList2(){
				Node<Integer> n1 = new Node<>(5); // we are passing 10 in the constructor which passing 10 to the data
				Node<Integer> n2 = new Node<>(6);
				Node<Integer> n3 = new Node<>(4);
				
				n1.next = n2;
				n2.next = n3;
				
				return n1;
			}
			
			public static Node<Integer> addTwoNum(Node<Integer> l1,Node<Integer> l2){
				//create one dummy node which will point to the resultant linked list which will contain the sum
				Node<Integer> dummy = new Node<Integer>(0);
				//copy dummy to the temp because we will increment it and point to the next node of the resultant list
				Node<Integer> temp = dummy;
				//initialize carry = 0;
				int carry = 0;
				//we will travel through the linked list while l1 != null or l2 != null or carry ==1
                while(l1 != null || l2 != null || carry ==1 ) {
                	//initialize sum to 0 for every iteration
                	int sum = 0;
                	if(l1 != null) {
                		//if l1 != null then only add l1's data to the sum and increment l1 to the next node
                		sum = sum+l1.data;
                		l1 = l1.next;
                	}
                	if(l2 != null) {
                		sum = sum+l2.data;
                		l2 = l2.next;
                	}
                	//after adding the values of l1 and l2 add carry also if any
                	sum = sum+carry;
                	carry = sum/10;
                	//we will create new node to store the value of summation
                	Node<Integer> node = new Node<>(sum%10);
                	//temp's next will point to this node 
                	temp.next = node;
                	//then we will increment the temp
                	temp = temp.next;
                }
                return dummy.next;
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
		Node<Integer> head = addTwoNum(l1, l2);
		printR(head);

	}

}
