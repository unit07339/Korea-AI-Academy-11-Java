package com.korai.study.ch07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AbstractMain01 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        ArrayList<String> n = (ArrayList<String>) names;
        names.add("김준일");
        names.add("김준이");
        names.add("김준삼");
        System.out.println(names);

        LinkedList<String> names2 = new LinkedList<>();
        names2.add("김준일");
        names2.add("김준이");
        names2.add("김준삼"); // add 추상화 요소
        System.out.println(names2);

//        List<String> names = new ArrayList<>(); or LinkedList<>();
//        names.add("김준일");
//        names.add("김준이");
//        names.add("김준삼");
//        System.out.println(names); 도 가능함

        List<List<String>> lists = new ArrayList<>(); // <List<String>> 뜻 list를 상속받으면 모두 들어올 수 있음
        double [][] doubles = new double[2][2];
        lists.add(new ArrayList<>());
        lists.add(new LinkedList<>());
        lists.add(new ArrayList<>());
        lists.get(0).get(0); // 이 리스트 안에서 0번째 인덱스 가져오라는 뜻

        double d = 10;
        int i = (int) d;


    }
}
