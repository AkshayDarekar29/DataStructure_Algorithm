package string.stringToInteger;

import java.util.HashSet;

public class StringToInteger {
	
	/*Approach 1 : Using ASCII values
	 * 
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	*/
	public static int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0;
        while (i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')){
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7))             {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }
	
	/*Approach 2 : Using hashset
	 * 
	 * Time Complexity: O(n) 
	 * Space Complexity: O(1)
	*/
	public int myAtoi_2(String str) {
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        set.add('0');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('4');
        set.add('5');
        set.add('6');
        set.add('7');
        set.add('8');
        set.add('9');
        HashSet<Character> signSet = new HashSet<>();
        signSet.add('-');
        signSet.add('+');
        
        char first = str.charAt(0);
        if(!set.contains(first) && !signSet.contains(first)){
            return 0;
        }
        boolean signed = false;
        boolean negative = false;
        if(first == '-' || first == '+'){
            signed = true;
            if(str.length()>1 && !set.contains(str.charAt(1))){
                return 0;
            }
            if(first == '-'){
                 negative = true;
            }
        }
        int prev = 0;
        for(int i=1; i<str.length(); i++){
            first = str.charAt(i);
            if(!set.contains(first)){
                break;
            }else{
                prev = i;
            }
        }
        int power = 0;
        double result = 0;
        int currVal = 0;
        int upto = signed?1:0;
        for(int i=prev; i >= upto; i--){
            char c = str.charAt(i);
            switch(c){
                case '0' : 
                    currVal = 0;
                    break;                    
                case '1' : 
                    currVal = 1;
                    break;                
                case '2' : 
                    currVal = 2;
                    break;                
                case '3' : 
                    currVal = 3;
                    break;
                case '4' : 
                    currVal = 4;
                    break;
                case '5' : 
                    currVal = 5;
                    break;
                case '6' : 
                    currVal = 6;
                    break;
                case '7' : 
                    currVal = 7;
                    break;
                case '8' : 
                    currVal = 8;
                    break;
                case '9' : 
                    currVal = 9;
                    break;
            }
            result += currVal*(Math.pow(10, power));
            power++;
        }
        if(negative){
            result = result * (-1);
        }
        if(result > Math.pow(2, 31)){
            return (int)Math.pow(2, 31);
        }else if(result < (Math.pow(-2, 31)-1)){
            return (int)Math.pow(-2, 31);
        }
        return  (int)result;
    }
}
