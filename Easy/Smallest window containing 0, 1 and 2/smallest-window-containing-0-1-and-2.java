//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int i=Integer.MAX_VALUE;
        int j=Integer.MAX_VALUE;
        int k=Integer.MAX_VALUE;
        int minLen=Integer.MAX_VALUE;
        for(int index=0;index<S.length();index++){
            char ch=S.charAt(index);
            if(ch=='0'){
                i=index;
            } else if(ch=='1'){
                j=index;
            } else {
                k=index;
            }
            if(i>=0&&i<=S.length()&&j>=0&&j<=S.length()&&k>=0&&k<=S.length())
            {
            int min=Math.min(Math.min(i, j), k);
            int max=Math.max(Math.max(i, j), k);
            minLen=Math.min(minLen,1+max-min);
            } else {
                continue;
            }
        }
        if(minLen!=Integer.MAX_VALUE)
        return minLen;
        return -1;
    }
};
