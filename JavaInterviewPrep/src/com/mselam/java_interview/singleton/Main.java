package com.mselam.java_interview.singleton;

public class Main {
    public static void main(String[] args) {

        SingletonClass mySingletion = SingletonClass.getInstance();

        System.out.println(mySingletion);

        SingletonClass newSingleton = SingletonClass.getInstance();

        System.out.println(newSingleton);
    }
}
