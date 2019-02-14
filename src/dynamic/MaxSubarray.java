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
        return Math.max(maxLeft, maxRight);
    }

    public int maxSubArray(int[] nums) {
        int length = nums.length - 1;
        return maxLength(nums, 0, length);
    }

    public static void main(String[] args){
        MaxSubarray max = new MaxSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        System.out.println(max.maxSubArray(nums));
    }
}