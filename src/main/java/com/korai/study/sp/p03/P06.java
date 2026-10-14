package com.korai.study.sp.p03;
//2-1
public class P06 {
    public static void main(String[] args) {
        class Box {
            int w = 10;
            int h;
            Box() {
                System.out.println(w + " " + h);
                h = w * 2;
            }
        }
        Box b = new Box();
        System.out.println(b.w + " " + b.h);
    }
}
/*
* 10 0
* 10 20
* */