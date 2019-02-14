package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallerNumbersAfterSelf {
	class Node{
		Node left, right;
		int val;
		int dulNum = 1;
		int leftChild;
		public Node(int val){
			this.val = val;
		}
	}
	
	public Node insertNode(int num, Node node, Integer ans[], int index, int tempSum){
		if(node == null){
			node = new Node(num);
			ans[index] = tempSum;
		}
		else if(node.val == num){
			node.dulNum++;
			ans[index] = node.leftChild + tempSum;
		}
		else if(node.val > num){
			node.leftChild++;
			node.left = insertNode(num, node.left, ans, index, tempSum);
		}
		else{
			node.right = insertNode(num, node.right, ans, index, tempSum + node.dulNum + node.leftChild);
		}
		return node;
	}
	
	public List<Integer> countSmaller(int[] nums) {
		Node root = null;	
		Integer[] ans = new Integer[nums.length];
		for(int i = nums.length - 1; i >= 0;i--){
			root = insertNode(nums[i], root, ans, i, 0);
		}
		return Arrays.asList(ans);
	}
	
	public static void main(String[] args) {
		SmallerNumbersAfterSelf self = new SmallerNumbersAfterSelf();
		int[] nums = {2,0,1};
		ArrayList<Integer> list = (ArrayList<Integer>) self.countSmaller(nums);
		for(Integer integer : list){
			System.out.println(integer);
		}
	}
	
}
