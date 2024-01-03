class Solution {
    public int numberOfBeams(String[] bank) {
        int prev=0;
        int current=0;
        int ans=0;
        for(String s:bank){
            int n=countOne(s);
            if(n>0){
                prev=current;
                current=n;
                if(prev>0&&current>0){
                    ans=ans+(current*prev);
                }
            }
        }
        return ans;
    }
    public int countOne(String s){
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='1'){
                count++;
            }
        }
        return count;
    }
}