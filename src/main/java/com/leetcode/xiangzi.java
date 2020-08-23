package com.leetcode;

/**
 * @author mai.gq
 * @date 2020/7/27
 */
public class xiangzi {
    private int[][] image;
    private int n;
    private int m;
    private int oldColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.oldColor = image[sr][sc];
        this.n = image[0].length;
        this.m = image.length;
        dps(sr, sc, newColor);
        return this.image;
    }

    private void dps(int i, int j, int newColor) {
        if (i < 0 || j < 0 || i >= m || j >= n || image[i][j] != oldColor) {
            return;
        }
        if (image[i][j] != newColor && image[i][j] == oldColor) {
            image[i][j] = newColor;
            dps(i - 1, j, newColor);
            dps(i + 1, j, newColor);
            dps(i, j - 1, newColor);
            dps(i, j + 1, newColor);
        }

    }


    public xiangzi() {
    }

    public static void main(String[] args) {
        xiangzi xiangz = new xiangzi();
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        xiangz.floodFill(image, 1, 1, 2);
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        xiangz.floodFill(image, 1, 1, 1);
    }
}
