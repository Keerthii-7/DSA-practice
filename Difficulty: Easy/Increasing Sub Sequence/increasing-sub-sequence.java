//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        List<Character> list=new ArrayList<>();
        char[] nums=S.toCharArray();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(list.get(list.size()-1)>=nums[i]){
                int index=getCeilIndex(list,0,list.size()-1,nums[i]);
                list.set(index,nums[i]);
            }else{
                list.add(nums[i]);
            }
        }
        return list.size();
    }
    public static int getCeilIndex(List<Character> list,int s,int e,char target){
        while(s<e){
            int mid=s+(e-s)/2;
            if(list.get(mid)>=target){
                e=mid;
            }else{
                s=mid+1;
            }
        }
        return e;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}


// } Driver Code Ends