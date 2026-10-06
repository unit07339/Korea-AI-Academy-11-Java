package com.korai.study.ch08;

import java.util.Objects;

public class Object02 {
    public static void main(String[] args) {

        class Student {
            private String name;
            private int age;

            public Student(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false; // 자료형도 같이 봄
                Student student = (Student) o;
//                return age == student.age && name.equals(student.name); name이 null 일 수도 있어서 안씀
                return age == student.age && Objects.equals(name, student.name); // 이게 더 안전한 코드임
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age); // 안에 들어있는 값만 비교
            }
        }

        Student student1 = new Student("김준일", 33);
        Student student2 = new Student("김준일", 33); // (데이터는 같아도) 위아래 서로 다른 객체
        Student student3 = student1;

        boolean result1 = student1.equals(student2);
        boolean result2 = student1.equals(student3); // 값비교여서 true

        System.out.println(result1);
        System.out.println(result2);
        // 위아래 같은 의미의 코드
        System.out.println(student1 == student2); //  주소비교여서 false
        System.out.println(student1 == student3);

        System.out.println(student1.hashCode() == student2.hashCode());
        System.out.println(student1.hashCode());
        System.out.println(Objects.hash("김준일", 33));
        System.out.println(Objects.hash("김준일33")); // hash 메서드에 넣으면 고유한 값 생성
        System.out.println(Objects.hash(33));


    }
}
