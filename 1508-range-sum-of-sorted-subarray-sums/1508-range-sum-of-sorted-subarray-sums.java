class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums=new int[(n*(n+1)/2)];
        int index=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                sums[index++]=sum;
            }
        }
        int mod=(int)Math.pow(10,9)+7;
        Arrays.sort(sums);
        int ans=0;
        for(int i=left-1;i<right;i++){
            ans = (ans + sums[i]) % mod;
        }
        System.out.println(Arrays.toString(sums));
        return ans;
    }
}