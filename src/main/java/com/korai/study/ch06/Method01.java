package com.korai.study.ch06;

public class Method01 {
    public static void main(String[] args) {
        Method0101 m = new Method0101(); // static 안붙으면 인스턴스, 인스턴스는 생성을 해야지만
        m.run();
        Method0102.run(); // static 호출
        // new Method0101().run(); -> new Method0101() 하는 거는 인스턴스의 주소를 만든것. 생성과 동시에 호출


    }
}

class Method0101 {
    void run() {
        System.out.println("1");
    }
}

class Method0102 {
    static void run() {
        System.out.println("2");
    }
}

//   class Method0101 {
//    void run(Method0101 bbb) {
//        System.out.println("1");
//  new Method0101().run(new Method0101());
//  새로운 method0101 만드는 것. 앞의 메서드랑 뒤의 메서드는 다름