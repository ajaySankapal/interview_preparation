package A_Arrays;

public class E_kadanes_algorithm {

	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = 0;
		for(int i = 0; i<nums.length;i++) {
			sum = sum+nums[i];
			if(sum>max) {
				max = sum;
			}
			if(sum<0) {
				sum = 0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		//-2,1,-3,4,-1,2,1,-5,4
		//1,2,3,-2,5
		//5,4,-1,7,8
		int nums[] = {1,2,3,-2,5};
         System.out.println(maxSubArray(nums));
	}

}
