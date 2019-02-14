package dynamic;

//70
public class ClimbStairs {
	
	public int climbStairs(int n) {
		if(n == 0)	return 0;
        int[] methods = new int[n];
        for(int i = 0;i < n;i++){
        	if(i == 0)	methods[i] = 1;
        	else if(i == 1)	methods[i] = 2;
        	else{
        		methods[i] = methods[i - 1] + methods[i - 2];
        	}
        }
        return methods[n - 1];
    }
}
