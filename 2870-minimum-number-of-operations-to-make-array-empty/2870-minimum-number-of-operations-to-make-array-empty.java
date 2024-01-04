class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        System.out.println(countMap);
        int operations = 0;
        while (!countMap.isEmpty()) {
            boolean found = false;

            for (int num : countMap.keySet()) {
                int count = countMap.get(num);
                if (count == 3||count%3==0) {
                    countMap.put(num, count - 3);
                    found = true;
                    operations++;
                } else if (count == 2||count%2==0) {
                    countMap.put(num, count - 2);
                    found = true;
                    operations++;
                } else if(count>3){
                    countMap.put(num, count - 3);
                    found = true;
                    operations++;
                }
            }

            if (!found) {
                return -1;
            }

            // Remove elements with count 0 to avoid infinite loop
            countMap.entrySet().removeIf(entry -> entry.getValue() == 0);
        }

        return operations;
    }
}