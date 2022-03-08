package A_Arrays;

import java.util.ArrayList;
import java.util.List;

public class L_majority_elementsII_Nby3_times {

	//approach1* run to for loops, take one element and compare it with all the elements and mark its count if the count is greater than n/3 put it in the ans array
	//at last return that array
	
	public static List<Integer> majorityElement2(int[] nums){
		List<Integer> majorityElements = new ArrayList<>();
		
		for(int i = 0; i<nums.length;i++) {
			int count = 0;
			for(int j = i+1;j<nums.length;j++) {	
				if(nums[i]==nums[j]) {
					count++;
					
				}
				
				
			}
			if(count>(nums.length/3)) {
				majorityElements.add(nums[i]);
			}
//			System.out.println(count);
		}
		
		return majorityElements;
	}
	
	//boyre moore majority vote algorithm
	 public static List<Integer> majorityElementMoore(int[] nums) {
	        int counter1 = 0;
	        int counter2 = 0;
	        int num1 = -1;
	        int num2 = -1;
	        int len = nums.length;
	        for(int i = 0; i<len;i++){
	           if(nums[i]==num1) {
	        	   counter1++;
	           }else if(nums[i]==num2) {
	        	   counter2++;
	           }else if(counter1 == 0) {
	        	   num1 = nums[i];
	        	   counter1 = 1;
	           }else if(counter2 == 0) {
	        	   num2 = nums[i];
	           }else {
	        	   counter1--;
	        	   counter2--;
	           }
	        }
	       List<Integer> result = new ArrayList<>();
	       int count1 = 0;
	       int count2 = 0;
	       for(int i = 0; i<len;i++) {
	    	   if(nums[i]==num1) {
	    		   count1++;
	    	   }else if(nums[i]==num2) {
	    		   count2++;
	    	   }
	    	   
	       }
	       if(count1>len/3) {
    		   result.add(num1);
    	   }
    	   if(count2>len/3) {
    		   result.add(num2);
    	   }
	       return result;
	    }
	
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3,3,3}; //n=8| n/3 = 2 | number appears greater than 2times is 1 and 3
//       System.out.println(majorityElement2(nums));
       System.out.println(majorityElementMoore(nums));
	}

}
