package recursion;

// 23. Merge k Sorted Lists
public class MergeKSortedLists {
	public void printList(ListNode list){
		ListNode temp = list;
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println();
	}
	
	public ListNode mergeList(ListNode left, ListNode right){
		if(left == null && right == null)
			return null;
		if(left == null)	return right;
		if(right == null)	return left;
		
		ListNode leftIndex = left;
		ListNode rightIndex = right;
		ListNode list = null;
		ListNode head = list;
		while(leftIndex != null && rightIndex != null){
			if(leftIndex.val < rightIndex.val){
				if(list == null){
					list = leftIndex;
					head = list;
				}
				else{
					list.next = leftIndex;
					list = list.next;
				}
				leftIndex = leftIndex.next;
				
			}
			else{
				if(list == null){
					list = rightIndex;
					head = list;
				}
				else{
					list.next = rightIndex;
					list = list.next;
				}
				rightIndex = rightIndex.next;
			}
		}
		if(leftIndex != null){
			list.next = leftIndex;
		}
		if(rightIndex != null){
			list.next = rightIndex;
		}
		return head;
	}
	
	public ListNode mergeList1(ListNode left, ListNode right){
		if(left == null && right == null)
			return null;
		if(left == null)	return right;
		if(right == null)	return left;
		
		ListNode leftIndex = left;
		ListNode rightIndex = right;
		ListNode head = new ListNode(0);
		ListNode listNode = head;
		
		while(leftIndex != null && rightIndex != null){
			if(leftIndex.val < rightIndex.val){
				listNode.next = new ListNode(leftIndex.val);;
				leftIndex = leftIndex.next;
			}
			else{
				listNode.next = new ListNode(rightIndex.val);;
				rightIndex = rightIndex.next;				
			}
			listNode = listNode.next;
		}
		
		if(leftIndex != null){
			listNode.next = leftIndex;
		}
		if(rightIndex != null){
			listNode.next = rightIndex;
		}
//		printList(head.next);
		return head.next;
	}
	
	public ListNode merge(ListNode[] lists, int start, int end){
		
		if(start == end){
			return lists[start];
		}
		int mid = (start + end) / 2;
		ListNode left = merge(lists, start, mid);
		ListNode right = merge(lists, mid + 1, end);
		ListNode newlist = mergeList(left, right);
		
		return newlist;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		return merge(lists, 0, lists.length - 1);
    }
	
	//[[1,4,5],[1,3,4],[2,6]]
	public static void main(String[] args){
		
		MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
		ListNode[] lists = new ListNode[3];
		
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(4);
		ListNode node13 = new ListNode(5);
		node11.next = node12;
		node12.next = node13;
		lists[0] = node11;
		
		ListNode node21 = new ListNode(1);
		ListNode node22 = new ListNode(3);
		ListNode node23 = new ListNode(4);
		node21.next = node22;
		node22.next = node23;
		lists[1] = node21;
		
		ListNode node31 = new ListNode(2);
		ListNode node32 = new ListNode(6);
		node31.next = node32;
		lists[2] = node31;
		
		ListNode myNode = mergeKSortedLists.mergeKLists(lists);
		if(myNode == null)	System.out.println("null");
		mergeKSortedLists.printList(myNode);
		
	}
}
