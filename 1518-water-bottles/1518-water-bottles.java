class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        int exchange=numBottles;
        while(exchange>=numExchange){
            ans+=exchange/numExchange;
            System.out.println(ans);
            exchange=(exchange/numExchange)+(exchange%numExchange);
        }
        return ans;
    }
}