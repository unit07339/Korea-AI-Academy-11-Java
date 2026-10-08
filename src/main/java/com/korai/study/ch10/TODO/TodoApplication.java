package com.korai.study.ch10.TODO;

import com.korai.study.ch10.TODO.router.RootRouter;

public class TodoApplication {
    public static void main(String[] args) {
        RootRouter.setUp();

        while(true) {
            RootRouter.getCurrentView().show(); //<1> <11>
        }
    }
}

/*
<1>
RootRouter.setUp();
프로그램이 실행되면 가장 먼저 RootRouter 클래스의 static 메서드인 setUp() 을 호출함
화면 전환에 필요한 모든 객체(Repository, Service, View)를 생성하고 연결함

While(true) {RootRouter.getCurrentView().show();}
무한 루프를 돌면서 RootRouter가 가리키고 있는 현재 화면(getCurrentView())을 가져옴
그 화면의 show() 메서드를 실행함

[ RootRouter.setUp() 타고 들어가기 : 시스템 전체 초기화 ]


<11>
RootRouter.setUp()이 끝나면 TodoApplication의 While 문 안에서 RootRouter.getCurrentView().show();가 호출됨
current의 초깃값은 "login"이므로 LoginView의 show()로 이동함

<<< View : 참고 인터페이스 >>>

[ LoginView로 이동하기 ]

*/