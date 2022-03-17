package F_Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//preorder traversal in binary tree
//root-->left-->right

//https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/

public class B_preorder_traversal {
	
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
		

	//preorder traversal using recursion
	public static void helper(BinaryTreeNode<Integer> root, List<Integer> res) {
		if(root == null) return;
		res.add(root.data);
		helper(root.left,res);
		helper(root.right,res);
	}
	public static List<Integer> preorderRecursion(BinaryTreeNode<Integer> root){
		//so main problem with this type of function in recursion which return list or sth is that if we call recursion multiple times it is going to initialize the list every time
		//we have to tackle this problem we can provide help function in which we can pass the root and the list also 
		List<Integer> res = new ArrayList<>();
		helper(root,res);
		return res;
	}
	
	public static List<Integer> preorderIterative(BinaryTreeNode<Integer> root){
		List<Integer> preorder = new ArrayList<Integer>();
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		BinaryTreeNode node = root;
		while(true) {
			if(node != null) {
				preorder.add((Integer) node.data);
				stack.push(node);
				node = node.left;
			}
			else {
				if(stack.isEmpty()) {
					break;
				}else {
					node = stack.pop();
					node = node.right;
				}
			}
		}
		return preorder;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   BinaryTreeNode<Integer> root = takeInputBetter(true, 0, false);
//   System.out.println(preorderRecursion(root));
   System.out.println(preorderIterative(root));
	}

}
