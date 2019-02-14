package recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

// 169
public class Majority {
	public int majorityElement1(int[] nums) {
        HashMap<Integer,Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
        	if(numMap.get(nums[i]) == null){
        		numMap.put(nums[i], 1);
        	}
        	else{
        		numMap.put(nums[i], numMap.get(nums[i]) + 1);
        	}
        }
        
        int majorityCount = nums.length / 2;
        for(Map.Entry<Integer,Integer> entry: numMap.entrySet()){
        	if(entry.getValue() > majorityCount){
        		return entry.getKey();
        	}
        }
		return 0;
    }
	
	public int majorityElement(int[] nums) {
		int majority = Integer.MAX_VALUE;
		int count = 0;
		for(int i = 0;i < nums.length;i++){
			if(count == 0){
				majority = nums[i];
				count++;
			}
			else{
				if(nums[i] == majority){
					count++;
				}
				else{
					count--;
				}
			}
		}
		return majority;
	}
}

