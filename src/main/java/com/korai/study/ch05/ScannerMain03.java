package com.korai.study.ch05;

import java.util.Scanner;

public class ScannerMain03 {
    public static void main(String[] args) {

        // 계속 추가하시겠습니까? y/n y
        // 입력: 10
        // 계속 추가하시겠습니까? y/n y
        // 입력: 20
        // 계속 추가하시겠습니까? y/n y
        // 입력: 30
        // 계속 추가하시겠습니까? y/n y
        // 입력: 40
        // 계속 추가하시겠습니까? y/n n
        // 총합: 100

     /*
     일단 while 로  계속 추가~ 반복. 그리고 yn 입력 가능해야함

     조건문으로 대소문자 상관없이 y가 입력되면 입력: 이 출력되고 숫자를 넣을 수 있어야함

     n이 입력 되면 반복 그만하고 합 구하기??
     */

        int[] nums = new int[0];
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("계속 추가하시겠습니까? y/n: ");
            String yn = sc.nextLine();

            if ("y".equalsIgnoreCase(yn)) {
                System.out.print("입력: ");
                int input = sc.nextInt();
                sc.nextLine();

                int[] newNums = new int[nums.length + 1];

                for (int i = 0; i < nums.length; i++) {
                    newNums[i] = nums[i];
                }

                newNums[newNums.length - 1 ] = input;
                nums = newNums;


            } else if ("n".equalsIgnoreCase(yn)) {

                int sum = 0;

                for (int i = 0; i < nums.length; i++) {
                    sum += nums[i];
                }

//                for (int num : nums) {
//                    sum += num;
//                }

                System.out.println("총합: " + sum);
                break;

            }
        }
    }
}
