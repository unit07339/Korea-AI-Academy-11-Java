package com.korai.study.ch07;

import java.util.Scanner;

public class ObjectMain01 {
    public static void main(String[] args) {
//        final int num;
//        System.out.println(num); // 초기화 해야함, 초기화가 단 한번은 일어나야함

        final int num = 10;
        System.out.println(num);
        Student s1 = new Student(20260001, "김준일"); // 생성하는 타이밍에
        Student s2 = new Student();

        School school = new School("코리아아이티"); // 자바 문법임, 생략되어 있음
    }
}

class School {
    String name;

//    School() {
//
//    }

    School(String name) {
        this.name = name;
    } // 오버로딩 넣을 경우 위의 코드로 정의를 하면  School school = new School(); 쓸 수 있음 / 오버로딩 쓰고 싶으면 직접 정의해야함

}

class Student {
    final int code;       // 필수
    final String name;    // 필수 ,     변할 수 있는 값은 final 풀기
    String address; // 선택

    // NoArgumentsConstructor (인자들이 없는 생성자. 즉, 생성자의 매개변수가 없음)
    Student() {
        code = 0;
        name = null;
    } // 초기화 해주면 쓸 수 있음

    // RequiredArgumentsConstructor (필수 인자들만 받는 생성자.)
    Student(int code, String name) {
        this.code = code;
        this.name = name;
    }

    // AllArgumentsConstructor (모든 인자들을 다 받는 생성자.)
    Student(int code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }
}
// 파라미터 = 매개변수 아규먼츠 = 인자값

class Teacher {
    String name;
    int age;
    String address;

    



}