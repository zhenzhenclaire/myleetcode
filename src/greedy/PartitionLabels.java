package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels1(String S) {

        ArrayList<Integer> subStringList = new ArrayList<Integer>();

        HashMap<String, Integer> lastIndex = new HashMap<String,Integer>();
        int start = 0;
        int end = S.length() - 1;
        for(int j = S.length() - 1; j >= start;j--){
        	// Add character to map.
            if(lastIndex.get(S.charAt(j) + "") == null){
                lastIndex.put(S.charAt(j) + "", j);
            }
            // If has same character, sub string.
            if(S.charAt(j) == S.charAt(start)){
                end = j;
                int i = start + 1;
                while(i < end){
                    if(lastIndex.get(S.charAt(i) + "") == null){
                        i++;
                        continue;
                    }
                    else if(lastIndex.get(S.charAt(i) + "") > end){
                        end = lastIndex.get(S.charAt(i) + "");
                    }
                    i++;
                }
                subStringList.add(end + 1 - start);
                start = end + 1;

                end = S.length() - 1;
                j = S.length() ;
            // If has no same character, add this character to result
            }else if(j == start){
                subStringList.add(1);
                start += 1;
                end = S.length() - 1;
                j = S.length();
            }
            
            // If finish, end the process.
            if(start >= S.length()){
                return subStringList;
            }
        }
        return subStringList;
    }
    
    public List<Integer> partitionLabels(String S) {
    	ArrayList<Integer> subStringList = new ArrayList<Integer>();
        HashMap<String, Integer> lastIndex = new HashMap<String,Integer>();
        
        for(int i = S.length() - 1;i >= 0;i--){
        	if(lastIndex.get(S.charAt(i) + "") == null){
        		lastIndex.put(S.charAt(i) + "", i);
        	}
        }
        
        int start = 0;
        int end = 0;
        int currentLastIndex = 0;
        for(int i = 0;i < S.length();i++){
        	currentLastIndex = lastIndex.get(S.charAt(i) + "");
        	end = (end > currentLastIndex) ? end: currentLastIndex;
        	if(i == end){
        		subStringList.add(end + 1 - start);
        		start = end + 1;
        	}
        }
        return subStringList;
        
    }


    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }
}