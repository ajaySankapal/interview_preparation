package A_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G_merge_overlapping_intervals {

	public static int[][] mergeIntevals(int[][] intervals){
		List<int[]> res = new ArrayList<>();
		int[] newInterval = intervals[0];
		res.add(newInterval);
		if(intervals.length<=1) return intervals;
		//sort the intervals on the basis of their start time
		Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
		
		for(int[] interval:intervals) {
			if(interval[0]<=newInterval[1]) {
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}else {
				newInterval = interval;
				res.add(newInterval);
			}
		}
		
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
