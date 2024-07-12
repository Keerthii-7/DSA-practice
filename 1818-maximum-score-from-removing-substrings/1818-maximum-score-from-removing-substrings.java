class Solution {
    static int gain=0;
    public int maximumGain(String s, int x, int y) {
        gain = 0;
        if (x >= y) {
            s= removeSubstrings(s, 'a', 'b', x);
            s= removeSubstrings(s, 'b', 'a', y);
        } else {
            s= removeSubstrings(s, 'b', 'a', y);
            s= removeSubstrings(s, 'a', 'b', x);
        }
        return gain;
    }

    private String removeSubstrings(String s, char first, char second, int gainValue) {
        Stack<Character> stack = new Stack<>();
        StringBuilder remaining = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == second && !stack.isEmpty() && stack.peek() == first) {
                stack.pop();
                gain += gainValue;
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            remaining.insert(0, stack.pop());
        }

        return remaining.toString();
    }
}