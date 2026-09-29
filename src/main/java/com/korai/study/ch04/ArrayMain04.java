package com.korai.study.ch04;

import java.util.Arrays;

public class ArrayMain04 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) nums[i] = i + 1;
        System.out.println(arrayToString(nums));
        System.out.println(Arrays.toString(nums));
    }

    static String arrayToString(int[] arr) {
        String str = ""; // 지역 변수 는 무조건 초기화해야 함
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) str += "[ ";
            str += arr[i] + ", ";
            if (i == arr.length - 1) str += "]"; // 한 줄의 명령일 때는 {} 삭제 가능
        }
        return str;
    }
}
