class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        buildHeap(nums,n);
        int i=n-1;
        for(int t=k;t>1;t--){
            swap(nums,0,i);
            maxHeapify(nums,i,0);
            i--;
        }
        return nums[0];
    }
    public void buildHeap(int[] arr,int n){
        for(int i=(n-2)/2;i>=0;i--){
            maxHeapify(arr,n,i);
        }
    }
    public void maxHeapify(int arr[],int n,int i){
        int largest=i,left=2*i+1,right=2*i+2;
        if(left<n&&arr[left]>arr[largest]){
            largest=left;
        } if(right<n&&arr[right]>arr[largest]){
            largest=right;
        } if(largest!=i){
            swap(arr,largest,i);
            maxHeapify(arr,n,largest);
        }
    }
    public void swap(int[] arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}