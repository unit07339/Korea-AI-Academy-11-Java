package com.korai.study.ch12;

import lombok.AllArgsConstructor;

public class CollectionMain02 {
    public static void main(String[] args) {
        CustomLinkedList<String> list1 = new CustomLinkedList();
        list1.add("자바");
        list1.add("자바2");
        list1.add("자바3");
        System.out.println(list1);
        System.out.println(list1.get(2));
        list1.remove(1);
        System.out.println(list1);

    }
}

// LinkedList -> 선형리스트(단방향)
// 노드를 연결한다.
// 노드란? 연결된 다른 노드들의 주소와 저장할 값을 포함한 것

class CustomLinkedList<E> {
    @AllArgsConstructor
    private static class Node<E> {
        E item; // 데이터 저장
        Node<E> next;
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<E> current = head; // 탐색을 시작할 위치로 head(첫 번째 노드)를 지정
        for (int i = 0; i < size; i++) {
            builder.append(current.item); // 현재 노드가 갖고 있는 값(데이터)을 추가
            if (i != size - 1) {
                builder.append(", "); // 마지막 데이터가 아니라면 데이터 뒤에 ", "를 붙임
            }
            current = current.next; // 다음 노드의 주소를 타고 이동
        }
        builder.append("]");
        return builder.toString(); // 조립 완료된 StringBuilder를 완성된 String으로 변환해서 반환
    }


    public void add(E e) { // E 는 전부 String
        Node<E> newNode = new Node<>(e, null);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E get(int index) {// 리스트에서 가져오고 싶은 데이터의 위치 번호(index)를 매개변수로 받는 메서드/ E = String
        if (!(index < size && index > -1)) {
            throw new IndexOutOfBoundsException("인덱스 범위를 초과하였습니다."); // 예외처리
        }
        Node<E> current = head; // 첫 번째 노드(0번) 부터 출발 / 현재 위치를 기억하기 위해 current 임시 변수에 head 주소를 담기, 연결 리스트는 인덱스에 바로 접근 불가, 0번노드부터 순서대로 징검다리를 건넘
        for (int i = 0; i < index; i++) {
            current = current.next;
        } // 현재 노드가 들고 있는 다음 노드의 주소(next)를 타고 다음 칸으로 한 칸 이동
        return current.item; // for 반복이 끝나면 current는 목적지인 index 위치의 노드에 도착함, 그 노드 상자에 있는 실제 값인 current.item을 꺼내서 메서드를 호출한 쪽에 돌려줌
    } // 0번 칸(head)에서 출발해서 index에 적힌 숫자만큼 다음 칸(next)으로 이동한 뒤, 도착한 칸의 알맹이(item)를 꺼내주는 코드

//    public E get(int i) {
//        Node<E> current = head;
//        int index = 0;
//        while (index < i) {
//            current = current.next;
//        }
//        return current.item;
//    }




    public E remove(int index) { // 리스트에서 지우고 싶은 index를 전달받아 지워지는 데이터(E)를 리턴해주는 삭제 메서드
        if (!(index < size && index > -1)) { // 인덱스 예외 처리 (안전장치)
            return  null;
        } // 지우려는 위치가 음수이거나 전체 크기 이상인 경우 에러 없이 안전하게 null을 반환하고 메서드를 종료
        if (index == 0) { // 맨 앞(0번 노드)을 지우는 예외 처리
            E item = head.item; // 0번 노드의 데이터 미리 보관
            head = head.next; // head 위치를 두 번째 노드로 넘김 (0번 노드는 연결이 끊어짐)
            size--; // 리스트 크기 1 감소
            return item; // 지워진 데이터 반환
        }

        // 지울 노드의 바로 앞 노드로 이동하기
        Node<E> current = head;
        for (int i = 0; i < index -1; i++) {
            current = current.next;
        } // 지우고 싶은 노드로 직접 가면 앞 노드의 선을 끊을 수 없어서 index - 1 번만 반복해서 current를 지울 노드의 바로 앞 노드 위치에 멈춤
        // 지워질 노드의 진짜 데이터 꺼내기
        E item = current.next.item; // current는 지울 노드의 바로 앞 노드, 즉 삭제될 대상 노드는 current.next이며 그 노드가 가지고 있던 데이터(item)를 꺼내서 변수에 잘 보관해 둠
        current.next = current.next.next; // 화살표 건너뛰기 (실제 노드 삭제), 바로 앞 노드(current)의 next 선을 그 다음다음 노드current.next.next로 직접 이어버림
        size--; // 리스트 크기 1 감소
        return item; // 보관해둔 지워진 데이터 반환
    } // 전체 데이터 개수를 1 줄이고 아까 보관해 두었던 삭제된 데이터(item)를 리턴하며 마무리


}

/* 1. index = 1 이 들어옴
 * 2. index == 0 이 아니므로 넘어감
 * 3. for (int i = 0; i < 0; i++) 조건에 의해 for문은 한 번도 안돌고 current는 0번 노드("자바")에 멈춤
 * 4. current.next 인 1번 노드("자바2")에서 .item인 자바2를 꺼내 item 변수에 저장
 * 5. current.next = current.next.next; 명령으로 자바의 next가 자바3을 직접 가리킴
 * 6. 연결이 끊어진 자바2 노드는 삭제되고 남은 리스트는 자바, 자바3 가 됨
 * */

