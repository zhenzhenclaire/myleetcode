package dynamic;

//53
class MaxSubarray {
    public int maxLength(int[] nums, int start, int end){
        if(start >= end){
            return nums[end];
        }
        
        int center = (start + end) / 2;
        int maxLeft = maxLength(nums, start, center);
        int maxRight = maxLength(nums, center + 1, end);
        
        int maxMiddle = nums[center];
        int sum = maxMiddle;
        for(int i = center - 1; i >= start;i--){
        	sum += nums[i];
        	maxMiddle = Math.max(sum, maxMiddle);
        }
        
        sum = maxMiddle;
        for(int j = center + 1; j <= end; j++){
        	sum += nums[j];
        	maxMiddle = Math.max(sum, maxMiddle);
        }
        
        return Math.max(maxMiddle, Math.max(maxLeft, maxRight));
    }

    public int maxSubArray(int[] nums) {
        int length = nums.length - 1;
        return maxLength(nums, 0, length);
    }

    public static void main(String[] args){
        MaxSubarray max = new MaxSubarray();
        int[] nums = {9, -1 ,-1};
//        int[] nums = {1,2,3,-1,-2,-3};
        
        System.out.println(max.maxSubArray(nums));
    }
}