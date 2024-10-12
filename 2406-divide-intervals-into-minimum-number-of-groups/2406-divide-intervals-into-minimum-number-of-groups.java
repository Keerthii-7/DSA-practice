class Solution {
    public int minGroups(int[][] intervals) {
       Arrays.sort(intervals,(e1,e2)->e1[0]-e2[0]);
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       for(int[] interval:intervals){
        if(!pq.isEmpty() && pq.peek() < interval[0]){
            pq.poll();
        }
        pq.offer(interval[1]);
       }
       return pq.size();
    }
}