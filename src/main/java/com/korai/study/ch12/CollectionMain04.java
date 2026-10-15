package com.korai.study.ch12;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

class 내가만든예외 extends RuntimeException {
    public 내가만든예외(String message) {
        super(message);
    }
}

public class CollectionMain04 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList();
        nums.add(100);
        nums.add(200);
        nums.add(300);
        nums.add(400);
        nums.add(500);

        try {
            print(nums, nums.size() + 2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("인덱스 초과 오류 해결함.");
        } catch (NullPointerException e) {
            System.out.println("Null 주소 오류 해결함");
        } catch (내가만든예외 e) {
            System.out.println("예외 처리됨!!");
            System.out.println(e.getMessage());
        } catch (Exception e) {

        }
        // else if 랑 같은 느낌

        System.out.println("프로그램 정상 종료");
    }

    static void print(ArrayList<Integer> arr, int size) throws Exception { // 모든 예외들을 다 처리할 수 있음
        System.out.println("리스트크기: " + arr.size());
        if (size == 7) {
            throw new 내가만든예외("내가 강제로 호출한 예외");
        }
        for (int i = 0; i < size; i++) {
                System.out.println(arr.get(i));
        }

        System.out.println();
    }
}
