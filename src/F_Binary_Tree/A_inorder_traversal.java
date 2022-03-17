package F_Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


//inorder traversal in binary tree
// left-->root-->right

//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/

public class A_inorder_traversal {
	
	//takeInputBetter in preorder form
			public static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot,int parentData,boolean isleft){
				
			if(isRoot) {
				System.out.println("Enter root data:");
			}
			else {
				if(isleft) {
					System.out.println("enter left child of:"+parentData);
				}else {
					System.out.println("enter right child of:"+parentData);
				}
			}
			
			
			Scanner s = new Scanner(System.in);
			int rootData = s.nextInt();
			if(rootData == -1) {
				return null;
			}
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
			BinaryTreeNode<Integer> leftChild = takeInputBetter(false,rootData,true);
			BinaryTreeNode<Integer> rightChild = takeInputBetter(false,rootData,false);
			root.left = leftChild;
			root.right = rightChild;
			return root;
			}
		
			
			//in order traversal using recursion
			public static void inorder(BinaryTreeNode<Integer> root) {
				if(root == null) return;
				inorder(root.left);
				System.out.print(root.data+" ");
				inorder(root.right);
			}
			
			
			//inorder traversal using iteration
			
		   //so what we are doing in the recursion is that we are travesing the tree's left and right part and printing the last node of the leftORRight subtree while keeping track of the prev nodes
			//the track is achieved by using the recursions call stack
			// we can also achieve this track by using the stack data structure
			
			//the approach is
			//1. check if the nodes is null or not
			//2. if the node is *not null* "push the node to the stack"
			     //I. if the node is *not null* -->push the node to the stack and move to node's left and if the node's left is also not null push it also to the stack and move to node's right
			     //II.if the node is *null* --> check if the stack is not empty and print nodes data.(in our case add it to the list)
			
			public static List<Integer> inorderIterative(BinaryTreeNode<Integer> root) {
				Stack<BinaryTreeNode<Integer>> stkI = new Stack<BinaryTreeNode<Integer>>();
				List<Integer> inorder = new ArrayList<Integer>();
				BinaryTreeNode<Integer> node = root;
				while(true) {
					if(node != null) {
						stkI.push(node);
						node = node.left;
					}else {
						if(stkI.isEmpty()) {
							break;
						}
						node = stkI.pop();
						inorder.add((Integer) node.data);
						node = node.right;
					}
					
					
					
				}
				return inorder;
			}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<Integer> root = takeInputBetter(true,0,false);
		
		//inorder output using recursion
		inorder(root);
		
		//inorder output using iteration
		System.out.println(inorderIterative(root));

	}

}
