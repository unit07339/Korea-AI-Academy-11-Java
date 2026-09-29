package com.korai.study.ch03.access;

public class AccessMain4 {
    public static void main(String[] args) {
        School2 s = new School2();
//        s.name = "부경대";
        s.setName("부경대");
    }
}

class AccessMain5 {
    static void run() {
        School2 s = new School2();
    }
}

class School2 {
    private String name;

    //setter 값 대입
    void setName(String name) {
        this.name = name;
    }

    //getter
    String getName() {
        return name;
    }
}
// 독립되어 있어서 new 할 필요 없음 (모듈화)