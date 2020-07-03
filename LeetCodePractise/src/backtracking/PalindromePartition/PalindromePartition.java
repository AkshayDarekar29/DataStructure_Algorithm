package backtracking.PalindromePartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartition {
	public static void main(String[] args) {
		PalindromePartition obj = new PalindromePartition();
		List<List<String>> list = obj.partition("aabaa");
		
		for(List<String> list2 : list){
			System.out.print("[");
			for (String s : list2) {
				System.out.print(s + ", ");
			}
			System.out.print("]");
			System.out.println();
		}
		
	}
	public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        part(s, list, new ArrayList<String>(), 0, s.length());
        return list;
    }
    
    public void part(String s, List<List<String>> list, ArrayList<String> l, int start, int len){
        if(start == len){
            list.add(new ArrayList<>(l));
            return;
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = start; i<s.length(); i++){
                sb.append(s.charAt(i));
                if(isPalindrome(sb.toString())){
                    l.add(sb.toString());
                    part(s,list,l, i+1, len);
                    l.remove(l.size()-1);
                }
            }
        }
    }
                   
    public boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        for(int i=0; i< s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
