package com.korai.study.ch07;

import java.util.LinkedList;
import java.util.List;

public class AbstractMain04 {
    public static void main(String[] args) {
        Dog3 dog = new Dog3();
        Tiger3 tiger = new Tiger3();
        Animal3 animal = new Animal3();
        Animal3 animal1 = dog; // 상위 개념으로 업캐스팅 했을 때 상위 개념이 안가지고 있으면 쓸 수 없음(bark)
        Animal3 animal2 = tiger;

        animal1.move();
        animal2.move();

        Dog3 animal1ToDog = (Dog3) animal1; // 다운캐스트
        animal1ToDog.bark();
        ((Dog3) animal1).bark();

//        Dog3 animal2ToDog = (Dog3) animal2; // 다운캐스팅
//        animal2ToDog.bark();
//        ((Dog3) animal2).bark();

        List<Animal3> animal3s = new LinkedList<>();
        animal3s.add(new Dog3());
        animal3s.add(new Tiger3());
        animal3s.add(new Dog3());

        for (int i = 0; i < animal3s.size(); i++) {
            animal3s.get(i).move();
            if (animal3s.get(i) instanceof Dog3) {
                Dog3 d = (Dog3) animal3s.get(i);
                d.bark();
            } else if (animal3s.get(i) instanceof Tiger3) {
                Tiger3 t = (Tiger3) animal3s.get(i);
                t.hunt();
            }
        }

    }
}

class Animal3 {
    String name;

    void move() {
        System.out.println("움직인다");
    }
}

class Dog3 extends Animal3 {
    @Override // 어노테이션, 코드 실행되는 데는 의미 없음. 재정의된 거라고 다른 사람이 볼 수 있게 함
    void move() {
        System.out.println("많이 움직인다");
    } // 상위 개념에 같은 move 가 있지만 여기서 실행됨 -> 오버라이딩 (재정의)
    void bark() {
        System.out.println("짖다");
    }
}

class Tiger3 extends Animal3 {
    void hunt() {
        System.out.println("사냥하다");
    }
}