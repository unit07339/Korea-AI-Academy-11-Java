package com.korai.study.ch07;

public class AbstractMain02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Tiger tiger = new Tiger();
        Animal animal = new Animal();
        Animal animal1 = dog; // 묵시적 형변환
        Animal animal2 = tiger;

    }
}
//  업캐스팅
class Animal {
    String name;

    void move() {
        System.out.println("움직인다");
    }
}

class Dog extends Animal { // 상속
    String name;

    void move() {
        System.out.println("움직인다");
    }

    void bark() {
        System.out.println("짖다");
    }
}

class Tiger extends Animal {
    void hunt() {
        System.out.println("사냥하다"); // animal이 다 가지고 있어서 이름, 움직이다 없애도 됨
    }
}