package graph.sumOfFibonacciNumbers;

import java.util.ArrayList;

public class SumOfFibonacciNumbers {
	public int fibsum(int A) {
        ArrayList<Integer> list = new ArrayList<>();
        int res = 0;
        list.add(1);
        list.add(1);
        while(A != 0){
            while(A > list.get(list.size()-1)){
                list.add(list.get(list.size()-1) + list.get(list.size()-2));
            }
            while(A < list.get(list.size()-1)){
                list.remove(list.size()-1);
            }
            A = A - list.get(list.size()-1);
            res++;
        }
        return res;
    }
}