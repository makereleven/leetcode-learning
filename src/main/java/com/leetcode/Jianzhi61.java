package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * @author mai.gq
 * @date 2020/11/1
 */
public class Jianzhi61 {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子

    }

    public static void main(String[] args) {
        Jianzhi61 jianzhi61 = new Jianzhi61();
        int[] nums = {1, 2, 3, 4, 5};
        jianzhi61.isStraight(nums);
    }
}
