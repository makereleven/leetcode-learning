package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author mai.gq
 * @date 2020/7/29
 */
public class ShengGao {
    public static int[][] reconstructQueue(int[][] people) {
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        int[][] m = list.toArray(new int[list.size()][2]);
        return list.toArray(new int[list.size()][2]);
    }


    public static void main(String[] args) {
//        int[][] ints = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {6, 2}};
        System.out.println(reconstructQueue(ints));
    }
}
