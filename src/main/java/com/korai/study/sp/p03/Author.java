package com.korai.study.sp.p03;

import lombok.*;

// @ 자료형 위에 붙일 수 있음 (일반, 참조 자료형)
@Data // getter, setter, equals, hashcode, toString (인스턴스 메서드)
@NoArgsConstructor
@AllArgsConstructor // 사용자가 수기로 쓴 게 더 먼저.
//@Getter
//@Setter // class 명 위에 하면 전체 getter setter, 변수명 위에 하면 개별 getter setter
public class Author {
//    @Getter
//    @Setter
    private String name; // Getter Setter가 name에만 적용됨 (색 바뀜)
    private String birthday;


////    @NoArgsConstructor = 매개변수 없다는 뜻
//    public Author() {
//
//    }
//
////    @AllArgsContstuctor 아래 코드 자동으로 만들어 주는게 옆 롬복
//    public Author(String name, String birthday) {
//        this.name = name;
//        this.birthday = birthday;
//    }


    // 매개변수가 있으면 전부 오버로딩이 있음
    public Author(String name) {
        this.name = name;
    } // 오버로딩. 같은 이름 쓰는데 매개변수가 같으면 쓸 수 없음

//    public Author(String birthday) {
//        this.birthday = birthday;
//    }

// 의존성주입 -> 조립
    // 로봇이 공격을 하려면 총이 필요함. 로봇이 총을 의존. 로봇 만들 때 총을 넣어줘야함
    // 결합도가 낮은. 객체지향 프로그래밍

    @Data
    @RequiredArgsConstructor // 꼭 필요하다
        @AllArgsConstructor //는 가능
        // @NoArgs~ 는 안됨
    class Publisher {
        private final String name;// publisher 객체 생성할 때 name이 무조건 들어가야함
        private final String address;
        private String address2;

//        public Publisher(String name) {
//            this.name = name;
        } // = @RequiredArgsConstructor / final 받은 변수만 매개변수, this 생성. 무조건 final 있어야함
    }


class AuthorMain {
    public static void main(String[] args) {
        Author  a = new Author();
        Author.Publisher p = a.new Publisher("한빛미디어", "부산", "부산진구");
} // (한빛~ 부산~) 2개만 넣으면 RequireArgs , (한빛 부산 부산진구) 넣으면 AllArgs임
}
