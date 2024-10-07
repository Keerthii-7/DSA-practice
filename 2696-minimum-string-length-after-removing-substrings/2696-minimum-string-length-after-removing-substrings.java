class Solution {
    public int minLength(String s) {
        Stack<Character> st=new Stack<>();
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=' ';
            if(!st.isEmpty())
                ch2=st.peek();
            if(ch1=='B' && ch2=='A' || ch1=='D' && ch2=='C'){
                st.pop();
            }else{
                st.push(ch1);
            }
        }
        return st.size();
    }
}