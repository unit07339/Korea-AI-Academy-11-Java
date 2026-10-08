package com.korai.study.ch05;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerMain04 {
    public static void main(String[] args) {

        // 현재 배열: [ 10, 20, 50, 30, 80 ]
        // 삭제할 값 입력: 30
        // 현재 배열: [ 10, 20, 50, 80 ]
        // 삭제할 값 입력: 20
        // 현재 배열: [ 10, 50, 80 ]
        // 삭제할 값 입력: 10
        // 현재 배열: [ 50, 80 ]
        // 삭제할 값 입력: 80
        // 현재 배열: [ 50 ]
        // 삭제할 값 입력: 50
        // 현재 배열: [ ]
        // 삭제할 값 입력: 90
        // 해당 값은 배열에 존재하지 않습니다.
        // 무한루프

        /*
        배열 생성
        입력 기능

        현재 배열 프린트
        삭제할 값 입력 프린트 후 삭제값 입력받기

        삭제값 입력 받은 거를 배열에서 삭제하기

        이걸 반복

        배열에 없는 숫자 입력하면 존재하지 않다 프린트

        */

        int[] nums = new int[] { 10, 20, 50, 30, 80 };
        Scanner sc = new Scanner(System.in);


        while (true) {

            System.out.println("현재 배열: " + Arrays.toString(nums));

            System.out.print("삭제할 값 입력: ");
            int dn = sc.nextInt();
            sc.nextLine();

            // 삭제를 어케 하지.............................................

            // 배열에 값이 있는지 확인해야 하나???? 있으면 삭제..?
            for (int i = 0; i < nums.length; i++) {
                if ( nums[i] == dn ) {
                    // 같으면 뭐... 같으면 뭘해야하지.. 변수 하나 지정해서 삭제용 변수로 만드는 건가........

                }

            }

            }

//        if () {
//            System.out.println("해당 값은 배열에 존재하지 않습니다.");
//        }

        // 배열에 없는 값을 어케 조건식으로 설정???!




    }
}
