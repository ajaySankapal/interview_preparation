package A_Arrays;

import java.util.ArrayList;
import java.util.List;

public class A_find_all_duplicates {

	public static List<Integer> findAllDuplicates(int[] a){
		List<Integer> outputArr = new ArrayList<>();
		for(int i = 0; i<a.length;i++) {
			int index = Math.abs(a[i]) -1;
			if(a[index] < 0) {
				outputArr.add(index+1);
			}else {
				a[index] = -a[index];
			}
		}
		
		
		return outputArr;
	}
	public static void main(String[] args) {
		int[] a = {4,3,2,7,8,2,3,1};
		 System.out.println(findAllDuplicates(a));

	}

}
