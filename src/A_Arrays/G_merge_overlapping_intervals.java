package A_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-intervals/
//merge overlapping intervals
//i/p : [[1,3],[2,6],[8,10],[15,18]]
//o/p : [[1,6],[8,10],[15,18]]
// an interval is said to be overlapped if the second intervals start time is less than the end time of the first interval 
// in case of these interval [1,3],[2,6] second intervals start time "2" is less than the end time of the first interval "3" so this interval is said to be overlapped
// to merge these overlapping interval we have to check the max of both the intervals end time and swap the new intervals end time with the max
//sorting takes O(NlogN) and merge takes O(N) time-complexity:O(NlogN)


public class G_merge_overlapping_intervals {

	public static int[][] mergeIntevals(int[][] intervals){
		
		//we don't know how many of such intervals are there in the final output so we store the intervals in the list. which contains the intervals(1d array) as elements
		List<int[]> res = new ArrayList<>();
		// define a temporary array which will store the intervals(it will store only one interval as it is a 1d array. we will update it later based on the conditions we want)
		
		//we initially store the first interval in our temp newInterval
		int[] newInterval = intervals[0];
		
		//add these newInterval to the list as first interval will always be in our ans
		res.add(newInterval);
		
		//we have been given empty array we simply return that array
		if(intervals.length<=1) return intervals;
		//sort the intervals on the basis of their start time
		
		//this algo only based on the fact if the array is sorted or not 
		// so we sort the array on the basis of their start time
		Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
		
		//for each loop to iterate through the intervals
		for(int[] interval:intervals) {
			
			// here we check if the start of the second interval is less than or equal to end of the first interval.
			// if the condition is true it means there is overlapping between these intervals
			if(interval[0]<=newInterval[1]) { //overlapping
				
				//if there is overlapping we need to update the newIntervals end time with max of the intervals end time
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}else {//no overlapping
				//if the condition is not true it means there is no overlapping 
				// in that case the interval itself is our newInterval so we update the newInterval with that interval and add it to our res list
				newInterval = interval;
				res.add(newInterval);
			}
		}
		
		//we have been asked to return the array so we convert the list to array
		return res.toArray(new int[res.size()][2]);
	}
	
	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] mergedArr = mergeIntevals(intervals);
        for(int i = 0; i<mergedArr.length;i++) {
        	for(int j = 0; j<mergedArr[0].length;j++) {
        		System.out.print(mergedArr[i][j]+"  ");
        	}
        	System.out.print("| ");
        }
	}

}
