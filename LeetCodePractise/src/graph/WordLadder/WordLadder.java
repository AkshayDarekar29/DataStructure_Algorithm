package graph.WordLadder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class WordLadder {
	
	/* Approach 1 : One Way BFS
	 * Time Complexity : 
	 * Space Complexity : 
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String, Integer> beginMap = new HashMap<>();
        Queue<String> beginQ = new LinkedList<>();
        beginQ.offer(beginWord);
        Set<String> wordSet = wordList.stream().collect(Collectors.toSet());
        if(!wordSet.contains(endWord))
            return 0;
        beginMap.put(beginWord, 0);
        while(!beginQ.isEmpty()){
            String s = beginQ.poll();
            for(int i = 0 ; i < s.length() ; i++) {
                for(char c = 'a' ; c <= 'z' ; c++) {
                    String transformed = s.substring(0, i) + (char) c + s.substring(i + 1, s.length());
                    if(wordSet.contains(transformed)){
                        if(!beginMap.containsKey(transformed)) {
                            beginQ.add(transformed);
                            beginMap.put(transformed, beginMap.get(s)+1);
                        }
                        if(transformed.equals(endWord)){
                            return beginMap.get(endWord) + 1;
                        } 
                    }                      
                }
            }
        }  
        return 0;
    }
	/* Approach 2 : Two Way BFS
	 * Time Complexity : 
	 * Space Complexity : 
	 */
	public int ladderLength_2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = wordList.stream().collect(Collectors.toSet());
        if(!wordSet.contains(endWord)){
            return 0;
        }
        HashMap<String, Integer> beginMap = new HashMap<>();
        Queue<String> beginQ = new LinkedList<>();
        beginQ.offer(beginWord);
        beginMap.put(beginWord, 0);
    
        HashMap<String, Integer> endMap = new HashMap<>();
        Queue<String> endQ = new LinkedList<>();
        endQ.offer(endWord);
        endMap.put(endWord, 0);
        while(!beginQ.isEmpty() && !endQ.isEmpty()){
            int len = beginQ.size();
            for(int k =0; k < len; k++){
                String s = beginQ.poll();
                for(int i = 0 ; i < s.length() ; i++) {
                    for(char c = 'a' ; c <= 'z' ; c++) {
                        String transformed = s.substring(0, i) + (char) c + s.substring(i + 1, s.length());
                        if(wordSet.contains(transformed)){
                            if(!beginMap.containsKey(transformed)) {
                                beginQ.add(transformed);
                                beginMap.put(transformed, beginMap.get(s)+1);
                            }
                            if(endMap.containsKey(transformed)){
                                return beginMap.get(transformed) + endMap.get(transformed) + 1;
                            }
                        }                      
                    }
                }
            }
            len = endQ.size();
            for(int k =0; k < len; k++){
                String s = endQ.poll();
                for(int i = 0 ; i < s.length() ; i++) {
                    for(char c = 'a' ; c <= 'z' ; c++) {
                        String transformed = s.substring(0, i) + (char) c + s.substring(i + 1, s.length());
                        if(wordSet.contains(transformed)){
                            if(!endMap.containsKey(transformed)) {
                                endQ.add(transformed);
                                endMap.put(transformed, endMap.get(s)+1);
                            }
                            if(beginMap.containsKey(transformed)){
                                return beginMap.get(transformed) + endMap.get(transformed) + 1;
                            }
                        }                      
                    }
                }
            }
        }  
        return 0;
    }
}
