package com.mselam.java_interview.singleton;

import static java.util.Objects.isNull;

/* 1. make the class final so that it can't be extendes to create additional instance*/
public final class SingletonClass {
    private static SingletonClass single_instance;
    /* 2. make the constructor private*/
    private SingletonClass() {
    }

    /* 3. provide a static getter method to return the instance of the singleton*/
    public static synchronized SingletonClass getInstance(){
        if(isNull(single_instance))
            single_instance = new SingletonClass();
        return single_instance;
    }

}
