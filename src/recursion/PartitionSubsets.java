package recursion;

import java.util.Arrays;

// 698
public class PartitionSubsets {
	public boolean canPartition(int[] nums, int k, int targt, boolean[] isVisited, int currentSum, int index){
		if(currentSum < 0)	return false;
		if(currentSum == targt){
			return canPartition(nums, k - 1, targt, isVisited, 0, 0);
		}
		if(k == 0)	return true;
		
		for(int i = index; i < nums.length;i++){
			if(isVisited[i])	continue;
			else{
				isVisited[i] = true;
				if(canPartition(nums, k, targt, isVisited, currentSum + nums[i], i + 1)){
					return true;
				}
				else{
					isVisited[i] = false;
				}
			}
		}
		return false;
	}
	
	public boolean canPartitionKSubsets(int[] nums, int k) {    
        int sum = 0, avg = 0;
        
        for(int i = 0;i < nums.length;i++){
        	sum += nums[i];
        }
        if(sum % k != 0)	return false;
        avg = sum / k;
        
        boolean[] isVisited = new boolean[nums.length];
        
        return canPartition(nums, k, avg, isVisited, 0, 0);
    }
	
	public boolean canPartitionKSubsets1(int[] nums, int k) {    
        int sum = 0, avg = 0;
        
        for(int i = 0;i < nums.length;i++){
        	sum += nums[i];
        }
        if(sum % k != 0)	return false;
        avg = sum / k;
        
        Arrays.sort(nums);
        int[] orderedNums = new int[nums.length];
        int i = 0;
        
        for(int j = nums.length - 1; j >= 0;j--){
        	orderedNums[i] = nums[j];
        	i++;
        }
        
        int[] buckets = new int[k];
        for(int j = 0; j < k; j++){
        	buckets[j] = avg;
        }
        
        for(int m = 0;m < orderedNums.length;m++){
        	if(orderedNums[m] > avg)	return false;
        	else{
        		boolean hasPut = false;
            	for(int b = 0; b < k; b++){
            		if(buckets[b] < orderedNums[m]){
            			continue;
            		}
            		else{
            			buckets[b] -= orderedNums[m];
            			hasPut = true;
            			break;
            		}
            	}
            	if(!hasPut)	return false;
        	}
        }
        return true;
	}
	
	public static void main(String[] args){
		PartitionSubsets partitionSubsets = new PartitionSubsets();
		// 4 3 2 3 5 2 1
		//[3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269]  5
		int nums[] = new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};
		boolean result = partitionSubsets.canPartitionKSubsets(nums, 5);
		System.out.println(result);
	}
}
