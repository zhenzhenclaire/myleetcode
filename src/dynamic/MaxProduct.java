package dynamic;

// 152
public class MaxProduct {
	
	public int maxProduct(int[] nums) {
		int maxValEndWithI = nums[0];
		int minValEndWithI = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1;i < nums.length;i++){
        	int a = 0;
        	int b = 0;
        	a = maxValEndWithI * nums[i];
        	b = minValEndWithI * nums[i];
        	
        	maxValEndWithI = Math.max(b, Math.max(a, nums[i]));
        	minValEndWithI = Math.min(a, Math.min(nums[i], b));
        			
        	maxSum = Math.max(maxSum, maxValEndWithI);
        }
        return maxSum;
    }
	
	public static void main(String[] args){
		MaxProduct maxProduct = new MaxProduct();
		int[] nums = {2, 3, -2, 4};
		System.out.println(maxProduct.maxProduct(nums));
	}
	
	
}
