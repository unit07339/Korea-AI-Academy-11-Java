package com.korai.study.ch08;

public class Object01 {
    // 최상위 클래스 (Object) 상속관계에 있어 제일 꼭대기에 있는
    public static void main(String[] args) {
        System.out.println(Student.class.getName());
        System.out.println(new Student().getClass().getName());
        System.out.println(new Student() instanceof Student);
        System.out.println(new Student().getClass() == Student.class);
        System.out.println(new Student().hashCode());
        Student s = new Student();
        System.out.println(s.hashCode());
        // Student 클래스가 Object 클래스를 상속 받고 있음
        System.out.println(Integer.toHexString(s.hashCode()));
        System.out.println(s.toString()); //자료형 String
        System.out.println(s); // toString은 s 와 결과가 동일함. .toString 생략가능, s의 자료형 Student
        String str1 = s.toString(); // 대입 가능
//        String str2 = s; 이건 안됨
        Student s2 = s;
        HighStudent hs1 = new HighStudent();
        System.out.println(hs1); // toString 호출됨


    }
}

class Student extends Object {

}

class HighStudent extends Student {
//    @Override // ctrl + o (shift로 다중 선택)
//    public String toString() {
//        return "내 마음대로 재정의 가능";
//    }
} // 다중 상속은 아님

// 모든 객체가 전부 Object를 상속하고 있기 때문에 toString을 쓸 수 있음. 재정의 가능.

//    @Override
//    public String toString() {
//        return "객체가 가지고 있는 데이터를 문자열로 시각화 할 때 사용";
//    }

    class Teacher {
    private String name;
    private int age;
    private String address;

        public Teacher(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }


        @Override
        public String toString() {
            return "Teacher{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    '}';
        } // alt + ins => toSting 버튼
    }
