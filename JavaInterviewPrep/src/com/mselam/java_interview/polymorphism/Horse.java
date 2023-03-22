package com.mselam.java_interview.polymorphism;

public class Horse implements AnimalDo{
    @Override
    public void say() {
        System.out.println("Meeehheeehheee!");
    }

    @Override
    public void sing() {
        System.out.println("Meeeh!.....heeeh!.....heee!");

    }

    @Override
    public void move() {
        System.out.println("gallop!");
    }
}
