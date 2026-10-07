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
        User foundUser = userRepository.findByUsername(username); // <2>
        if (foundUser == null) {
            return null;
        }
        if (!Objects.equals(foundUser.getPassword(), password)) {
            return null;
        }
        return SecurityConfig.generateSessionToken(foundUser);
    } // <3>
}

/*
<1>
@RequiredArgsConstructor
final 키워드가 붙은 필드를 매개변수로 받아 초기화하는 생성자 자동 생성

private final UserRepository userRepository;
final 키워드로 필수 객체 지정

[ 다시 RootRouter.setUp() 으로 돌아감 ]



<2>
User foundUser = userRepository.findByUsername(username);
userRepository의 findByUsername 메서드를 실행해 유저를 탐색함

[ UserRepository.findByUsername() 타고 들어가기 ]


<3>
if (foundUser == null) {return null;}
유저 정보가 없으면 로그인 실패 (null 리턴)

if (!Objects.equals(foundUser.getPassword(), password)) {return null;}
유저의 실제 비밀번호와 입력값이 일치하지 않으면 로그인 실패 (null 리턴)

return SecurityConfig.generateSessionToken(foundUser);
아이디와 비밀번호가 모두 맞으면 새션 토큰을 생성해 리턴함

[ SecurityConfig.generateSessionToken() 타고 들어가기 : 토큰 생성 ]

*/