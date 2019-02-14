package recursion;

// 327
public class RangeSumCount {
	
	public int merge(long[] sums, int lower, int upper, int start, int end){
		if(end < start)	return 0;
		int mid = (start + end) / 2;
		if(start == end)	return (sums[start] >= lower && sums[start] <= upper) ? 1: 0;

		int count = merge(sums, lower, upper, start, mid) + merge(sums, lower, upper, mid + 1, end); 
		
		int m = 0, n = 0;
		for(int i = start;i <= mid;i++){
			m = mid + 1;
			n = mid + 1;
			while(m <= end && sums[m] - sums[i] < lower)  m++;
			while(n <= end && sums[n] - sums[i] <= upper)  n++;
			count += n - m;
		}
		
		long[] temp = new long[end - start + 1];
		int i = start;
		int j = mid + 1;
		int t = 0;
		while(i <= mid && j <= end){
			if(sums[i] > sums[j]){
				temp[t++] = sums[j++];
			}
			else{
				temp[t++] = sums[i++];
			}
		}
		while(i <= mid){
			temp[t++] = sums[i++];
		}
		while(j <= end){
			temp[t++] = sums[j++];
		}
		
		System.arraycopy(temp, 0, sums, start, temp.length);
		
		return count;
	}
 
	public int countRangeSum(int[] nums, int lower, int upper) {
		long[] sums = new long[nums.length];
		if (nums == null || nums.length == 0)
			return 0;
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			sums[i] = sums[i - 1] + nums[i];
		return merge(sums, lower, upper, 0, nums.length - 1);
	}
	
	
	public static void  main(String[] args) {
		
		RangeSumCount rangeSumCount = new RangeSumCount();
		int[] nums = {7, -8, -1, 0};
		System.out.println(rangeSumCount.countRangeSum(nums, -1, 0));
		
		
	}
	
	
}
