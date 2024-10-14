class Solution {
    public long maxKelements(int[] nums, int k) {
        long score=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            pq.offer(i);
        }
        for(int i=0;i<k;i++){
            int val=pq.poll();
            score+=val;
            double t = (double) val / 3;
            if(t>(int)(Math.ceil(val/3))){
                val=(int)t+1;
            }else{
                val=(int)t;
            }
            pq.offer(val);
        }
        return score;
    }
}