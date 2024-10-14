import java.util.*;

class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.offer((long) num);
        }
        for (int i = 0; i < k; i++) {
            long val = pq.poll();
            score += val;
            long newVal = (long) Math.ceil(val / 3.0);
            pq.offer(newVal);
        }
        
        return score;
    }
}
