package p134_Gas_Station;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            if(gas[i] < cost[i]) continue;
            int remain = 0;
            for(int j = i; j < gas.length + i; j++){
                remain = remain + (gas[j % gas.length] - cost[j % gas.length]);
                if(remain < 0) break;
                if((j + 1 ) % gas.length  == i ) return i ;
            }
        }
        return -1;
    }
}