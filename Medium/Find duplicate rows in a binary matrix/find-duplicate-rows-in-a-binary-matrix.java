//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            ArrayList<Integer> ans = new Solution().repeatedRows(arr, n, m);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i)+" ");
                
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static boolean chk(int matrix[][], int r1, int r2, int m, int n){
        for(int i=0; i<n; i++){
            if(matrix[r1][i] != matrix[r2][i])
                return false;
        }
        return true;
    }
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        //code here
        HashSet<Integer> st = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0; i<m; i++){
            for(int j=i+1; j<m; j++){
                if(!st.contains(j) && chk(matrix, i, j, m, n)){
                    st.add(j);
                    ans.add(j);
                }
            }
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}