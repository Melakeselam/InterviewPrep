package com.mselam.java_interview.serializatiion;

public class NonSerializableObject {
    int age;

    public NonSerializableObject(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "NonSerializableObject{" +
                "age=" + age +
                '}';
    }
}
