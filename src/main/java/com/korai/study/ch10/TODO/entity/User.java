package com.korai.study.ch10.TODO.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Getter, Setter, toString, equals, hashCode 자동 생성
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자 자동 생성
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
} // <1>

/*
<1>
UserRepository의 <1> 참고
*/