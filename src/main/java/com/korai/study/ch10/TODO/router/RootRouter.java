package com.korai.study.ch10.TODO.router;

import com.korai.study.ch10.TODO.entity.TodoStatus;
import com.korai.study.ch10.TODO.repository.TodoRepository;
import com.korai.study.ch10.TODO.repository.UserRepository;
import com.korai.study.ch10.TODO.service.TodoService;
import com.korai.study.ch10.TODO.service.UserService;
import com.korai.study.ch10.TODO.view.*;

import java.util.Map;

public class RootRouter {
    private static String current = "login";
    private static Map<String, View> viewMap;

    public static void setUp() {
        UserRepository userRepository = new UserRepository(); // <1>
        UserService userService = new UserService(userRepository); // <2>
        LoginView loginView = new LoginView(userService);

        TodoRepository todoRepository = new TodoRepository(); // <3>
        TodoService todoService = new TodoService(todoRepository, userRepository);
        TodoListView todoListView = new TodoListView(todoService);

        TodoRegisterView todoRegisterView = new TodoRegisterView(todoService);
        TodoStatusView todoStatusView = new TodoStatusView(todoService);

        viewMap = Map.of(
                "login", loginView,
                "todo-list", todoListView,
                "todo-register", todoRegisterView,
                "todo-status", todoStatusView
        );
    }

    public static String getCurrent() {
        return current;
    }

    public static void setCurrent(String path) {
        current = path;
    }

    public static View getCurrentView() {
        return viewMap.get(current);
    }
}

/*
<1>
private static String current = "login";
현재 실행 중인 화면의 키(Key) 값을 보관하는 멤버 변수임
기본 값은 "login"으로 초기화되어 로그인 화면부터 시작됨

private static Map<String, View> viewMap;
화면 이름(String)과 화면 객체(View)를 짝지어 관리할 Map 구조 선언임

public static void setUp() {
전체 라우팅 초기화 메서드 시작임

UserRepository userRepository = new UserRepository();
UserRepository 객체를 생성함
생성자가 호출되면서 더미* 회원들이 리스트에 등록
*더미 : 가짜(시뮬레이션용) 회원 데이터 -> test1~test4

[ UserRepository 타고 들어가기 : 회원 데이터 저장소 ]


<2>
UserService userService = new UserService(userRepository);
비즈니스 로직을 다루는 UserService 객체를 생성하고, 위에서 만든 userRepository를 의존성 주입*(Dependency Injection) 해줌
* 의존성 주입 : 어떤 클래스가 필요로하는 다른 객체를 직접 만들지 않고, 외부에서 쥐어주는(전해주는) 것

[ UserService 타고 들어가기 : 회원 비즈니스 로직 ]


<3>
LoginView loginView = new LoginView(userService);
로그인 화면 객체를 생성하고, 방금 만든 userService를 인수로 전달함

TodoRepository todoRepository = new TodoRepository();
TodoRepository 객체를 생성함

[ TodoRepository 타고 들어가기 : 할 일 데이터 저장소 ]

*/