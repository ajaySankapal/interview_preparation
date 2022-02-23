package A_Arrays;

public class J_search_in_a_2d_matrix {

	//Integers in each row are sorted from left to right.
//	The first integer of each row is greater than the last integer of the previous row.
	//by reading the problem statement we can conclude that we can consider the whole matrix as one sorted array
	//in this array we can perform binary search which will find the target in O(NlogN) time
	
	public static boolean searchIn2dMatrix(int[][] matrix,int target) {
		
		//to iterate through the one sorted array we need low and high index
		
		int row = matrix.length;
		int col = matrix[0].length;
		//low index is at 0;
		int low = 0;
		//the high index will be at row*col -1 
		int high = (row*col)-1;
		
		//iterate through the list till low is less than equal to high
		while(low<=high) {
			int mid = (low+(high-low)/2);
			
			//we check the mid element with the target if it is equal or not
			//we can get the index of mid element of 1d array but we have to compare it with the element of matrix(2d array) 
			//for this we find the index of the matrix element by mid/col and mid%col
			if(matrix[mid/col][mid%col]==target) {
				return true;
			}
			else if(matrix[mid/col][mid%col]<target) {
				//if the element at the matrix index is less than target. we update low to mid+1(our target can be found in the left interval)
				low = mid+1;
			}else {
				high = mid -1;
			}
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] matrix =  {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 62;
		System.out.println(searchIn2dMatrix(matrix,target));

	}

}
