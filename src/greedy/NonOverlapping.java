package greedy;

import java.util.Arrays;
import java.util.Comparator;

import javax.xml.stream.events.EndDocument;

public class NonOverlapping {

	// [ [1,2],[1,2],[1,2]| [2,3], [1,3], [3,4] ]
	// [[1,100],[11,22],[1,11],[2,12]]
	// [1,11] [2,12] [11,22] [1,100]
	public int eraseOverlapIntervals(Interval[] intervals) {
		
		if(intervals.length == 1 || intervals.length == 0)
			return 0;
			
		// Sort array by end index
		Comparator comparator = new MyComparator();
		Arrays.sort(intervals, comparator);

		int i = 0;
		int count = 0;
		int next = 1;
		while (i < intervals.length - 1 && next < intervals.length){
			if(intervals[next].start < intervals[i].end){
				count += 1;
				next += 1;
			}
			else{
				i = next;
				next = i + 1;
			}
		}
		return count;
    }
	
	public static void main(String[] args){
		Interval interval1 = new Interval(1,2);
		Interval interval2 = new Interval(1,2);
		Interval interval3 = new Interval(1,2);
		Interval[] intervals = new Interval[3];
		
		intervals[0] =  interval1;
		intervals[1] =  interval2;
		intervals[2] =  interval3;
	
		NonOverlapping nonOverlapping = new NonOverlapping();
		int count = nonOverlapping.eraseOverlapIntervals(intervals);
		System.out.println(count);
		
	}
}

class MyComparator implements Comparator<Interval>{

	@Override
	public int compare(Interval o1, Interval o2) {
		if(o1.end > o2.end){
			return 1;
		}
		else if(o1.end < o2.end){
			return -1;
		}
		else{
			return 0;
		}
	}	
}
