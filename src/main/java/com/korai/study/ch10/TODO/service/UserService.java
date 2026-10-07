package com.korai.study.ch10.TODO.service;

import com.korai.study.ch10.TODO.config.SecurityConfig;
import com.korai.study.ch10.TODO.entity.User;
import com.korai.study.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository; // <1> , final은 무조건 초기화

    public String login(String username, String password) {
        User foundUser = userRepository.findByUsername(username);
        if (foundUser == null) {
            return null;
        }
        if (!Objects.equals(foundUser.getPassword(), password)) {
            return null;
        }
        return SecurityConfig.generateSessionToken(foundUser);
    }
}

/*
<1>
@RequiredArgsConstructor
final 키워드가 붙은 필드를 매개변수로 받아 초기화하는 생성자 자동 생성

private final UserRepository userRepository;
final 키워드로 필수 객체 지정

[ 다시 RootRouter.setUp() 으로 돌아감 ]


*/