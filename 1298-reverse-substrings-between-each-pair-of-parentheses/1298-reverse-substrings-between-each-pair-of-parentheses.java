class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.push(i);
            } else if (c[i] == ')') {
                int start = stack.pop();
                reverseString(c, start + 1, i - 1);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : c) {
            if (ch != '(' && ch != ')') {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    public static void reverseString(char[] c,int l,int r){
        int k=l;
        int t=r;
        while(k<t){
            swap(c,k,t);
            k++;
            t--;
        }
    }
    public static void swap(char c[],int i,int j){
        char ch=c[i];
        c[i]=c[j];
        c[j]=ch;
    }
}