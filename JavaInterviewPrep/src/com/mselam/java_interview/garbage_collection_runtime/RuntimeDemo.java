package com.mselam.java_interview.garbage_collection_runtime;

import java.io.IOException;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(String.format("Total memory: %.4fMB",Runtime.getRuntime().totalMemory()/(1024.0*1024)));
        System.out.println(String.format("Free memory: %.4fMB",Runtime.getRuntime().freeMemory()/(1024.0*1024)));

        Runtime.getRuntime().exec(new String[]{"sh","-c","echo 'hello world!'"});
    }
}
