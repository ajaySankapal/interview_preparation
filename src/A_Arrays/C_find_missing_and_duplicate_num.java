package A_Arrays;

import java.util.Arrays;

public class C_find_missing_and_duplicate_num {

	public static int[] findPair(int[] nums) {
		int[] outputArr = new int[2];
		Arrays.sort(nums);
		for(int i = 0; i<nums.length;i++) {
			if(nums[i]==nums[i+1]) {
				outputArr[0] = nums[i];
			}
			if(i+1 != nums[i]) {
				outputArr[1] = i+1;
			}
		}
    return outputArr;
	}
	
	public static int[] findMissingAndDuplicate(int[] nums) {
		int[] outputArr = new int[2];
		for(int i = 0;i<nums.length;i++) {
			int index = Math.abs(nums[i]) -1;
			if(nums[index]<0) {
				outputArr[0] = index+1;
			}else {
				nums[index] = -nums[index];
			}
		}
		for(int i = 0;i<nums.length;i++) {
			if(nums[i]>0) {
				outputArr[1] = i+1;
			}
		}
		
		return outputArr;
	}
	
	public static void main(String[] args) {
		int nums[] = {7,3,4,5,5,6,2};
        int ans[] = findMissingAndDuplicate(nums);
        for(int i = 0;i<ans.length;i++) {
        	System.out.print(ans[i]+" ");
        }
	}

}
