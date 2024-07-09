class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double waitingTime=0;
        int currentTime=customers[0][0];
        for(int i=0 ; i<customers.length ; i++){
            if(currentTime < customers[i][0]){
                currentTime = customers[i][0];
            }
            int finishTime = currentTime + customers[i][1];
            waitingTime += (finishTime - customers[i][0]);
            currentTime = finishTime;
        }
        return waitingTime/customers.length ;
    }
}