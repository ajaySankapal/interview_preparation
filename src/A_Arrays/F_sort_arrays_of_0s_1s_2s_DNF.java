package A_Arrays;

public class F_sort_arrays_of_0s_1s_2s_DNF {

	public static int[] sortByDNF(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length-1;
		int temp;
		while(mid<=high) {
			switch(nums[mid]) {
			case 0:
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
				break;
			}
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		int nums[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sortByDNF(nums);
        for(int i = 0; i<nums.length;i++) {
        	System.out.print(nums[i]+" ");
        }
	}

}
