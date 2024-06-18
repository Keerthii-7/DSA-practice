class Solution {
    public int minIncrementForUnique(int[] nums) {
       Arrays.sort(nums);
        int count = 0;
        int expected = nums[0];
        
        for (int num : nums) {
            if (num < expected) {
                count += expected - num;
                expected++;
            } else {
                expected = num + 1;
            }
        }
        
        return count;
    }
}