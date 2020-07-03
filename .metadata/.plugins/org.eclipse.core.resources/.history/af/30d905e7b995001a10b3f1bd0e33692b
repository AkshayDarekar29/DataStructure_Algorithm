package greedy.GasStation;


public class GasStation {
	
	/* Approach 1: 
	 * Time Complexity : O(n)
	 * Space Complexity : O(1)
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int start =0, i=0,def=0, temp =0;
        while(i < gas.length){
            temp +=gas[i]-cost[i];
            def+=gas[i]-cost[i];
            if(temp<0){
                start=i+1;
                temp=0;
            }
            i++;
        }
        if(def >= 0)
                return start;
        else
                return -1;
    }
	
	/* Approach 2: 
	 * Time Complexity : O(n2)
	 * Space Complexity : O(1)
	 */
	public int canCompleteCircuit_2(int[] gas, int[] cost) {
        int gasSum=0, costSum=0;
        for(int i=0; i<gas.length;i++)
        {
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        if(gasSum<costSum)
            return -1;
        for(int i=0;i<gas.length; i++)
        {
            if(gas[i]>=cost[i])
            {
                if(checkPossibility(gas, cost ,i))
                    return i;
            }
        }
        return -1;
    }
    public boolean checkPossibility(int[] gas, int[] cost, int idx)
    {
        int currGas=0;
        for(int i=idx;i<idx+gas.length;i++)
        {
            currGas+=gas[i%gas.length];
            currGas-=cost[i%gas.length];
            if(currGas<0)
                return false;
        }
        return true;
    }
}
