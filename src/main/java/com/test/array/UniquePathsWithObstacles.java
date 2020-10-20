package com.test.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/7/6 10:42
 * 63. 不同路径 II
 * 从终点obstacleGrid[i][j]往前依次计算
 * 到达点obstacleGrid[i-1][j],obstacleGrid[i][j-1]
 * 可走的路径数（及从上方来还是从左方来）
 */
@Slf4j
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int wayNum = solutionOne(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        log.info("{}", wayNum);
    }

    private static int solutionOne(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int[] path = new int[m];
        path[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < m; j++) {
                if (row[j] == 1) {
                    path[j] = 0;
                } else if (j >= 1) {
                    path[j] = path[j - 1] + path[j];
                }
            }
        }
        return path[m -1];
    }
}
