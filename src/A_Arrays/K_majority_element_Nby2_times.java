package A_Arrays;

//https://leetcode.com/problems/majority-element/

//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

//Input: nums = [2,2,1,1,1,2,2]
//Output: 2


public class K_majority_element_Nby2_times {

	//approach*1 : running two loops
	//take one element of the array and traverse the whole and to check of the remaining array consist this element or not if it consist increase count by 1 .
	// at last if the count is >n/2 return the element whose count is this
	//time-complexity: O(N*N) 
	//space-complexiy: O(1)
	public static int majorityElement(int[] nums) {
		int maxCount = 0;
		int index = -1;
		for(int i = 0; i<nums.length;i++) {
			int count = 0;
			for(int j = 0; j<nums.length;j++) {
				if(nums[i]==nums[j]) count++;
			}
			if(count>maxCount) {
				maxCount = count;
				index = i;
			}
			if(maxCount>nums.length/2) return nums[index];
		}
		return -1;
	}
	
	//approach2* using hashmap. map contains the number and its frequency if any numbers frequency is greater than n/2 return that number
	
	
	//approach3* using "Boyre Moore majority vote algorithm"
	//it is based on the fact that majority element is the elements which is appeared n/2 times it means all the other elements are not majority element
	 public static int majorityElementMoore(int[] nums) {
	        int counter = 1;
	        int candidate = nums[0];
	        for(int i = 1; i<nums.length;i++){
	            if(counter == 0){
	                candidate = nums[i];
	            }
	            if( nums[i] == candidate){
	                counter++;
	            }else{
	                counter--;
	            }
	        }
	        if(counter>0) {
	        	return candidate; 
	        }
	       return -1;
	 }
	
	public static void main(String[] args) {
		
		int[] nums = {3, 3, 4, 2, 4, 4, 2, 4};
//		int[] nums = {1,2,3,2,4,5};
//		System.out.println(majorityElement(nums));
		System.out.println(majorityElementMoore(nums));
	}

}
