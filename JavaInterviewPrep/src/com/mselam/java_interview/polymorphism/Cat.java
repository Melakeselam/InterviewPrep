package com.mselam.java_interview.polymorphism;

public class Cat implements AnimalDo{
    @Override
    public void say() {
        System.out.println("meaw!");
    }

    @Override
    public void sing() {
        System.out.println("meaw!meaw!meaw!meaw!");

    }

    @Override
    public void move() {
        System.out.println("pounce!");
    }
}
