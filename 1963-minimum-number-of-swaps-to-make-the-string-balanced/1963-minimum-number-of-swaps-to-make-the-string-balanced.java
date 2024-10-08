class Solution {
    public int minSwaps(String s) {
        int bal=0;
        int swaps=0;
        for(char ch:s.toCharArray()){
            if(ch=='['){
                bal++;
            }else{
                if (bal == 0) {
                    bal++;
                } else {
                    bal--;
                }

            }
        }
        return (bal+1)/2;
    }
}