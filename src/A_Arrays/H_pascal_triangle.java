package A_Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://leetcode.com/problems/pascals-triangle/

public class H_pascal_triangle {

	//        1
	//       1 1
	//      1 2 1
	//     1 3 3 1
	//   1 4 6  4 1
	
	
	public static List<List<Integer>> generatePascalTri(int numRows){
		//list of list storing all the list
		List<List<Integer>> result = new ArrayList<>();
		
		//current row which will store the elements of every row
		List<Integer> row = new ArrayList<Integer>();
		
		//for loop to iterate through the rows
		for(int i = 0; i<numRows;i++) {
			//initially add 1 to leftmost
			//the prev row is also copied here
			//we just add 1 to its leftmost
           //for 3rd iteration the row is 1 1
			//we add 1 to its left most			
			row.add(0,1);
			//loop to iterate through the columns and set its elements. we alter the second column in the row because first and last always set  to "1"
			for(int j = 1; j<row.size()-1;j++) { //we have to run this loop less than rowsize-1 because we don't have to change the value of last column
				//update the columns value by adding in it the next column value 
				//1 1 1 the row is this.
				// start from second column and update till second last
				//update is just add in the current columns value the next column value
				row.set(j,row.get(j)+row.get(j+1) );
			}
			//we are making the rows copy and add it to the list. if we don't do this it will alter all the n rows and after going through all the loops the altered row will be added to the list (result)
//			result.add(row);   //[[1, 4, 6, 4, 1], [1, 4, 6, 4, 1], [1, 4, 6, 4, 1], [1, 4, 6, 4, 1], [1, 4, 6, 4, 1]]
		    result.add(new ArrayList<>(row));
		}
		
		//we are getting this result after the for loop if we dont make a copy of the row and add it to the result list it will get altered during the for loop iteration and at last after finishing the for loops we will get the altered row. which is not the correct ans
		return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter no of rows n: ");
		int n = s.nextInt();
		System.out.println(generatePascalTri(n));
	}

}
