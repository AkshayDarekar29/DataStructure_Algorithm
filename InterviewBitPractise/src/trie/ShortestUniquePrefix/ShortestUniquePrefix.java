package trie.ShortestUniquePrefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ShortestUniquePrefix {
	public ArrayList<String> prefix(ArrayList<String> A) {
        TrieNode root = new TrieNode();
        for(String s : A){
            insert(root, s);
        }
        
        ArrayList<String> result = new ArrayList<>();
        for(String s: A){
            result.add(findPrefix(root, s));
        }
        return result;
    }
    
    public String findPrefix(TrieNode root, String s){
        TrieNode current = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            sb.append(Character.toString(ch));
            TrieNode node = current.children.get(ch);
            if(node.count == 1){
                break;
            }
            current = node;
        }
        return sb.toString();
    }
    public void insert(TrieNode root, String word){
        TrieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            node.count++;
            current = node;
        }
    }
    
    class TrieNode{
        Map<Character, TrieNode> children;
        int count;
        public TrieNode(){
            children = new HashMap<>();
            count = 0;
        }
    }
}
