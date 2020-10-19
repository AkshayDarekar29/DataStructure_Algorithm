package misc.LRUCache;

import java.util.HashMap;


/*
 * Approach : Using HashMap and DoublyLinkedList
 */
class LRUCache_2 {

	HashMap<Integer, Entry> hashmap;
	Entry start, end;
	int LRU_SIZE;
    
    public LRUCache_2(int capacity) {
        hashmap = new HashMap<>();
        LRU_SIZE = capacity;
    }
    /*
     * Time Complexity: O(1) 
     */
    public int get(int key) {
        if(hashmap.containsKey(key)){
            Entry e = hashmap.get(key);
            removeNode(e);
            addAtTop(e);
            return e.value;
        }
        return -1;
    }
    /*
     * Time Complexity: O(1) 
     */
    public void put(int key, int value) {
        if (hashmap.containsKey(key)){
			Entry entry = hashmap.get(key);
			entry.value = value;
			removeNode(entry);
			addAtTop(entry);
		} else {
			Entry newnode = new Entry();
			newnode.left = null;
			newnode.right = null;
			newnode.value = value;
			newnode.key = key;
			if (hashmap.size() == LRU_SIZE) {
				hashmap.remove(end.key);
				removeNode(end);				
				addAtTop(newnode);

			} else {
				addAtTop(newnode);
			}

			hashmap.put(key, newnode);
		}
    }
    
    public void addAtTop(Entry node) {
		node.right = start;
		node.left = null;
		if (start != null)
			start.left = node;
		start = node;
		if (end == null)
			end = start;
	}
    public void removeNode(Entry node) {

		if (node.left != null) {
			node.left.right = node.right;
		} else {
			start = node.right;
		}

		if (node.right != null) {
			node.right.left = node.left;
		} else {
			end = node.left;
		}
	}
}

class Entry {
	int value;
	int key;
	Entry left;
	Entry right;
}
