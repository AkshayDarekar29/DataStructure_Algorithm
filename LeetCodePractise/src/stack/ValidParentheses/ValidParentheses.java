package stack.ValidParentheses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	/*
	 * Approach 1 : Using Stack and HashMap
	 * Time Complexity:  O(n)
	 * Space Complexity: O(n)
	 */
	
public boolean isValid(String s) {
        
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
    
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length(); i++){
            if(!hm.containsKey(s.charAt(i))){
               stack.push(s.charAt(i)); 
            }else{
                if(stack.empty()){
                    return false;
                }
               
                if(hm.get(s.charAt(i)) != stack.pop()){
                    return false;
                }
            }
        }
        
        return stack.empty();
    }
}
