package com.mselam.java_interview.serializatiion;

import java.beans.Transient;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SerializableObject implements Externalizable {

    private static final long serialVersionUID = -2936687026040726549L;
    private int id;
    private String name;

    private  NonSerializableObject nonSerialObj;

    public SerializableObject() {
    }

    public SerializableObject(int id, String name, NonSerializableObject nonSerialObj) {
        this.id = id;
        this.name = name;
        this.nonSerialObj = nonSerialObj;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id =in.readInt();
        this.name = in.readUTF();
    }

    @Override
    public String toString() {
        return "SerializableObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nonSerialObj=" + nonSerialObj +
                '}';
    }
}
