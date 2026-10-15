package com.korai.study.ch12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CollectionMain06 {
    public static void main(String[] args) {

        A_5.run();
//        ArrayList<Integer> intList = new ArrayList<>();
//
//        intList.addAll(List.of(85, 92, 78, 96, 88));
//        System.out.println(average(intList));
//        System.out.println(max(intList));


    }

//    static double average(ArrayList<Integer> arr) {
//        System.out.print("평균: ");
//        double total = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            total += arr.get(i);
//        }
//        return total / arr.size();
//    }
//
//    static int max(ArrayList<Integer> arr) {
//        System.out.print("최고점수: ");
//        int max = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            if (arr.get(i) > max) {
//                max = arr.get(i);
//            }
//        }
//        return max;
//    }


}

class A1 {
    static void run() {
        ArrayList<String> strList = new ArrayList<>();
        // 값추가
        strList.add("데이터1");
        // 값 여러개 한번에 추가
        strList.addAll(List.of("데이터2", "데이터3", "데이터4")); // 불변 리스트
        strList.addFirst("데이터5");
        strList.addLast("데이터6");
        strList.add(2, "데이터7");

        System.out.println(strList);

    }
}

class A2 {
    static void run() {
        ArrayList<String> strList = new ArrayList<>();
        strList.addAll(List.of("데이터1", "데이터2", "데이터3", "데이터4"));
        boolean isRemoved = strList.remove("데이터2");
        String removedObject = strList.remove(2);
        strList.addAll(List.of("데이터5", "데이터6", "데이터7", "데이터8"));
        strList.removeAll(List.of("데이터6", "데이터7"));
        System.out.println(strList);

    }
}

class A3 {
    static void run() {
        List<String> strList = List.of("데이터1", "데이터2", "데이터3");
        String data = strList.get(2);
        System.out.println(data);

    }
}

class A4 {
    static void run() {
        List<String> strList = List.of("데이터1", "데이터2", "데이터3");
        boolean isContained = strList.contains("데이터2");
        System.out.println(isContained); // 포함하면 true
        boolean isContained2 = strList.get(1).contains("2");
        System.out.println(isContained2);
    }
}

class A_2 {
    static void run() {
        List<String> list = List.of("Java", "Python", "Java", "C++", "Python", "Go");
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (newList.contains(list.get(i))) {
                continue;
            }
            newList.add(list.get(i));
        }

        System.out.println(list);
        System.out.println(newList);
    }
}

class A_3 {
    static void run() {
        List<Integer> list =  new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }

        List<Integer> newList = new ArrayList<>();

//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (list.get(i) % 3 == 0) {
//                newList.add(list.get(i));
//            } // if문 풀이
//        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 3 == 0) {
                newList.addFirst(list.get(i));
            }
        }
        System.out.println(newList);
    }
}

class A_4 {
    static void run() {
        List<Integer> listA = List.of(5, 2, 8);
        List<Integer> listB = List.of(3, 9, 1);

//        listA.addAll(listB);
        List<Integer> newList = new ArrayList<>(listA);
        newList.addAll(listB); // 풀이

        Collections.sort(newList); // 오름차순

        System.out.println(newList);

        }
    }


class A_5 {
    static void run() {
        List<String> list = new ArrayList<>();
        list.addAll(List.of("사과", "바나나", "포도", "딸기"));

        int index1 = list.indexOf("포도");
        if  (index1 != -1) {
            list.set(index1, "망고");
        }
        list.addFirst("체리");
        list.remove("딸기");
        System.out.println(list);
    }
}



