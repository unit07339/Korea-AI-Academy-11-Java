package com.korai.study.sp;
// Singleton
public class CarRepositoryManager { // 클래스
    public static void main(String[] args) {
        // CarRepositoryManager mgr = new CarRepositoryManager(); // private 생성자라 직접 생성 불가능

        // 외부에서는 오직 getInstance()로만 객체를 가져옴
        CarRepositoryManager mgr1 = CarRepositoryManager.getInstance();
        CarRepositoryManager mgr2 = CarRepositoryManager.getInstance();

        // mgr1과 mgr2는 완전히 동일한 주소값을 가짐(동일 객체)
        System.out.println(mgr1 == mgr2);
    }

    // 1. private 생성자로 외부 new 키워드 호출 방지
    private CarRepositoryManager() {
        System.out.println("매니저 객체가 딱 한 번 생성됩니다.");
    } // 생성자

    // 2. 내부 static 클래스(Holder)를 활용한 지연 로딩(Lazy Loading)
    private static class SingletonHolder {
        private static final CarRepositoryManager INSTANCE = new CarRepositoryManager();
    }

    // 3. 외부에서 객체를 가져올 수 있는 유일한 통로
    public static CarRepositoryManager getInstance() {
        return  SingletonHolder.INSTANCE;
    }
}
