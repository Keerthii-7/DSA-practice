//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    public int MaxConnection(int grid[][]) {
        // Your code here
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        HashMap<Integer,Integer> map=new HashMap<>();
        int compId=2;
        int maxSize=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    int size=Dfs(grid,visited,i,j,compId);
                    map.put(compId,size);
                    maxSize=Math.max(maxSize,size);
                    compId++;
                }
            }
        }
        visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    Set<Integer> set=new HashSet<>();
                    int[] dirX={-1,1,0,0};
                    int[] dirY={0,0,-1,1};
                    int newSize=1;
                    for(int k=0;k<4;k++){
                        int newRow=i+dirX[k];
                        int newCol=j+dirY[k];
                        if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length){
                            int comp=grid[newRow][newCol];
                            if(comp>1 && set.add(comp)){
                                newSize+=map.get(comp);
                            }
                        }
                    }
                    maxSize=Math.max(maxSize,newSize);
                }
            }
        }
        return maxSize;
    }
    public static int Dfs(int[][] grid,boolean visited[][],int row,int col,int compId){
        visited[row][col]=true;
        grid[row][col]=compId;
        int[] dirX={-1,1,0,0};
        int[] dirY={0,0,-1,1};
        int size=1;
        for(int k=0;k<4;k++){
            int newRow=row+dirX[k];
            int newCol=col+dirY[k];
            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]==1){
                size+=Dfs(grid,visited,newRow,newCol,compId);
            }
        }
        return size;
    }
}