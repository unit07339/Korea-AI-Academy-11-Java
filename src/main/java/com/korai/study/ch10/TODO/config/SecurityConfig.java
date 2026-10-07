package com.korai.study.ch10.TODO.config;

import com.korai.study.ch10.TODO.entity.User;

import java.util.UUID;

public class SecurityConfig {
    private static String loginSession = null;

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
    }

    public static int getUserId() {
        int startIndex = loginSession.indexOf("@") + 1;
        String userIdStr = loginSession.substring(startIndex);
        return Integer.parseInt(userIdStr);
    }
}
