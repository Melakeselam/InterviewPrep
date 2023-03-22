package com.mselam.java_interview.serializatiion;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableObject s = new SerializableObject(1, "melak", new NonSerializableObject(43));
        String OUTPUT_FILE = "./output.txt";
        FileOutputStream fileOutputStream
                = new FileOutputStream(OUTPUT_FILE);
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        s.writeExternal(objectOutputStream);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream(OUTPUT_FILE);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);

        SerializableObject s2 = new SerializableObject();
        s2.readExternal(objectInputStream);

        objectInputStream.close();
        fileInputStream.close();

        System.out.println("to serialize: " + s);
        System.out.println("after de-serialize: " + s2);
    }
}
