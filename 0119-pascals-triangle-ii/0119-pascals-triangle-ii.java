public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] pascal = new int[rowIndex+1][];
        for (int i = 0; i <= rowIndex; i++){
            int[] row = new int[i + 1];
            row[0] = 1;
            row[i] = 1;
            for (int j = 1; j < i; j++){
                row[j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
            pascal[i] = row;
        }
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<pascal[rowIndex].length;i++){
            ans.add(pascal[rowIndex][i]);
        }
        return ans;
    }
}