package A_Arrays;

public class B_find_duplicate_num_from_unsorted_arr {

//there are lot of approaches to solve this problem
	//1. by running two loops] time-complexity:O(N*N) space-complexity:O(1)
	//2. by sorting the arr and then running only one loop to check the pairs if it is same or not] time- complexity: O(NlogN) space complexity: O(1)
	//3. using set timecomplexity O(N) space complexity O(N)
	//
	
	
	
	 public static int findDuplicate(int[] nums) {
	        int res = 0;
	        for(int i = 0; i<nums.length;i++){
	            int index = Math.abs(nums[i]) -1;
	            if(nums[index] < 0){
	                res = index+1;
	            }
	            else{
	                nums[index] = -nums[index];
	            }
	        } 
	        return res;
	    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		System.out.println(findDuplicate(nums));

	}

}
