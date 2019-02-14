package code;

import java.util.ArrayList;

public class BucketState {
	
	public boolean[][][] is_visited = new boolean[100][100][100];
	public BucketState parent;
	public int step;
	public ArrayList<Bottle> bottles;
	//0-8L;1-5L;2-3L
	
	public BucketState(){
		bottles = new ArrayList<>();
	}
}
