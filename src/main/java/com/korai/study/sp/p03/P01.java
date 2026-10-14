package com.korai.study.sp.p03;
// 1-1
public class P01 {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i <= 20; i++) {
            if (i % 4 == 0) continue;
            if (total > 30) break;
            total += i;
        }
        System.out.println(total);
    }
}

// 123 = 6
// 4 X
// 567 = 24
// 8 X
// 9 = 33
// 10 X