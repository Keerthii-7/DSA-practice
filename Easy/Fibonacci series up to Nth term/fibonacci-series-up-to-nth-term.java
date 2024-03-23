//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int ans[] = obj.Series(n);
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    int[] Series(int n) {
        // code here
         int mod=(int)1e9+7;
        int a=0;
        int b=1;
        int[] ans=new int[n+1];
        ans[0]=a;
        ans[1]=b;
        for(int i=2;i<=n;i++){
            int c=a+b;
            ans[i]=c%mod;
            a=b%mod;
            b=c%mod;
        }
        return ans;
    }
}