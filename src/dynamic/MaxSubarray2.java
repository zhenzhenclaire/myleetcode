package dynamic;

//53
class MaxSubarray2 {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxVal = nums[0];
        
        for(int i = 1; i < nums.length ;i++){
        	maxVal = Math.max(nums[i], maxVal + nums[i]);
        	maxSum = Math.max(maxSum, maxVal);
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