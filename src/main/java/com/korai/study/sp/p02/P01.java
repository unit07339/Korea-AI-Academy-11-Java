package com.korai.study.sp.p02;

public class P01 {
    public static void main(String[] args) {
        System.out.println(MathUtil.max(3, 9, 6));
    }


    public class MathUtil {
        public static int max(int a, int b, int c) {
            int max = a;
            if (b > max)
                max = b;

            if (c > max)
                max = c;

            return max;
        }
    }
}
