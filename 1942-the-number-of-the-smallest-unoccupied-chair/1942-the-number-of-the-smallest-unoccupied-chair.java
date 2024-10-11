class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<times.length;i++){
            list.add(new int[]{times[i][0],i});
        }
        Collections.sort(list,(e1,e2)->e1[0]-e2[0]);
        PriorityQueue<Integer> emptySeats = new PriorityQueue<>();
        PriorityQueue<int[]> takenSeats = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) emptySeats.offer(i);
        for(int i=0;i<list.size();i++){
            int[] curr=list.get(i);
            int arr=curr[0];
            int index=curr[1];
            int leav=times[index][1];
            int seat=emptySeats.poll();
            if(index==targetFriend){
                return seat;
            }
            while(!takenSeats.isEmpty() && takenSeats.peek()[0]<=arr){
                emptySeats.offer(takenSeats.peek()[1]);
                takenSeats.poll();
            }
            takenSeats.offer(new int[]{leav,seat});
        }
        return -1;
    }
}