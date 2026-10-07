package com.korai.study.ch10.TODO.repository;

import com.korai.study.ch10.TODO.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
            User user1 = new User(1, "test1", "1q2w3e4r!", "김준일");
            User user2 = new User(2, "test2", "1q2w3e4r!", "김준이");
            User user3 = new User(3, "test3", "1q2w3e4r!", "김준삼");
            User user4 = new User(4, "test4", "1q2w3e4r!", "김준사");
            users = List.of(user1, user2, user3, user4);
        } // <1>

        public User findByUsername(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}

/*
<1>
private List<User> user;
회원 목록을 보관할 리스트 변수임

public UserRepository() {
기본 생성자 시작

User user1 = new User(1, "test1", "1q2w3e4r!", "김준일"); ~ User user4 = ... ;
Lombok의 @AllArgsConstructor가 들어간 User 엔티티 객체 4개를 만듦
각각 (id, username, password, name) 순으로 전달됨
<<< User 타고 들어가기 : 참고 엔티티 >>> 참고만 하기

users = List.of(user1, user2, user3, user4);
생성된 4명의 회원 객체를 읽기 전용 리스트로 만들어 users 변수에 할당함

[ 다시 RootRouter.setUp()으로 돌아감 ]

*/