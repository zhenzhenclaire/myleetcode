package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//315
public class SmallerNumbersAfterSelf1 {
	public void merge(Location[] nums, int start, int end){
		Location[] temp = new Location[end - start + 1];
		int i = start;
		int mid = (start + end) / 2;
		int j = mid + 1;
		int t = 0;
		while(i <= mid && j <= end){
			if(nums[i].num > nums[j].num){
				temp[t++] = nums[j++];
			}
			else{
				temp[t++] = nums[i++]; 
			}
		}
		while(i <= mid){
			temp[t++] = nums[i++];
		}
		while(j <= end){
			temp[t++] = nums[j++];
		}
		
		System.arraycopy(temp, 0, nums, start, temp.length);
	}
	
	public void countSegment(Location[] nums, int start, int end, int[] map){
		if(start == end)	return;
		
		int mid = (start + end) / 2;
		countSegment(nums, start, mid, map);
		countSegment(nums, mid + 1, end, map);
		

		for(int i = start; i <= mid; i++){
			int m = mid + 1;
			while(m <= end && nums[m].num < nums[i].num) m++;
			map[nums[i].index] += m - mid - 1;
		}
		merge(nums,start, end);
	}
	
	public List<Integer> countSmaller(int[] nums) {
		ArrayList<Integer> list = new ArrayList<>();
		if(nums == null || nums.length == 0)	return list;
		Location[] num = new Location[nums.length];
		for(int i = 0; i < nums.length;i++){
			Location l = new Location(nums[i], i);
			num[i] = l;
		}
		
		int[] map = new int[nums.length];
		
		countSegment(num, 0, nums.length - 1, map);
		for(int i = 0;i < map.length;i++){
			list.add(map[i]);
		}
		return list;
    }
	
	public static void main(String[] args) {
		SmallerNumbersAfterSelf1 self = new SmallerNumbersAfterSelf1();
		int[] nums = {2,5,1,1};
		ArrayList<Integer> list = (ArrayList<Integer>) self.countSmaller(nums);
		for(Integer integer : list){
			System.out.println(integer);
		}
	}
}
