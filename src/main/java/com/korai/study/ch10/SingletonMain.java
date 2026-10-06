package com.korai.study.ch10;

public class SingletonMain {
    public static void main(String[] args) {
        StudentService studentService = StudentService.getInstance();
        StudentService studentService2 = StudentService.getInstance();
        studentService.기능1();
        studentService.기능2();
    }
}


class StudentService {
    // 생성자 외부에서 호출 불가 private. 이 클래스 안에서만 호출 가능
    private static StudentService instance;

    private StudentService() {}
    public static StudentService getInstance() {
        if (instance == null) {
        instance = new StudentService();
        }
        return instance;
    }

    public void 기능1() {

    }
    public void 기능2() {

    }
}
