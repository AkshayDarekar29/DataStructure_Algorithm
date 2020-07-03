package backtracking.CombinationSum;

import java.util.ArrayList;
 import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> list = new ArrayList<>();
        combinationSum2(candidates, 0, target, new ArrayList<Integer>(), list);
        return list;
    }
    
    public void combinationSum2(int[] candidates, int start, int target, List<Integer> l, List<List<Integer>> list) {
        if(target < 0){
            return;
        }
        if(l.size() > 0 && target == 0 ){
              list.add(new ArrayList<>(l));
        }else{
            for(int i = start; i < candidates.length; i++){
                l.add((Integer)candidates[i]);
                if(target-candidates[i] >= 0){
                    combinationSum2(candidates, i, target-candidates[i], l, list);
                }
                l.remove((Integer)candidates[i]);
            }
        }
    }
}
