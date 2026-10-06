package com.korai.study.ch09.service;

import com.korai.study.ch09.entity.Car;
import com.korai.study.ch09.repository.CarRepository;

import java.util.ArrayList;

public class InitService implements Runnable { // Runnable 인터페이스를 구현(implements)한 클래스 , 실행될 수 있는 하나의 작업 단위를 나타낸다라는 규칙을 약속. 아래의 run() 메소드를 반드시 구현
    private static CarRepository carRepository; // CarRepository 타입의 변수 carRepository. ststic 은 전체에서 딱 하나만 만들어서 같이 공유

    public InitService() {
//        if (carRepository == null) {
//        run();
//        }
        run();
    }

    @Override //  ctrl i
    public void run() {
        System.out.println("프로그램 초기 설정 시작...");
        carRepository = new CarRepository(new ArrayList<>()); // 빈 리스트를 새로 만들어서 새 저장소를 생성(초기화) 하는 작업
        System.out.println("프로그램 초기 설정 완료");
    }

    public static CarRepository getCarRepository() {
        return carRepository; // 변수가 private로 숨겨져 있어 외부에서 직접 가져갈 수 없음.
                              // 이 저장소가 필요하면 getCar~ 를 불러서 가져가게 하고 저장소 객체를 돌려주는(return) Getter 역할을 하는 코드
    }
}
