class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        System.out.println(arr);
        int i=0;
        while(arr.size()>1){
            i=(i+k-1)%arr.size();
            arr.remove(Integer.valueOf(arr.get(i)));
        }
        return arr.get(0);
    }
}