package com.korai.study.ch10.TODO.config;

import com.korai.study.ch10.TODO.entity.User;

import java.util.UUID;

public class SecurityConfig {
    private static String loginSession = null; // <1>

    public static String getLoginSession() {
        return loginSession;
    }

    public static void setLoginSession(String loginSession) {
        SecurityConfig.loginSession = loginSession; // 앞에 this X, this는 인스턴스 앞에. 클래스 안에 있는 static이라 X
    }

    public static String generateSessionToken(User user) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        int userId = user.getId();
        String token = uuid + "@" + userId;
        return token;
    } // <1>

    public static int getUserId() {
        int startIndex = loginSession.indexOf("@") + 1;
        String userIdStr = loginSession.substring(startIndex);
        return Integer.parseInt(userIdStr);
    }
}

/*
private static String loginSession = null;
로그인한 사용자의 토큰을 기억할 전역 static 변수임

String uuid = UUID.randomUUID().toString().replaceAll("-","");
무작위 식별자 고유 문자열(UUID)을 만들고 하이픈(-)을 모두 지움

int userId = user.getId();
로그인된 유저의 PKID 값을 가져옴

String token = uuid + "@" + userId;
"랜덤문자열@유저ID"형태의 토큰 문자열을 만듦

return token;
만들어진 토큰을 반환함

[ 다시 LoginView.show()로 돌아간다 ]

*/