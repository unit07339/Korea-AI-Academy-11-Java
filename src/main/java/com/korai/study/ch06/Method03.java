package com.korai.study.ch06;

public class Method03 {

    public static void main(String[] args) {
        System.out.println(new Student());
        System.out.println(new Student("김준일"));
        System.out.println(new Student("김준일", 33));
        System.out.println(new Student(33, "김준이"));
    }
}
// 오버로딩 + 샏성자
// 자료형 겹치면 안됨 (자료형이 중요함)
class Student {
    String name;
    int age;
    String address;

    Student() {
        System.out.println("이름, 나이 없이 생성");
    }

    Student(String name) {
        System.out.println("이름만으로 생성");
        this.name = name;
    }

    Student(int age) {
        System.out.println("나이만으로 생성");
        this.name = name;
    }


    Student(String name, int age) {
        System.out.println("이름, 나이 받아서 생성");
        this.name = name;
        this.age = age;
    }

    Student(int age, String address) {
        System.out.println("주소, 나이 받아서 생성");
        this.address = address;
        this.age = age;
    } // 반대로 쓰면 가능함



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
