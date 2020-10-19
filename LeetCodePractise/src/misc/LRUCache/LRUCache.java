package misc.LRUCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Approach : Using HashMap and ArrayList
 */
class LRUCache {

    static HashMap<Integer,Integer> map;
    static int size;
    static List li;
    public LRUCache(int capacity) {
	    map=new HashMap<>();
	    size=capacity;
	    li=new ArrayList<>();
    }
   /*
    * Time Complexity: O(n) 
    */
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            li.remove(new Integer(key));
            li.add(key);
            return map.get(key);
        }

    }
    /*
     * Time Complexity: O(n) 
     */
    public void put(int key, int value) {
	    if(map.containsKey(key)){
	            li.remove(new Integer(key));
	            li.add(key);
	          map.put(key,value);
	    }
        else{
            map.put(key,value);
            if(li.size()==size){
                map.remove(li.get(0));
                li.remove(0);

            }   
        li.add(key);
        }
    }
}


	
