class Solution {
    public int[] findErrorNums(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        int[] list=new int[2];
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                list[0]=nums[i];
                list[1]=(i+1);
            }
        }
        return list;
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}