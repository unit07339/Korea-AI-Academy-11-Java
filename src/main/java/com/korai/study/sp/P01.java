package com.korai.study.sp;
// equals , hashcode
import com.korai.study.ch03.access.User;

import java.util.Objects;

public class P01 {
    public static void main(String[] args) {
        User u1 = new User("홍길동", 20);
        User u2 = new User("홍길동", 20);

        System.out.println(u1.equals(u2));
        System.out.println(u1.hashCode() == u2.hashCode());
    }

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}



