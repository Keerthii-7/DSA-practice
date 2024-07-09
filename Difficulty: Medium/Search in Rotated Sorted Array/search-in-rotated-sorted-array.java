//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        int pivot=findPivot(arr);
        //System.out.println(pivot+" ");
        int first_half=binarySearch(arr,0,pivot-1,key);
        if(first_half!=-1){
            return first_half;
        }
        return binarySearch(arr,pivot,arr.length-1,key);
    }
    int findPivot(int[] arr){
        int s=0;
        int e=arr.length-1;
        while(s<e){
            int mid=(s+e)/2;
            if (arr[mid] > arr[e]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
    int binarySearch(int[] arr,int s,int e,int key){
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]>key){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return -1;
    }
}