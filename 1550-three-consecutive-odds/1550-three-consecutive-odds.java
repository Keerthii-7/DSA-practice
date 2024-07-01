class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length-2;i++){
            int one=arr[i];
            int two=arr[i+1];
            int three=arr[i+2];
            if(one%2!=0 && two%2!=0 && three%2!=0){
                return true;
            }
        }
        return false;
    }
}