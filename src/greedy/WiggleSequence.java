package greedy;

import java.util.ArrayList;

public class WiggleSequence {
	class Sequence {
		int val;
		int character;
		
		public Sequence(int val,int character){
			this.val = val;
			this.character = character;
		}
	}
	
	public int getDiff(int val1, int val2){
		if(val1 == val2)	return 0;
		else if(val1 > val2)	return -1;
		else	return 1;
	}
	
	public int getLastVal(ArrayList<Sequence> sequences){
		return sequences.get(sequences.size() - 1).val;
	}
	
	public int getLastChar(ArrayList<Sequence> sequences){
		return sequences.get(sequences.size() - 1).character;
	}
	
	public boolean isRemoveCurrent(int currentChar, int last, int current){
		if(currentChar < 0){
			// if is negative, keep the smaller one
			return ((last < current) ? true : false); 
		}
		else{
			// if is postive, keep the larger one
			return ((last > current) ? true : false); 
		}
	}
	
	public int wiggleMaxLength1(int[] nums) {
        ArrayList<Sequence> sequences = new ArrayList<>();
        
        if(nums.length <= 1)	return nums.length;
        else if(nums.length == 2){
        	int diff = getDiff(nums[0], nums[1]);
            if(diff == 0)	return 1;
            else	return 2;
        }
        else{
        	int firstDiff = getDiff(nums[1], nums[0]);
        	sequences.add(new Sequence(nums[0], firstDiff));
        
	        for(int i = 1; i < nums.length ;i++){
	        	int lastVal = getLastVal(sequences);
	        	int lastChar = getLastChar(sequences);
	        	int currentVal = nums[i];
	        	int currentChar = getDiff(lastVal, currentVal);
	
	        	if(currentChar == 0){
	        		continue;
	        	}
	        	else{
	        		if(currentChar * lastChar == 0){
	        			sequences.add(new Sequence(nums[i], currentChar));
	        		}
	        		else if(currentChar * lastChar < 0){
		        		sequences.add(new Sequence(nums[i], currentChar));
		        	}
		        	else{
		        		if(isRemoveCurrent(currentChar, lastVal, currentVal)){
		        			continue;
		        		}
		        		else{
		        			sequences.remove(sequences.size() - 1);
		        			sequences.add(new Sequence(currentVal, currentChar));
		        		}
		        	}
	        	}
	        }
        }
        return sequences.size();
    }
	
	public int wiggleMaxLength(int[] nums) {
		int[] upList = new int[nums.length];
		int[] downList = new int[nums.length];
		
		if(nums.length <= 1)	return nums.length;
		
		upList[0] = 1;
		downList[0] = 1;
		
		for(int i = 1;i < nums.length;i++){
			if(nums[i] - nums[i - 1] > 0){
				upList[i] = downList[i - 1] + 1;
				downList[i] = downList[i - 1];
			}
			else if (nums[i] - nums[i - 1] < 0){
				upList[i] = upList[i - 1];
				downList[i] = upList[i - 1] + 1;
			}
			else{
				upList[i] = upList[i - 1];
				downList[i] = downList[i - 1];
			}	
		}
		return (upList[nums.length-1] > downList[nums.length-1]) ? 
				upList[nums.length-1] :downList[nums.length-1];
	}
}
