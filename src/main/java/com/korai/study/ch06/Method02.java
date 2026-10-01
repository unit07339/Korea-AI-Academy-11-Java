package com.korai.study.ch06;

public class Method02 {
    public static void main(String[] args) {
        System.out.println("100");
        System.out.println(100);
    }
}

// Parameter => 매개변수
// Parameter Overloading
// 함수명이 같을 때 매개변수 자료형으로 구분
// return 자료형에 대해서 오버로딩이 되는 것은 아님

class Parameter01 {
    static void 세탁하기() {

    }
    static void 세탁하기(int 세제) {

    }

    static void 세탁하기(double 세제) {

    }

    static void 세탁하기(int 세제, int 섬유유연제) {

    }
}
