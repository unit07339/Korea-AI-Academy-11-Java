package com.korai.study.ch04;

public class ArrayMain03 {
    public static void main(String[] args) {
        // 배열을 활용한 반복작업

        int[] nums = new int[100];
        int index = 0;
        while (index < 100) {
            nums[index] = index + 1;
            index++;
        }


        for (int index2 = 0; index2 < 100; index2++) {
            nums[index2] = index2 + 1;
        }
    }
}
