package com.korai.study.sp.p03;
// 1-2
public class P02 {
    public static void main(String[] args) {
        char g = 'B';
        int bonus = 0;
        switch (g) {
            case 'A': bonus += 100;
            case 'B': bonus += 50;
            case 'C': bonus += 10; break;
            default: bonus = -1;
        }
        System.out.println(bonus);
    }
}
// 60?
