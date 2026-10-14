package com.korai.study.sp.p03;
// 2-3
public class P08 {
    public static void main(String[] args) {
        class Book {
            String title;
            int price;

            Book(String title) {
                this.title = title;
                this.price = 10000;
            }
            Book(String title, int price) {
                this.title = title;
                this.price = price;
            }
        }
        Book book = new Book("자바"); // book 인스턴스, class 자료형에는 new 한것만 넣을 수 있음
        Book book1 = new Book("자바2", 20000);


    }
}

// class Book {
//            String title;
//            int price;
//
//            Book(String title) {
//                this(title, 10000, "저자없음")
//            }
//
//            Book(String title, String author) {
//            this(title, 10000, author);
//
//            Book(String title, int price) {
//            this(title, price, "저자없음")
//
//            Book(String title, int price, String author) {
//                this.title = title;
//                this.price = price;
//                this.author = author;
//            } 다 받는거 하나 만들어놓고 위에 this() 생성자 / 프록시? 사용해서