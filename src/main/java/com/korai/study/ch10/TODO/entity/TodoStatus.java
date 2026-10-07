package com.korai.study.ch10.TODO.entity;

public enum TodoStatus {
    todo("진행전"), inProgress("진행중"), done("완료");

    private String status; // 한글 명칭 저장 필드


    TodoStatus(String status) {
        this.status = status; // 생성자
    }

    public String getStatus() {
        return status; // 한글 명칭 반환
    }


    @Override
    public String toString() {
        return status; // 객체를 출력할 때 "진행전", "진행중", "완료"라는 텍스트로 보여지게 함
    }
}
