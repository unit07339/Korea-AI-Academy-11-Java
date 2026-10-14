package com.korai.study.sp;

public class Function01 {
    public static void main(String[] args) {
        class Wf {
            String date;
            String name;
            String content;

            void Wp() {
                System.out.println("업무일지[ " + date + " ]");
                System.out.println("이름: " + name);
                System.out.println("내용: " + content);
            }
        }
        Wf wf = new Wf();
        wf.date = "2026-09-23";
        wf.name = "한빛";
        wf.content = "복습하기";
        wf.Wp();
    }
}
