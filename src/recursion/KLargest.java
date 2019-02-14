package recursion;

import java.util.ArrayList;

// 215
public class KLargest {
	
	public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0;i < nums.length;i++){
        	list.add(nums[i]);
        }
		if(nums.length == 1){
			return nums[0];
		}
		int num = split(list, nums.length + 1 - k);
        return num;
    }
	
	public int split(ArrayList<Integer> list, int topNSmall){
		if(list.size() == 1){
			return list.get(0);
		}
		else{
			int watch = list.get(0);
			ArrayList<Integer> left = new ArrayList<>();
			ArrayList<Integer> right = new ArrayList<>();
			for(int i = 1;i < list.size();i++){
				if(list.get(i) <= watch){
					left.add(list.get(i));
				}
				else{
					right.add(list.get(i));
				}
			}
			int watchLoc = left.size() + 1;
			if(topNSmall < watchLoc){
				return split(left, topNSmall);
			}
			else if(topNSmall == watchLoc){
				return watch;
			}
			else{
				return split(right, topNSmall - watchLoc);
			}
		}	
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
		KLargest largest = new KLargest();
		System.out.println(largest.findKthLargest(nums, 4));
	}
}
