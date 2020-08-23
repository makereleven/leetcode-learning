package com.leetcode;

/**
 * @author mai.gq
 * @date 2020/7/23
 */
public class Jiayouzhan {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int[] dec = new int[gas.length];
        for (int k = 0; k < gas.length; k++) {
            gasSum += gas[k];
            costSum += cost[k];
            dec[k] = gas[k] - cost[k];
        }
        if (costSum > gasSum) {
            return -1;
        } else {
            for (int i = 0; i < dec.length; i++) {
                if (dec[i] < 0) continue;
                boolean flag = true;
                int sum = dec[i];
                for (int j = i + 1; j < dec.length; j++) {
                    sum += dec[j];
                    if (sum < 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    return i;
                }
            }

            for (int i = dec.length - 1; i >= 0; i--) {
                if (dec[i] < 0) continue;
                boolean flag = true;
                int sum =dec[i];
                for (int j = i - 1; j >= 0; j--) {
                    sum += dec[j];
                    if (sum < 0) {
                        flag = false;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int a[] = {1, 2, 3, 4, 5};
//        int b[] = {3,4,5,1,2};
        int a[] = {2,0,1,2,3,4,0};
        int b[] = {0,1,0,0,0,0,11};
        int i = canCompleteCircuit(a, b);
        System.out.println(i);
    }
}
