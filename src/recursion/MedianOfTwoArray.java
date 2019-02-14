package recursion;

import java.util.ArrayList;

//4
public class MedianOfTwoArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        ArrayList<Integer> sorted = new ArrayList<>();
		while(i < nums1.length && j < nums2.length){
			if(nums1[i] >= nums2[j]){
				sorted.add(nums2[j]);
				j++;
			}
			else{
				sorted.add(nums1[i]);
				i++;
			}
		}
		
		while(i < nums1.length){
			sorted.add(nums1[i]);
			i++;
		}
		
		while(j < nums2.length){
			sorted.add(nums2[j]);
			j++;
		}
		
		int total = sorted.size();
		if(total % 2 == 0){
			int a1 = sorted.get(total/2);
			int a2 = sorted.get(total/2 - 1);
			double result = (a1 + a2) / 2.0;
			return result;
		}
		else{
			return sorted.get(total/2);
		}
    }
	
	public static void main(String[] args){
		int nums1[] = new int[]{1,2};
		int nums2[] = new int[]{3, 4};
		MedianOfTwoArray medianOfTwoArray = new MedianOfTwoArray();
		double result = medianOfTwoArray.findMedianSortedArrays(nums1,nums2);
		System.out.println(result);
	}
}
