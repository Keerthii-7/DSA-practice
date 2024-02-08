class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        return binarySearch(matrix,0,m*n-1,target);
    }
    public boolean binarySearch(int[][] a,int low,int high,int target){
        while(low<=high){
            int mid=(low+high)/2;
            int r = mid / a[0].length; // converting 1D index
            int c = mid % a[0].length; // to 2D index
            if(a[r][c] == target) return true;
            else if(a[r][c] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}