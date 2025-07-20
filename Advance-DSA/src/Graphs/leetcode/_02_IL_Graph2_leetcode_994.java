package Graphs.leetcode;

import java.util.*;
public class _02_IL_Graph2_leetcode_994 {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int rows = grid.length;
        int cols = grid[0].length;


        if(grid == null || rows == 0 || cols == 0){
            System.out.println(-1);
            return;
        }

        int totalOranges = 0;
        int minutes = 0;
        int rottenOranges = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != 0) {
                    totalOranges++;
                }
                if (grid[r][c] == 2) {
                    rottenOranges++;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[] X = {-1, 0, 1, 0};
        int[] Y = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            boolean anyNewRotten = false;

            for(int i = 0; i < currentSize; i++) {
                int[] pairOfRowCols = queue.poll();

                if(pairOfRowCols == null) continue;

                int row = pairOfRowCols[0];
                int col = pairOfRowCols[1];

                for (int j = 0; j < 4; j++) {
                    int newX = row + X[j];
                    int newY = col + Y[j];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        rottenOranges++;
                        anyNewRotten = true;
                    }
                }
            }
        if (anyNewRotten) {
            minutes++;
        }
    }
        System.out.println((rottenOranges == totalOranges) ? minutes : -1);
    }
}
