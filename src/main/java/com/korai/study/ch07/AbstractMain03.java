package com.korai.study.ch07;

import java.util.ArrayList;
import java.util.List;

public class AbstractMain03 {
    public static void main(String[] args) {
        Dog2 dog = new Dog2();
        Tiger2 tiger = new Tiger2();
        Animal2 animal = new Animal2();
        Animal2 animal1 = dog; // 상위 개념으로 업캐스팅 했을 때 상위 개념이 안가지고 있으면 쓸 수 없음(bark)
        Animal2 animal2 = tiger;

        animal1.move();
        animal2.move();
        List<Animal2> animals = new ArrayList<>();
        animals.add(new Dog2());
        animals.add(new Tiger2()); //업캐스팅 되면서 add 되고 있음

    }
}

class Animal2 {
    String name;

    void move() {
        System.out.println("움직인다");
    }
}

class Dog2 extends Animal2 {
    @Override // 어노테이션, 코드 실행되는 데는 의미 없음. 재정의된 거라고 다른 사람이 볼 수 있게 함
    void move() {
        System.out.println("많이 움직인다");
    } // 상위 개념에 같은 move 가 있지만 여기서 실행됨 -> 오버라이딩 (재정의)
    void bark() {
        System.out.println("짖다");
    }
}

class Tiger2 extends Animal2 {
    void hunt() {
        System.out.println("사냥하다");
    }
}