package misc.josephusProblem;

public class JosephusProblem {
	public static void main(String[] args) {
		JosephusProblem obj = new JosephusProblem();
		int n = 7;
		int k = 3;
		int pos = obj.find(n,k);
		int pos2 = obj.josephus(n,k);
		pos = pos + 1;
		System.out.println(pos);
		System.out.println(pos2);
		System.out.println(pos == pos2);
	}
	/*
	 * Time Complexity : O(n)
	 * Space Complexity : O(n)
	 * https://www.youtube.com/watch?time_continue=427&v=fZ3p2Iw-O2I&feature=emb_logo
	*/
	public int find(int n, int k) {
		if(n == 1){
			return 0;
		}
		return (find(n-1, k)+ k)%n;
	}
	
	//This is geeksforgeeks solution - I didn't understand this one
	public int josephus(int n, int k) 
	{ 
	if (n == 1) 
	    return 1; 
	else
	    /* The position returned by josephus(n - 1, k)  
	    is adjusted because the recursive call  
	    josephus(n - 1, k) considers the original  
	    position k%n + 1 as position 1 */
	    return (josephus(n - 1, k) + k-1) % n + 1; 
	} 
}
