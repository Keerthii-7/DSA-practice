//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char ch = sc.next().charAt(0);
            int count = sc.nextInt();
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution {
    public String printString(String s, char ch, int count) {
        // code here
       int index = -1;
        int startIndex = 0; // start searching from the beginning
        
        while(count > 0) {
            index = s.indexOf(ch, startIndex);
            if (index == -1) {
                // character not found
                return "";
            }
            startIndex = index + 1; // move startIndex to the next character after found character
            count--;
        }
        
        if (index != -1 && index < s.length() - 1) {
            return s.substring(index + 1);
        }
        return "";
    }
    public static String charRemoveAt(String str, int p) {  
              return str.substring(0, p) + str.substring(p + 1);  
    }  
}