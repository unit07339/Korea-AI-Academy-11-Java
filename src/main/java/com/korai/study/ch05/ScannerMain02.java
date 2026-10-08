package com.korai.study.ch05;

import java.util.Scanner;

public class ScannerMain02 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        sc.nextLine();
        String number = sc.nextLine();
        String address = sc.nextLine();

//        String address = sc.next();

        System.out.println("이름: " + name);
        System.out.println("연락처: " + number);
        System.out.println("주소: " + address);

//        System.out.println("이름: " + name + "\n연락처: " + number + "\n주소: " + address);



//        Scanner sc2 = new Scanner(System.in);
//        System.out.print("이름: ");
//        String name = sc2.nextLine();

    }
}
