class Solution {
   public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i];
            i--;
        } else {
            nums1[k] = nums2[j];
            j--;
        }
        k--;
    }
    while (j >= 0) {
        nums1[k] = nums2[j];
        j--;
        k--;
    }
}
public static void main(String args[]){
    Scanner in=new Scanner(System.in);
    int nums1[]=new int[400];
    int nums2[]=new int[200];
    for(int i=0;i<nums1.length;i++){
        nums1[i]=in.nextInt();
    }
    int m=in.nextInt();
    for(int i=0;i<nums2.length;i++){
        nums2[i]=in.nextInt();
    }
    int n=in.nextInt();
    merge(nums1,m,nums2,n);
    System.out.println(nums1);
}

}