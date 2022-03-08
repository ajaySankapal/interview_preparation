package D_stacks;

import java.util.Stack;

public class A_balanced_parenthesis {

	public static boolean isBalancedParentheses(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(char it : s.toCharArray()) {
			//if there is any open bracked push it into the stack
			if(it=='(' || it=='[' || it=='{') {
				stack.push(it);
			}else {
				//pop brackets from the stack and store it in char ch
				char ch = stack.pop();
				//compare ch to the closing bracket. if it match with its opening bracket continue poping and comparing
				if((it==')' && ch=='(') ||(it==']' && ch=='[') || (it=='}' && ch=='{') ) continue;
				//if it does'nt match with bracket return false;
				else return false;
				}
		}
		//at last if the stack is empty means all the opening bracket has its closing bracket return true; if it is not empty return false;
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
//		String s = "()[]{}";
		String  s = "(]";
		System.out.println(isBalancedParentheses(s));

	}

}
