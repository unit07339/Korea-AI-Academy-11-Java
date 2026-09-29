package com.korai.study.ch04;

public class ArrayMain02 {
    public static void main(String[] args) {
        // 배열 선언 및 생성, 초기화
        // 배열 선언 => 자료형[] 배열변수명;
        int[] nums1;
        int [][] nums2; // int 배열을 여러 개 묶은 배열 (2차원, 다차원 배열)

        nums1 = new int[3];
        nums2 = new int[2][3]; // 3개 짜리가 2개 , 주소 참조의 순서 때문

        nums2[0][0] = 10;

        int[] nums3 = nums2[0];
        nums3[0] = 100;


        nums2[0][1] = 20;
        nums2[0][2] = 30;
        nums2[1][0] = 40;
        nums2[1][1] = 50;
        nums2[1][2] = 60;

//        int[] nums4 = new int[] { 10, 20, 30, 40, 0 };
        int[] nums4 = { 10, 20, 30, 40}; // 앞의 자료형이 배열이기 때문에 생략 가능

        run(new int[] { 1, 2, 3 });
    }

    static void run(int[] arr) {

    }
}
