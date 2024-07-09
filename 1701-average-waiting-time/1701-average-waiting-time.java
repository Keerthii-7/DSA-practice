class Solution {
    public double averageWaitingTime(int[][] customers) {
       int ft = 0; 
        double wt = 0; 
        for (int i = 0; i < customers.length; i++) {
            if (ft < customers[i][0]) {
                ft = customers[i][0]; 
            }
            ft += customers[i][1];
            wt += ft - customers[i][0];
        }
        return (double) wt / customers.length;
    }
}