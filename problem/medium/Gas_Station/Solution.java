package problem.medium.Gas_Station;

class Solution {
    // // Solution 1: My own Greedy
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int startGas = 0;
    //     int currentTank = 0;
    //     int n = gas.length;
    //     for(int i = 0; i < n; i++) {
    //         currentTank += (gas[i] - cost[i]);
    //         if(currentTank < 0) {
    //             currentTank = 0;
    //             startGas = i + 1;
    //             continue;
    //         }
    //     }

    //     if(startGas == n) return -1;

    //     for(int i = 0; i < startGas; i++){
    //         currentTank += (gas[i] - cost[i]);
    //         if(currentTank < 0) {
    //             return -1;
    //         }
    //     }

    //     return startGas;
    // }

    // // Solution 2: More short Greedy
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startGas = 0;
        int currentTank = 0;
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            currentTank += (gas[i] - cost[i]);
            if(currentTank < 0) {
                startGas = i + 1;
                total += currentTank;
                currentTank = 0;
            }
        }
        if((total + currentTank) < 0) return -1;
        return startGas;
    }
}