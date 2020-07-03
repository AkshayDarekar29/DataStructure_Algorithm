package string.romanToInteger;

import java.util.HashMap;

public class RomanToInteger {
	
	/*Approach 1 : Using hashmap to store Values of Roman digits
	 * Time Complexity: O((n) 
	 * Space Complexity: O(1) - because for any input it is same
	*/
	public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int prevVal = 0;
        for(int i = s.length()-1; i >=0; i--){
            char currStr = s.charAt(i);
            int currVal = map.get(currStr);
            if(currVal < prevVal){
                result -= currVal; 
            }else{
                result += currVal;
            }
            prevVal = currVal;
        }
        return result;
    }
	
	/*Approach 2 : Using Switch Case
	 * 
	 * Time Complexity: O((n) 
	 * Space Complexity: O(1)
	*/
	public int romanToInt_2(String s) {

        int result = 0;
        int prevVal = 0;
        for(int i = s.length()-1; i >=0; i--){
            char currStr = s.charAt(i);
            int currVal = 0;
            switch(currStr){
                case 'I' : 
                    currVal = 1;
                    break;
                    
                case 'V' : 
                    currVal = 5;
                    break;
                
                case 'X' : 
                    currVal = 10;
                    break;
                
                case 'L' : 
                    currVal = 50;
                    break;
                
                case 'C' : 
                    currVal = 100;
                    break;
                
                case 'D' : 
                    currVal = 500;
                    break;
                
                case 'M' : 
                    currVal = 1000;
                    break;
            }
            if(currVal < prevVal){
                result -= currVal; 
            }else{
                result += currVal;
            }
            prevVal = currVal;
        }
        return result;
    }
}
