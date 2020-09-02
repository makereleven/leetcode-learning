package com.leetcode.Josephus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 约瑟夫环
 *
 * @author mai.gq
 * @date 2020/9/1
 */
public class Josephus {
    public static void yesefu(int personNumber, int number) {
//1.把人放到队列中
        Queue<Integer> persons = new LinkedList<Integer>();
        for (int i = 0; i < personNumber; i++) {
            persons.add(i + 1);
        }

        //2.算法
        int counts = 0;//计数器
        while (!persons.isEmpty()) {
            //1.出队列
            Integer person = persons.poll();
            //2.计数器++
            counts++;
            //3.判断
            if (counts % number == 0) {
                //是,打印
                System.out.println(person);
            } else {
                //不是,继续入队列
                persons.add(person);
            }
        }
    }

    public static void main(String[] args) {
        yesefu(10, 3);
    }
}
