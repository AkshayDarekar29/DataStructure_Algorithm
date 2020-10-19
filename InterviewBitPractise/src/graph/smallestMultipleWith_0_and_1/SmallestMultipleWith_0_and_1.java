package graph.smallestMultipleWith_0_and_1;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestMultipleWith_0_and_1 {
	
	public String multiple(int A) {
        if(A == 1){
            return "1";
        }
       boolean visited[] = new boolean[A];
       Queue<Node> q = new LinkedList<>();
       Node node = new Node(true, 1, null);
       q.offer(node);
       visited[1] = true;
       Node curr = null;
       while(!q.isEmpty()){
           curr = q.poll();
           int currNumber = curr.digit;
           if(currNumber == 0){
               break;
           }
           int rem = currNumber%A;
            int first = rem * 10 % A;
            int second = first + 1;
           if(!visited[first]){
               q.offer(new Node(false, first, curr));
                visited[first] = true;
           }
           if(second == A){
                q.offer(new Node(true, 0, curr));
           }else if(!visited[second]){
               q.offer(new Node(true, second, curr));
               visited[second] = true;
           }
       }
       
        StringBuilder res = new StringBuilder();
        while(curr != null){
            if(curr.isDigitOne){
                res.append("1");
            }else{
                res.append("0");
            }
            curr = curr.parent;
        }
        res = res.reverse();
        return res.toString();
    }
}

class Node{
    boolean isDigitOne;
    int digit;
    Node parent;
    
    Node(boolean isDigitOne, int digit, Node parent){
        this.isDigitOne =isDigitOne;
        this. digit = digit;
        this.parent = parent;
    }   
}