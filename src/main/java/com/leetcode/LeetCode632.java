package com.leetcode;

import java.util.*;

/**
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * <p>
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * <p>
 * 示例 1:
 * <p>
 * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出: [20,24]
 * 解释:
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 *
 * @author mai.gq
 * @date 2020/8/1
 */
public class LeetCode632 {
//    public static int[] smallestRange(List<List<Integer>> nums) {
//        int size = nums.size();
//        Map<Integer, List<Integer>> indices = new HashMap<Integer, List<Integer>>();
//        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
//        for (int i = 0; i < size; i++) {
//            for (int x : nums.get(i)) {
//                List<Integer> list = indices.getOrDefault(x, new ArrayList<Integer>());
//                list.add(i);
//                indices.put(x, list);
//                xMin = Math.min(xMin, x);
//                xMax = Math.max(xMax, x);
//            }
//        }
//
//        int[] freq = new int[size];
//        int inside = 0;
//        int left = xMin, right = xMin - 1;
//        int bestLeft = xMin, bestRight = xMax;
//
//        while (right < xMax) {
//            right++;
//            if (indices.containsKey(right)) {
//                for (int x : indices.get(right)) {
//                    freq[x]++;
//                    if (freq[x] == 1) {
//                        inside++;
//                    }
//                }
//                while (inside == size) {
//                    if (right - left < bestRight - bestLeft) {
//                        bestLeft = left;
//                        bestRight = right;
//                    }
//                    if (indices.containsKey(left)) {
//                        for (int x: indices.get(left)) {
//                            freq[x]--;
//                            if (freq[x] == 0) {
//                                inside--;
//                            }
//                        }
//                    }
//                    left++;
//                }
//            }
//        }
//
//        return new int[]{bestLeft, bestRight};
//    }

    public static int[] smallestRange(List<List<Integer>> nums) {

        int size = nums.size();
        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
        Map<Integer,List<Integer>> map = new HashMap();

        for(int i = 0;i<size;i++){
            System.out.println(nums.get(i).get(0));
            xMin = Math.min(xMin,nums.get(i).get(0));
            int s = nums.get(i).size()-1;
            xMax = Math.max(xMax,nums.get(i).get(s));
            System.out.println(nums.get(i).get(s));
            for(Integer x: nums.get(i)){
                List<Integer> list = map.getOrDefault(x, new ArrayList<Integer>());
                list.add(i);
                map.put(x,list);
            }
        }

        int bestLeft = xMin,bestRight=xMax;
        int left = xMin, right = xMin-1;
        int []  ins = new int[3];
        int inc = 0;
        while (right<xMax){
            right++;
            if(map.containsKey(right)){
                List<Integer> k = map.get(right);
                for(int i : k){
                    ins[i]++;
                    if(ins[i]==1){
                        inc++;

                    }
                }


                while(inc==size){
                    if(right-left<bestRight-bestLeft){
                        bestLeft=left;
                        bestRight=right;
                    }
                    if(map.containsKey(left)){
                        List<Integer> g = map.get(left);
                        for(int i : g){
                            ins[i]--;
                            if(ins[i]==0){
                                inc--;
                            }
                        }
                    }
                    left++;

                }
            }
        }
        return new int[]{bestLeft, bestRight};
    }




    public static void main(String[] args) {
        Integer[] in = {4, 10, 15, 24, 26};
        Integer[] in1 = {0, 9, 12, 20};
        Integer[] in2 = {5, 18, 22, 30};
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> n = Arrays.asList(in);
        List<Integer> n1 = Arrays.asList(in1);
        List<Integer> n2 = Arrays.asList(in2);
        nums.add(n);
        nums.add(n1);
        nums.add(n2);
        smallestRange(nums);
    }
}
