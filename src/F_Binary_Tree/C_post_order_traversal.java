package F_Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//postorder: left-->right-->root
//https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/

public class C_post_order_traversal {
	
	//takeInputBetter
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
		
			
			//postorder traversal using recursion
			public static void helper(BinaryTreeNode<Integer> root, List<Integer> res) {
				if(root == null) return;
				helper(root.left,res);
				helper(root.right,res);
				res.add(root.data);
			}
			public static List<Integer> postorderRecursion(BinaryTreeNode<Integer> root){
				List<Integer> res = new ArrayList<Integer>();
				helper(root,res);
				return res;
				
			}
			
			//post orderr using iterative method
			public static List<Integer> postorderIterative(BinaryTreeNode<Integer> root) {
				Stack<BinaryTreeNode<Integer>> stkI = new Stack<BinaryTreeNode<Integer>>();
				List<Integer> postorder = new ArrayList<Integer>();
				BinaryTreeNode<Integer> temp;
				BinaryTreeNode<Integer> node = root;
				while(node != null || !stkI.isEmpty()) {
					if(node != null) {
						stkI.push(node);
						node = node.left;
					}else {
						temp = stkI.peek().right;
					    if(temp==null) {
					    	temp = stkI.peek();
					    	stkI.pop();
					    	postorder.add(temp.data);
					    	while(!stkI.isEmpty() && temp == stkI.peek().right) {
					    		temp = stkI.peek();
					    		stkI.pop();
					    		postorder.add(temp.data);
					    	}
					    }else {
					    	node = temp;
					    }
					}	
				}
				return postorder;
			}
            
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputBetter(true,0,false);
//		System.out.println(postorderRecursion(root));
		System.out.println(postorderIterative(root));

	}

}
