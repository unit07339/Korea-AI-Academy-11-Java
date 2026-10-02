package com.korai.study.ch07;

import java.util.ArrayList;
import java.util.List;

public class AbstractMain06 {
    public static void main(String[] args) {
        List<RemoteControl> remoteControls = List.of(
                new TvRemoteControl(),
                new MonitorRemoteControl(),
                new TvRemoteControl(),
                new MonitorRemoteControl()
        ); // Immutable

        for (int i = 0; i < remoteControls.size(); i++) {
            RemoteControl r = remoteControls.get(i);
            r.powerOn();
        }

        for (RemoteControl r : remoteControls) {
            r.powerOn();
        }
    }
}

interface Sensor { // 클래스 대신에 interface. abstract class를 interface로 적은 것
    void send(); // interface는 처음부터 끝까지 전부 추상 메서드
    void on();
    void off();


    default void send2() {

    }
}

abstract class RemoteControl implements Sensor { // 추상 클래스 (추상적인 객체가 포함되어 있으면 추상. abstract class는 생성불가)
    // abstract class 는 필드 등등 평범한 클래스처럼 만들 수 있음. 추상화 시키고 싶은 것만 abstract 붙이기(일반 메서드 정의 가능)
    // 리모컨
    String modelName;
    void showModelName() {
        System.out.println(modelName);
    } // 일반 변수, 일반 메서드로 사용 가능

    abstract void powerOn(); // 추상 메서드

//    void powerOn() {
//
//    } // 재정의
}

class TvRemoteControl extends  RemoteControl {
    @Override
    void powerOn() {
        System.out.println("TV 회로에 맞게 전원 공급");
    }

    @Override
    public void send() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }
}

class MonitorRemoteControl extends  RemoteControl {
    @Override
    void powerOn() {
        System.out.println("모니터 회로에 맞게 전원 공급");
    }

    @Override
    public void send() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }
} // ctrl i = implements , ctrl o = override
// implements 다중, extends 단일