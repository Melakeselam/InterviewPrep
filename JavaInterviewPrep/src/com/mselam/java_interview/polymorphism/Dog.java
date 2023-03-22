package com.mselam.java_interview.polymorphism;

public class Dog implements AnimalDo{
    @Override
    public void say() {
        System.out.println("bark!bark");
    }

    @Override
    public void sing() {
        System.out.println("AAAAWuuuuu!");

    }

    @Override
    public void move() {
        System.out.println("lunge");
    }
}
