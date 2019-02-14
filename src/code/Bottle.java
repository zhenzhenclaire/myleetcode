package code;

public class Bottle {
	public int end_state;
	public int full;
	public int state;

	public Bottle(int full, int state,int end_state){
		this.full = full;
		this.state = state;
		this.end_state = end_state;
	}
	
	public static Bottle create(int full,int state,int end_state){
		return new Bottle(full, state, end_state);
	}
}
