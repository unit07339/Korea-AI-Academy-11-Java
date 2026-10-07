package com.korai.study.ch10.TODO;

import com.korai.study.ch10.TODO.repository.TodoRepository;
import com.korai.study.ch10.TODO.repository.UserRepository;
import com.korai.study.ch10.TODO.router.RootRouter;
import com.korai.study.ch10.TODO.service.TodoService;
import com.korai.study.ch10.TODO.service.UserService;
import com.korai.study.ch10.TODO.view.LoginView;
import com.korai.study.ch10.TODO.view.TodoListView;
import com.korai.study.ch10.TODO.view.View;

import java.util.Map;

public class TodoApplication {
    public static void main(String[] args) {
        RootRouter.setUp();

        while(true) {
            RootRouter.getCurrentView().show();
        }
    }
}

/*
RootRouter.setUp();
프로그램이 실행되면 가장 먼저 RootRouter 클래스의 static 메서드인 setUp() 을 호출해
화면 전환에 필요한 모든 객체(Repository, Service, View)를 생성하고 연결함

While(true) {RootRouter.getCurrentView().show();}
무한 루프를 돌면서 RootRouter가 가리키고 있는 현재 화면(getCurrentView())을 가져와
그 화면의 show() 메서드를 실행함

[ RootRouter.setUp() 타고 들어가기 : 시스템 전체 초기화 ]
*/