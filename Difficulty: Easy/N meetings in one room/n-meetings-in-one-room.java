//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Activity{
    int start,end;
    Activity(int s,int e){
        this.start=s;
        this.end=e;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int n,int start[], int end[])
    {
        // add your code here
        Activity[] a=new Activity[n];
        for(int i=0;i<n;i++){
            a[i]=new Activity(start[i],end[i]);
        }
        Arrays.sort(a, (a1, a2) -> a1.end - a2.end);
        int count=1;
        int pre=0;
        for(int i=1;i<n;i++){
            Activity curr=a[i];
            Activity prev=a[pre];
            if(prev.end<curr.start){
                pre=i;
                count++;
            }
        }
        return count;
    }
}
