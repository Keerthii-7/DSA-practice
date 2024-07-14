class Pair {
    String element;
    int count;
    Pair(String element, int count) {
        this.element = element;
        this.count = count;
    }
}
class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        TreeMap<String, Integer> map = new TreeMap<>();
        Stack<Object> stack = new Stack<>();

        for (int i = 0; i < n;) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                i++;
            } else if (ch == ')') {
                int j = i + 1;
                int num = 0;
                while (j < n && Character.isDigit(formula.charAt(j))) {
                    num = num * 10 + (formula.charAt(j) - '0');
                    j++;
                }
                i = j;

                num = (num == 0) ? 1 : num;

                List<Pair> tempList = new ArrayList<>();
                while (!stack.isEmpty() && !(stack.peek() instanceof Character && (char) stack.peek() == '(')) {
                    Pair p = (Pair) stack.pop();
                    p.count *= num;
                    tempList.add(p);
                }

                if (!stack.isEmpty() && stack.peek() instanceof Character && (char) stack.peek() == '(') {
                    stack.pop();
                }

                for (Pair p : tempList) {
                    stack.push(p);
                }
            } else {
                int j = i + 1;
                while (j < n && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String element = formula.substring(i, j);
                i = j;

                int num = 0;
                while (j < n && Character.isDigit(formula.charAt(j))) {
                    num = num * 10 + (formula.charAt(j) - '0');
                    j++;
                }
                num = (num == 0) ? 1 : num;

                stack.push(new Pair(element, num));
                i = j;
            }
        }

        while (!stack.isEmpty()) {
            Pair p = (Pair) stack.pop();
            map.put(p.element, map.getOrDefault(p.element, 0) + p.count);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }
}