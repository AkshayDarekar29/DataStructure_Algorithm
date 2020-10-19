package dp.smallestSequenceWithGivenPrimes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

import tree.TreeNode;

public class SmallestSequenceWithGivenPrimes {
	
	/*Approach 1 : Using TreeSet
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) , where is n is number of nodes
	*/
	public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> res = new ArrayList<>();
       TreeSet<Integer> set = new TreeSet<>();
       set.add(A);
       set.add(B);
       set.add(C);
       while(res.size() != D){
           int n = set.pollFirst();
           res.add(n);
           set.add(n*A);
           set.add(n*B);
           set.add(n*C);
       }
        return res;
    }
	
	/*Approach 2 : Without using extra space
	 * Time Complexity: O(n)
	 * Space Complexity: O(1) , where is n is number of nodes
	*/
	public ArrayList<Integer> solve_2(int A, int B, int C, int D) {
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        int a,b,c;
        a = b = c = 0;
        
        for(int i=0; i<D; i++) {
            int mA = res.get(a)*A;
            int mB = res.get(b)*B;
            int mC = res.get(c)*C;
            
            int min = mA;
            min = Math.min(min, mB);
            min = Math.min(min, mC);
            
            res.add(min);
            
            if(min == mA)
                a++;
            
            if(min == mB)
                b++;
                
            if(min == mC)
                c++;
        }
        
        res.remove(0);
        return res;
    }
}
