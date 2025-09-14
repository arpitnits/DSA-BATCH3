package Queue;

public class GasStation {

    public int CanCompleteCircuit(int[] gas, int[] cost) {
        int totalGain=0, currGain =0, stationId = 0, netGain=0;

        for(int i=0; i<gas.length; i++) {
            netGain = gas[i] - cost[i];

            //If you move forward this is netGain you will have
            totalGain+= netGain;
            currGain+= netGain;

            if(currGain < 0 ) {
                stationId = i+1;
                currGain=0;
            }
        }

        if(totalGain>=0)    return stationId;
        return -1;
    }
}
