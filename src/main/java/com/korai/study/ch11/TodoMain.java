package com.korai.study.ch11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 싱글톤 - 유일 하나의 인스턴스 객체를 만들어서 모두가 공유해서 재사용

public class TodoMain {
    public static int pathIndex = 0;
    public static boolean running = true;

    public static void main(String[] args) {
        List<View> viewList = new ArrayList<>(); // 앞으로 View 타입 객체들만 담을 수 있는 빈 리스트(ArrayList)를 메모리에 새로 생성하고, 그 리스트를 viewList라는 변수에 담아두겠다는 의미
        viewList.add(HomeView.getInstance()); // new HomeView() 인스턴스 객체
        viewList.add(RegisterView.getInstance());
        viewList.add(ListView.getInstance()); // 호출되는 순간 객체 생성되고 ViewList에 추가됨

//        viewList.get(0).show(); // get = 가져오는 것
//        viewList.get(2).show();

        Scanner scanner = new Scanner(System.in);


        while (true) {
            viewList.get(pathIndex).show();
        }
    }
}

// Object(최상위) 클래스
@Data
@NoArgsConstructor
@AllArgsConstructor
// 정보를 관리할 수 있도록 도와줄 Entity 클래스
class Todo {
    private int id;
    private String content;
}

// new X
// 기능을 추상화 할 때
// 인터페이스로 기능을 추상화 했으면 구현 객체는 무조건 존재할 것이다.
interface View {
    void show();
}

// new O
// 클래스는 생성(메모리에 인스턴스를 실존하게 하는 것) 가능해야한다.
class HomeView implements View {

    // 싱글톤 2번. 해당 클래스 자료형의 인스턴스를 담아둘 static 변수를 선언한다.
    // private으로 외부 접근 제한
    private static HomeView instance;

    // 싱글톤 1번. 생성자를 private으로 정의한다.
    // private 접근제한자는 해당 클래스 내부에서만 접근할 수 있다.
    // 생성자를 숨겼다는 것은 외부에서 생성을 제한하기 위함이다.
    private HomeView() {

    }

    // 싱글톤 3번. static 변수 instance가 null일 때 인스턴스를 생성
    // static getter를 통해서만 instance를 접근할 수 있게 유도
    public static HomeView getInstance() {
        while (instance == null) {
            instance = new HomeView();
        }
        return instance;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String menu;
        System.out.println("[ HOME ]");
        System.out.println("R. TODO 등록하기 ");
        System.out.println("L. TODO 목록조회 ");
        System.out.println("Q. 프로그램 종료 ");
        System.out.print(">>> ");
        menu = scanner.nextLine().trim();
        menu = String.valueOf(menu.charAt(0));
//        System.out.println(menu.matches("[a-zA-Z]"));
        boolean isAlphabet = menu.matches("[a-zA-Z]");
        if (!isAlphabet) {
            System.out.println("영문자만 입력 가능합니다");
            return;
        }
        menu = menu.toUpperCase();
        if ("Q".equals(menu)) {
            TodoMain.running = false;
        } else if ("R".equals(menu)) {
            TodoMain.pathIndex = 1;
        } else if ("L".equals(menu)) {
            TodoMain.pathIndex = 2;
        } else {
            System.out.println("다시 입력하세요.");
        }
    }
}


class RegisterView implements View {

    private static RegisterView instance;

    private RegisterView() {

    }

    public static RegisterView getInstance() {
        while (instance == null) {
            instance = new RegisterView();
        }
        return instance;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String content;
        System.out.println("[ REGISTER ]");
        System.out.println("내용을 입력하세요. ");
        System.out.print(">>> ");
        content = scanner.nextLine().trim();
        Todo newTodo = new Todo();
        newTodo.setContent(content); // setter
        TodoRepository.getInstance().insert(newTodo);
        System.out.println("TODO 등록 완료.");
        TodoMain.pathIndex = 0;
    }
}


class ListView implements View {

    private static ListView instance;

    private ListView() {

    }

    public static ListView getInstance() {
        while (instance == null) {
            instance = new ListView();
        }
        return instance;
    }

    @Override
    public void show() {
        System.out.println("[ LIST ]");
        List<Todo> todos = TodoRepository.getInstance().findAll();
        if (todos.size() == 0) {
            System.out.println("등록된 TODO가 없습니다.");
            TodoMain.pathIndex = 0;
            return;
        }
        for (Todo todo : todos) {
            System.out.println(todo);
        }
        TodoMain.pathIndex = 0;
    }
}

interface Repository<T> {
    void insert(T t);
    void update(T t);
    T delete(int id);
    T findById(int id);
    List<T> findAll();
}

class TodoRepository implements Repository<Todo> {  // ctrl + i
    private static TodoRepository instance;
    private int lastId;
    private List<Todo> todos; // 인스턴스 변수
    
    private TodoRepository() {
        lastId = 1;
        todos = new ArrayList<>();
    }
    
    public static TodoRepository getInstance() {
        if (instance == null) {
            instance = new TodoRepository();
        }
        return instance;
    }
    
    @Override
    public void insert(Todo todo) { // 인스턴스 메서드
        todo.setId(lastId++);
        todos.add(todo);
    }

    @Override
    public void update(Todo todo) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == todo.getId()) {
                todos.set(i, todo); // set은 바꾸는 거
                break;
            }
        }
    }

    @Override
    public Todo delete(int id) {
        for (int i =0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                return todos.remove(i);
            }
        }
        return null;
    }

    @Override
    public Todo findById(int id) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId() == id) {
                return todos.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Todo> findAll() {
//        List<Todo> copyTodos = new ArrayList<>();
//        copyTodos.addAll(todos);
//        return copyTodos; // 변경 가능한 리스트
        return List.copyOf(todos); // 불변 리스트
    }
}


/*
main 클래스 먼저 보기
List<View> viewList = new ArrayList<>();
-> View 타입의 객체들만 담을 수 있는 빈 리스트를 메모리에 새로 생성하고 그 리스트를 viewList라는 변수에 담아둠

=> View 타고 들어가기

interface View {void show();}
-> show라는 기능을 추상화한 View


viewList.add(HomeView.getInstance());
viewList.add(RegisterView.getInstance());
viewList.add(ListView.getInstance());
-> viewList에 HomeView.getinstance(), RegisterView.getInstance(), ListView.getinstance() 를 추가함

=> HomeView 타고 들어가기

class HomeView implements View {
-> 인터페이스 View를 상속받는 HomeView 클래스

싱글톤 조건 1.
private HomeView() {}
생성자를 private로 정의함

싱글톤 조건 2.
private static HomeView instance;
->  해당 클래스 자료형의 인스턴스를 담아둘 static 변수를 선언함

싱글톤 조건 3.
public static HomeView getInstance() {
while (instance == null) {instance = new HomeView();}
return instance;
}
-> staic 변수 instance가 null일 때 인스턴스를 생성
HomeView 를 반환값으로 가지는 getInstance() 메서드 생성
무한반복문 ( instance가 null이면 instance는 새 HomeView를 만듦
반복문이 끝나면 instance 로 리턴값을 받음

=> main에서 RegusterView로 타고 들어가기

class RegisterView implements View {
private static RegisterView instance;
private RegisterView() {}
public static RegisterView getInstance() {
while (instance == null) {
instance = new RegisterView();
}
return instance;
}

-> 인터페이스 View를 상속받는 클래스 RegisterView 를 생성
싱글톤으로 만들어야해서 생성자 private 정의 후 RegisterView 자료형의 static 변수 instance를 선언함
HomeView를 반환값으로 가지는 getInstance() 메서드를 생성 후 무한반복문(instance 가 null 일 때 새 RegisterView를 만들고 instance에 저장?)  반복 끝나면 instance를 리턴값으로 가짐

=> main에서 ListView로 타고 들어가기

class ListView implements View {
private static ListView instance;
private ListView() {}
public static ListView getInstance() {
while (instance == null) {
instance = new ListView();
}
return instance;
}

-> 인터페이스 View를 상속받는 클래스 ListView 생성 후 싱글톤 만들기
private ListView 생성자 만들고 ListView를 반환값으로 가지는 static 변수 instance를 선언
ListView 를 반환값으로 가지는 getInstance() 메서드 생성 후 무한반복문(instance 가 null 값을 가지면 새 ListView를 생성 후 instance에 저장?) 반복 끝나면 instance를 리턴값으로 가짐

=> main으로 돌아가기

Scanner scanner = new Scanner(System.in);
-> 입력받을 수 있는 기능

while (true) {viewList.get(pathIndex).show();}
-> 조건이 true 면 무한반복, viewList에 pathIndex 값의 인덱스의 show 기능으로 이동?
pathIndex는 TodoMain 클래스 안에서 0으로 정의되어있어서 HomeView의 show로 이동

@Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String menu;
        System.out.println("[ HOME ]");
        System.out.println("R. TODO 등록하기 ");
        System.out.println("L. TODO 목록조회 ");
        System.out.println("Q. 프로그램 종료 ");
        System.out.print(">>> ");
        menu = scanner.nextLine().trim();
        menu = String.valueOf(menu.charAt(0));

->  입력 받을 수 있는 scanner 생성하고 String 자료값을 가지는 변수 menu 선언함
[ HOME ], R. TODO 등록하기 , L. TODO 목록조회 , Q. 프로그램 종료 , >>> 출력

menu = scanner.nextLine().trim();
menu = String.valueOf(menu.charAt(0));
-> 이 부분은 안배워서 잘 모름
menu 값을 입력 받는데 양옆에 공백없애고 입력 받은 값 첫번째를 String 값으로 변환?


 boolean isAlphabet = menu.matches("[a-zA-Z]");
        if (!isAlphabet) {
            System.out.println("영문자만 입력 가능합니다");
            return;
        }

-> boolean 자료형의 변수 isAlphabet 은 a-zA-Z 값을 가짐? (matches 이것도 안배움)
조건문 만약 a-zA-Z이 아니면 영문자만 입력 가능합니다 출력
솔직히 return;은 잘 모르겠음 끝내는 건가?


menu = menu.toUpperCase();
        if ("Q".equals(menu)) {
            TodoMain.running = false;
        } else if ("R".equals(menu)) {
            TodoMain.pathIndex = 1;
        } else if ("L".equals(menu)) {
            TodoMain.pathIndex = 2;
        } else {
            System.out.println("다시 입력하세요.");
        }
    }

-> menu 값은 소문자로 입력해도 대문자로 변환됨
조건문 만약 Q 가 입력되면 TodoMain 에 있는  running 값이 false가 됨
메뉴에 입력되는 값이 R이랑 같으면 TodoMain의 pathIndex 값이 1로 바뀜
1로 바뀌면 RegisterView의 show로 이동?
L이 입력되면 TodoMain의 pathIndex 값이 2로 바뀜
그러면 ListView의 show로 이동?
전부 아니면 다시 입력하세요 출력

->  RegisterView의 show로 이동하기

@Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String content;
        System.out.println("[ REGISTER ]");
        System.out.println("내용을 입력하세요. ");
        System.out.print(">>> ");
        content = scanner.nextLine().trim();

-> scanner로 입력받는 기능 생성
String을 반환값으로 하는 변수 content 선언
[ REGISTER ], 내용을 입력하세요. >>>  출력
입력 받은 content 값은 양 옆 공백 없앰

 Todo newTodo = new Todo();

-> 새로운 Todo를 Todo를 반환값으로 가지는 변수 newTodo에 담아둠

newTodo.setContent(content);
TodoRepository.getInstance().insert(newTodo);

-> Todo  클래스의 content가  private라서 setter  를 사용한 건가? 근데 왜 저런 코드가 나오는지 잘모르겠음

System.out.println("TODO 등록 완료.");
TodoMain.pathIndex = 0;

-> TODO 등록 완료 출력하고 TodoMain의 pathIndex 값을 0으로 바꿈
그러면 HomeView의 show로 다시 돌아감

-> ListView의 show로 이동하기

 @Override
    public void show() {
        System.out.println("[ LIST ]");
        List<Todo> todos = TodoRepository.getInstance().findAll();
        if (todos.size() == 0) {
            System.out.println("등록된 TODO가 없습니다.");
            TodoMain.pathIndex = 0;
            return;
        }
        for (Todo todo : todos) {
            System.out.println(todo);
        }
        TodoMain.pathIndex = 0;

->  [ LIST ] 출력
Todo 타입 객체만 담을 수 있는 List 를 반환값으로 가지는 변수 todos에 TodoRepository.getInstance().findAll(); 를 담는다..???? 모르겠어.




조건문 만약 todos의 크기가 0이면 등록된 TODO가 없습니다 출력하고 TodoMain의 pathIndex 값을 0으로 바꾸고 끝냄
반복문 todos 리스트 안에 있는 Todo를 반환값으로 가지는 todo를 하나씩 순서대로 꺼내고 todo를 출력
아니면 TodoMain의 pathIndex  값을 0으로 바꿈

해석 순서를 잘 모르겠어서 그냥 코드 적힌 순서대로 해석함.

interface Repository<T> {
    void insert(T t);
    void update(T t);
    T delete(int id);
    T findById(int id);
    List<T> findAll();

-> 제네릭도 잘 모르겠음 <T>. 이 위의 코드 전부 모르겠음



class TodoRepository implements Repository<Todo> {
    private static TodoRepository instance;
    private int lastId;
    private List<Todo> todos;

    private TodoRepository() {
        lastId = 1;
        todos = new ArrayList<>();
    }

    public static TodoRepository getInstance() {
        if (instance == null) {
            instance = new TodoRepository();
        }
        return instance;
    }

-> Todo 객체만 담을 수 있는 Repository 를 상속받는 TodoRepository  클래스 생성







 */