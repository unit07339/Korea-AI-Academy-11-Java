package com.korai.study.ch10.TODO.view;

import com.korai.study.ch10.TODO.entity.Todo;
import com.korai.study.ch10.TODO.router.RootRouter;
import com.korai.study.ch10.TODO.service.TodoService;

import java.util.Scanner;

public class TodoListView implements View {

    private Scanner scanner;
    private TodoService todoService;

    public TodoListView(TodoService todoService) {
        this.scanner = new Scanner(System.in);
        this.todoService = todoService;
    }

    @Override // <18~>
    public void show() {
        System.out.println("[ TODO LIST 목록 ]");
        printTodoList(); // <~18>
        showSelectList();
    }

    private void printTodoList() { // <19~>
        if (todoService.getTodoList() == null) { // <19>>
            System.out.println("등록된 할 일이 없습니다."); // <23>
            return;
        }
        for (Todo todo : todoService.getTodoList()) {
            System.out.println(todo);
        }
    }

    private void showSelectList() {
        String cmd;
        System.out.println("1: 할 일 등록");
        System.out.println("2: 완료상태 수정");
        System.out.println("q: 로그아웃");
        System.out.print(">>> ");
        cmd = scanner.nextLine();
        if ("1".equals(cmd)) {
            RootRouter.setCurrent("todo-register");
        } else if ("2".equals(cmd)) {
            RootRouter.setCurrent("todo-status");
        } else if ("q".equals(cmd)) {
            RootRouter.setCurrent("login");
        } else {
            System.out.println("다시입력하세요.");
        }
    }
}
/*
<18>
System.out.println("[ TODO LIST 목록 ]");
제목 출력

printTodoList();
내 할 일 목록을 출력하는 내부 메서드 실행

[ printTodoList() 타고 들어가기 (아래에 있음) ]


<19>
if (todoService.getTodoList() == null) {
가져온 목록이 null 인지 확인함

[ TodoService.getTodoList() 타고 들어가기 ]


<23>
System.out.println("등록된 할 일이 없습니다.");

*/