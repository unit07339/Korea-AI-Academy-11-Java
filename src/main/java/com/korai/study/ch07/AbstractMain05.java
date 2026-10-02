package com.korai.study.ch07;

public class AbstractMain05 {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone();
        smartPhone.call();
        FeaturePhone featurePhone = new FeaturePhone();
        featurePhone.print1();
        featurePhone.print2();
        System.out.println(featurePhone.phoneNumber); // 자식요소
    }
}

class Phone {
    String phoneNumber;

    Phone() {
        System.out.println("Phone 생성자 호출"); // smartphone 를 만들었고 아래에 phone을 extends 하기 때문에 new 안해도 이 코드 실행됨
    }

    void call() {
        System.out.println("전화를 건다");
    }
}

class SmartPhone extends Phone {
    SmartPhone() {
        System.out.println("smartPhone 생성자 호출");
    } // 폰이 부모여서 phone 생성자 먼저 실행 후 이 코드 실행

    @Override
    void call() {
        super.call(); // super = 부모
        System.out.println("전화 어플에 들어가서 전화를 건다");
    }
}

class FeaturePhone extends Phone {
    String phoneNumber;

    FeaturePhone() {
        System.out.println("FeaturePhone 생성자 호출");
        phoneNumber = "010-1234-5678";
        super.phoneNumber = "010-1111-1111"; // 부모 폰넘버
    }

    void print1() {
        System.out.println(phoneNumber);
    }

    void print2() {
        System.out.println(super.phoneNumber);
    }
}