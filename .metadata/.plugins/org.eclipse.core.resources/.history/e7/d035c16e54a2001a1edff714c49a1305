package graph.FindJudgeInTown;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindJudgeInTown {
	
	/* Approach 2 : Indegree and outdegree of graph node
	 * Time Complexity : O(max(N, E)), where E is number of edges
	 * Space Complexity : O(N)
	 */
	public int findJudge_2(int N, int[][] trust){
        if(trust.length == 0 && N == 1){
            return 1;
        }
        int[] degreeDiff = new int[N+1];
        for(int[] x : trust){
            degreeDiff[x[0]]--;
            degreeDiff[x[1]]++;
        }
        for(int i=0; i <=N && trust.length !=0; i++ ){
            if(degreeDiff[i] == N-1){
                return i;
            }
        }
        return -1;
    }
	/* Approach 1 : Graph
	 * Time Complexity : O(E), where E is number of edges
	 * Space Complexity : O(E+V), where V is number of vertex
	 */
	public int findJudge(int N, int[][] trust) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int [] a: trust){
            HashSet<Integer> set = map.get(a[0]);
            if(set == null){
                set = new HashSet<>();
                set.add(a[1]);
                map.put(a[0], set);
            }else{
                set.add(a[1]);
            }
        }
        if(map.size() != N-1){
            return -1;
        }
        int mightBeJudge = 0;
        for(int i=1; i<=N; i++){
            if(map.containsKey(i)){
                continue;
            }else{
                mightBeJudge = i;
                break;
            }
        }
        if(map.containsKey(mightBeJudge)){
            return -1;
        }
        for(Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()){
            if(!entry.getValue().contains(mightBeJudge)){
                return -1;
            }
        }
        return mightBeJudge;
    }
	
}
