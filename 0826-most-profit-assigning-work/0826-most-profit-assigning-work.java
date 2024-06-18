class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        job[] jobs = new job[profit.length];
        for (int i = 0; i < profit.length; i++) {
            jobs[i] = new job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (j1, j2) -> j1.diff == j2.diff ? j2.profit - j1.profit : j1.diff - j2.diff);
        Arrays.sort(worker);
        int maxProfit = 0;
        int bestProfit = 0;
        int j = 0;
        for (int i = 0; i < worker.length; i++) {
            while (j < jobs.length && worker[i] >= jobs[j].diff) {
                bestProfit = Math.max(bestProfit, jobs[j].profit);
                j++;
            }
            maxProfit += bestProfit;
        }
        
        return maxProfit;
    }
    private class job{
        int diff,profit;
        job(int difficulty,int profit){
            this.diff=difficulty;
            this.profit=profit;
        }
    }
}