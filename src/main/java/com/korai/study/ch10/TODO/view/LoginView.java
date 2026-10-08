package com.korai.study.ch10.TODO.view;

import com.korai.study.ch10.TODO.config.SecurityConfig;
import com.korai.study.ch10.TODO.router.RootRouter;
import com.korai.study.ch10.TODO.service.UserService;

import java.util.Scanner;

public class LoginView implements View {

    private UserService userService;
    private Scanner scanner;

    public LoginView(UserService userService) {
        this.userService = userService;
        scanner = new Scanner(System.in);
    }

    @Override
    public void show() {
        String username;
        String password;

        System.out.println("[ TODO LIST 로그인 ]");
        System.out.print("username: ");
        username = scanner.nextLine();
        System.out.print("password: ");
        password = scanner.nextLine();

        String token = userService.login(username, password); // <12>
        if (token == null) {
            System.out.println("로그인 정보를 다시 확인하세요.");
            System.out.print("계속 진행하시려면 엔터를 눌러주세요...");
            scanner.nextLine();
            return;
        }

        SecurityConfig.setLoginSession(token);
        System.out.println(String.format("로그인 성공. %s님 환영합니다.", username));
        RootRouter.setCurrent("todo-list"); // <17>
    }

}

/*
<12>
private UserService userService;
private Scanner scanner;
사용할 서비스 객체와 입력용 스캐너 변수 선언

public LoginView(UserService userService) {
생성자

this.userService = userService;
인자로 전달받은 서비스 주입

scanner = new Scanner(System.in);
키보드 입력을 받는 Scanner 초기화

@Override
public void show() {
화면을 출력하는 인터페이스 메서드 구현

String username;
String password;
입력값을 보관할 지역 변수 선언

System.out.println("[ TODO LIST 로그인 ]");
제목 출력

System.out.print("username: ");
아이디 입력 프롬프트 출력

username = scanner.nextLine();
사용자가 입력한 아이디 읽기

System.out.print("password: ");
비밀번호 입력 프롬프트 출력

password = scanner.nextLine();
사용자가 입력한 비밀번호 읽기

String token = userService.login(username, password);
입력 받은 정보로 userService.login을 호출함

[ UserService.login() 타고 들어가기 : 로그인 검증 ]


<17>
if (token == null) {
토큰이 null이면 (로그인 실패시)

System.out.println("로그인 정보를 다시 확인하세요.");
안내 메시지 출력

System.out.print("계속 진행하시려면 엔터를 눌러주세요...");
대기 메시지 출력

scanner.nextLine();
엔터 입력 대기

return;
show()를 종료하고 돌아가, TodoApplication의 while 문에 의해 로그인 화면을 다시 띄움

SecurityConfig.setLoginSession(token);
로그인 성공 시 static 세션 변수에 발급받은 토큰을 저장함

System.out.println(String.format("로그인 성공. %s님 환영합니다.", username));
환영 메시지 출력

RootRouter.setCurrent("todo-list");}
라우터의 current 변수 값을 "todo-list"로 전환함
LoginView.show() 종료

LoginView.show()가 끝나고 TodoApplication의 while문이 돌면서 RootRouter.getCurrentView()가 실행되고,
current가 "todo-list"로 변경되었으므로 TodoListView의 show()가 시작됨

[ TodoListView로 이동하기 ]

*/
