package com.korai.study.ch10.TODO.repository;

import com.korai.study.ch10.TODO.entity.Todo;
import com.korai.study.ch10.TODO.entity.TodoStatus;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private int autoIncrement = 1;
    @Getter // 변수 위에 붙이면 이 변수만 getter, todos 변수에 대해서만 getter(getTodos)를 생성함
    private List<Todo> todos;

    public TodoRepository() {
        todos = new ArrayList<>();
    } // <1>
    public void insert(Todo todo) {
        todo.setId(autoIncrement++);
        todos.add(todo);
    }

    public List<Todo> findAllByUserId(int userId) {
        List<Todo> filteringTodos = new ArrayList<>();
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getUser().getId() == userId) {
                filteringTodos.add(todos.get(i));
            }
        }
        if (filteringTodos.size() == 0) {
            return null;
        }
        return filteringTodos;
    }
    public void updateStatus(int todoId, TodoStatus todoStatus) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == todoId) {
                todos.get(i).setStatus(todoStatus);
                break;
            }
        }
    }
}
/*
<1>
private int autoIncrement = 1;
새 할 일이 추가될 때마다 자동으로 부여할 PK ID* 값의 카운터임 (1부터 시작)
*PK ID :

private List<Todo> todos;
할 일 목록들을 담을 리스트 선언임

public TodoRepository() { todos = new ArrayList<>(); }
생성자를 통해 할 일들을 담을 가변 리스트(ArrayList)를 초기화함

<<< Todo 및 TodoStatus : 참고 엔티티 >>>

*/