package code;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PourWater {
	public static final int EMPTY = 0;
	
	private boolean[][][] is_visited;
	
	public PourWater(){
		is_visited = new boolean[100][100][100];
	}
	
	public boolean[][][] copy(boolean[][][] parentvisitor){
		boolean[][][] result = new boolean[100][100][100];
		for(int i = 0;i < 100;i++){
			for(int j = 0;j<100;j++){
				for(int k = 0;k<100;k++){
					result[i][j][k] = parentvisitor[i][j][k];
				}
			}
		}
		return result;
	}
	
	
	private boolean is_finished(BucketState backet_state){
		boolean finished = true;
		for(Bottle bottle: backet_state.bottles){
			if(bottle.state != bottle.end_state){
				finished =  false;
			}
		}
		return finished;
	}
	
	private BucketState pour_water(int from, int to, BucketState backet_state){
//		System.out.println(backet_state.bottles.get(from).full+":"+backet_state.bottles.get(from).state + "->" + backet_state.bottles.get(to).full+":"+backet_state.bottles.get(to).state);
		
		BucketState new_state = new BucketState();
		for(int index = 0;index < backet_state.bottles.size();index++){
			Bottle bottle = backet_state.bottles.get(index);
			if(index == from){
				int water_flow = backet_state.bottles.get(to).full - backet_state.bottles.get(to).state;
				
				if(water_flow < backet_state.bottles.get(from).state){
//					System.out.println("Pour " + water_flow + " water");
					new_state.bottles.add(Bottle.create(bottle.full, bottle.state - water_flow, bottle.end_state));
				}
				else{
//					System.out.println("Pour all water");
					new_state.bottles.add(Bottle.create(bottle.full, 0, bottle.end_state));
				}
			}else if(index == to){
				int water_flow = backet_state.bottles.get(to).full - backet_state.bottles.get(to).state;
				
				if(water_flow < backet_state.bottles.get(from).state){
//					System.out.println("Pour " + water_flow + " water");
					new_state.bottles.add(Bottle.create(bottle.full, bottle.state + water_flow, bottle.end_state));
				}
				else{
//					System.out.println("Pour all water");
					new_state.bottles.add(Bottle.create(bottle.full, bottle.state+backet_state.bottles.get(from).state, bottle.end_state));
				}
			}else{
				new_state.bottles.add(Bottle.create(bottle.full, bottle.state, bottle.end_state));
			}
		}
		return new_state;
	}
	
	private int BFS(BucketState initial){
//		Queue<BucketState> queue = new LinkedList<BucketState>();
		ArrayList<BucketState> queue = new ArrayList<>();
		queue.add(initial);
		
		initial.is_visited[initial.bottles.get(0).state][initial.bottles.get(1).state][initial.bottles.get(2).state] = true;
		
		while(!queue.isEmpty()){
			System.out.println("------------------------------------------------------------");
			 BucketState first_state_in_queue = queue.remove(0);
			 System.out.print("step:"+first_state_in_queue.step+"-->");
			for(int index = 0; index < 3; index++){
				System.out.print(first_state_in_queue.bottles.get(index).full+":"+first_state_in_queue.bottles.get(index).state + " ");
			}
			System.out.println();
			
			if(is_finished(first_state_in_queue)){
				BucketState state = first_state_in_queue;
				ArrayList<String> results = new ArrayList<String>();
				while(state != null){
					results.add(0,"["+state.bottles.get(0).state+","+state.bottles.get(1).state+","+state.bottles.get(2).state+"]");
					state = state.parent;
				}
				System.out.println("******************"+first_state_in_queue.step+"************************");
				for(String str: results){
					System.out.println(str);
				}
				System.out.println("******************************************");
//				return first_state_in_queue.step;
			}
			for(int from = 0;from < first_state_in_queue.bottles.size(); from++){
				for(int to = 0; to < first_state_in_queue.bottles.size(); to++){
					if(from != to && first_state_in_queue.bottles.get(from).state != 0 
							&& first_state_in_queue.bottles.get(to).state <= 
							first_state_in_queue.bottles.get(to).full){
						
						BucketState new_state = pour_water(from, to, first_state_in_queue);
						new_state.parent = first_state_in_queue;
						new_state.step = first_state_in_queue.step+1;
						
						if(!first_state_in_queue.is_visited[new_state.bottles.get(0).state][new_state.bottles.get(1).state][new_state.bottles.get(2).state]){
							boolean[][][] isvis = copy(first_state_in_queue.is_visited);
							isvis[new_state.bottles.get(0).state][new_state.bottles.get(1).state][new_state.bottles.get(2).state] = true;
							new_state.is_visited = isvis;
							queue.add(new_state);
						}
					}
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args){
		
		BucketState initial = new BucketState();
		initial.bottles.add(Bottle.create(8, 8, 4));
		initial.bottles.add(Bottle.create(5, 0, 4));
		initial.bottles.add(Bottle.create(3, 0, 0));
		initial.step = 0;
		
		PourWater test = new PourWater();
		
		int step = test.BFS(initial);
		System.out.println(step);
		
	}
}
