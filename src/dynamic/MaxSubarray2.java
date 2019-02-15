package dynamic;

//53
class MaxSubarray2 {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxValEndingWithI = nums[0];
        
        for(int i = 1; i < nums.length ;i++){
        	// Calculate temporary max sum ending with a[i]. 
        	// This sub-array either starts from i (restart), or starts from nowhere but needs to adding a[i]
        	maxValEndingWithI = Math.max(nums[i], maxValEndingWithI + nums[i]);
        	
        	// Compare the max between adding a[i] or not.
        	maxSum = Math.max(maxSum, maxValEndingWithI);
        }
        return maxSum;
    }

    public static void main(String[] args){
        MaxSubarray2 max = new MaxSubarray2();
        int[] nums = {9, -1 ,-1};
//        int[] nums = {1,2,3,-1,-2,-3};
        
        System.out.println(max.maxSubArray(nums));
    }
}