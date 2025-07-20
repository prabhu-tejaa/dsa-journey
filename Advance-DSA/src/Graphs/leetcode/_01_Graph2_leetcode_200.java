package Graphs.leetcode;

/*
        here 0 = water, 1 = island.
        we'll be using DFS
        when you find 0 skip, when you find 1 do a dfs (check is it visited, if not mark it as true)
        check ass sides if you have 1 and keep marking it as 0
        its on us to take right or bottom
        in dfs we backtrack, so if we don't find any 1's then backtrack
        if you get true in the visited array matrix then also skip it
        keep a counter to count the no of islands
*/

public class _01_Graph2_leetcode_200 {

    static void dfs(int i, int j, int rows, int cols, int[][] visited, char[][] grid){
        visited[i][j] = 1;

        int[] X = {0, 1, 0, -1};
        int[] Y = {-1, 0, 1, 0};

        for(int k = 0; k < 4; k++){
            int newX = i+X[k];
            int newY = j+Y[k];

            if(checkBoundary(newX, newY,rows, cols, visited, grid)){
                dfs(newX, newY, rows, cols, visited, grid);
            }
        }
    }

    static boolean checkBoundary(int newX, int newY, int rows, int cols, int[][] visited, char[][] grid){
        return newX >= 0 && newY >=0 && newX < rows && newY < cols && grid[newX][newY] == '1' && visited[newX][newY] == 0;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };

//        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'},
//        };
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];
        int noOfIslands = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols;j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    noOfIslands++;
                    dfs(i, j, rows, cols, visited, grid);
                }
            }
        }
        System.out.println("No of islands: " + noOfIslands);
    }
}
