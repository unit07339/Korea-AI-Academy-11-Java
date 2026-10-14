package com.korai.study.sp.p03;

public class Book {
    // 클래스 안에는 필드, 메서드 존재 가능
    // 필드 - 1. 인스턴스 필드, 2. static 필드
    String name;
    static String author;
    final String name2 = "초기화1";
    static final String author2 = "초기화2"; // 상수는 초기화 해야함

    // 함수 - 1. 생성자(@NoArgs,All 등 constructor) 2. 인스턴스 메서드, 3. static 메서드
    Book() {} // 생성자
    Book(String name) {this.name = name;} // 생성자 오버로딩
    String getName() {return name;}
    void print() {}  // 인스턴스 메서드
    static String getAuthor() {return author;}
    static void staticPrint() {} // static 메서드

    // 내부 클래스 - 1. 인스턴스 클래스, 2. static 클래스
    class Page {} // 클래스 / 클래스 정의는 존재하지 않은 자료형을 정의하는 것
    static class Page2 {} // static 클래스


}
// static은 class 내부에 딱 하나만 존재함
class BookMain {
    public static void main(String[] args) {
        int a = 10;
        Book b = new Book(); // class Book안에 들어있는게 static, new Book은 인스턴스
        newBook(10, b);// 매개변수에 인자값을 대입하는 행위 -> 주입
        Book.Page p1 = new Book().new Page(); // Book 안에 Page 가 존재하기 때문에. new는 꼭 생성자 앞에 붙여야함
        Book.Page2 p2 = new Book.Page2(); // 인스턴스가 아니어도 static 이기 때문에 클래스 안에 존재함
    } // new Book.Page2(); Book을 new 하는게 아님 Book 안에 있는 Page2 를 new
    // new Book().new Page(); Book울 new , Page new


    public static void newBook(int num, Book book) {

    }
}



