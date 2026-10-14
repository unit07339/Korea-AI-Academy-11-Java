package com.korai.study.sp.p03;
// 2-2
public class P07 {

//    class Book {
//        String title;
//        Book(String t) { title = t; }
//    }
//    Book b = new Book()

    public static void main(String[] args) {
        class Book {
            String title;

            Book() {}

            Book(String t) { title = t; }
        }
        Book b = new Book("자바");
        Book b1 = new Book();
    }
}

/*
* 사용자가 직접 정의하지 않으면 자동으로 기본 생성자 (Book(){})를 생성하는데
* Book(String t) { title = t; } 같이 사용자가 매개변수가 있는 생성자를 직접 정의해서
* 기본 생성자를 생성하지 않았는데 아래에 Book b = new Book(); 을 호출하려고 해서 컴파일 에러가 발생
* + 기본 생성자를 넣으면 해결됨
 */