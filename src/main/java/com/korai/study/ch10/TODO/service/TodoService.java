package com.korai.study.ch10.TODO.service;

import com.korai.study.ch10.TODO.config.SecurityConfig;
import com.korai.study.ch10.TODO.entity.Todo;
import com.korai.study.ch10.TODO.entity.TodoStatus;
import com.korai.study.ch10.TODO.entity.User;
import com.korai.study.ch10.TODO.repository.TodoRepository;
import com.korai.study.ch10.TODO.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository; // <1>

    public List<Todo> getTodoList() {

        return todoRepository.findAllByUserId(SecurityConfig.getUserId());
    }

    public void register(String content) {
        User foundUser = userRepository.findById(SecurityConfig.getUserId());
        Todo todo = new Todo(0, TodoStatus.todo, content, foundUser);
        todoRepository.insert(todo);
    }

    public void updateStatus(int todoId, TodoStatus todoStatus) {
        todoRepository.updateStatus(todoId, todoStatus);
    }
}

/*
<1>
@RequiredArgsConstructor
Required(final이 붙은) 멤버 변수들을 매개변수로 받는 생성자를 자동으로 만들어 주는 어노테이션

private final TodoRepository todoRepository;
private : 클래스 내부에서만 접근 가능하도록 제한함
final : 이 변수는 한번 값이 정해지면 절대로 바꿀 수 없다(필수값)라는 뜻
TodoService가 할 일을 등록, 조회, 수정 등의 비즈니스 로직을 처리하려면 할 일 저장소(TodoRepository)가 반드시 필요함
따라서 final을 붙여 필수 부품으로 지정해둔 것임

private final UserRepository userRepository;
새로운 할 일을 등록할 때 "누가 이 할 일을 작성했는지" 회원 정보를 찾아와야 함
즉, 회원 정보 저장소(UserRepository)도 필수 부품으로 필요하기 때문에 final을 붙여 선언한 것

[ 다시 RootRouter로 돌아가기 ]


*/