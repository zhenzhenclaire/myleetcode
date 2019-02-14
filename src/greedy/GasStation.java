package greedy;

public class GasStation {
//	http://www.cnblogs.com/boring09/p/4248482.html
	public int next(int index, int length){
		int next = index + 1;
		return (next == length) ? 0: next;
	}
	
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		for(int start = 0; start < gas.length; start++){
			if(gas[start] < cost[start])	continue;
			int current = start;
			int tank = 0;
			while(current < gas.length){
				tank += gas[current] - cost[current];
				if(tank < 0)
					break;
				else{
					current = next(current, gas.length);
				}
				if(current == start){
					return start;
				}
			}
		}
		return -1;
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0;
		int currentSum = 0;
		int index = 0;
		for(int i = 0; i < gas.length;i++){
			currentSum += gas[i] - cost[i];
			if(currentSum < 0){
				index = i + 1;
				currentSum = 0;
			}
			total += gas[i] - cost[i];
		}
		return (total > 0) ? index: -1;
	}
}
