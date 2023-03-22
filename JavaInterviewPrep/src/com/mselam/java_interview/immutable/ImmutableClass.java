package com.mselam.java_interview.immutable;

/* 1. final indicate it can not be extended*/
public final class ImmutableClass {

    /* 2. fields are set to private so they are not changed from outside*/
    private int id;
    private String field;
    private final ObjectType objectType; /* 4. Mutable fields are set to final so as to set them during initialization only*/

    public ImmutableClass(int id, String field, ObjectType objectType) {
        this.id = id;
        this.field = field;
        this.objectType = objectType;
    }

    /* 3. no field setters are provided*/

    public int getId() {
        return id;
    }

    public String getField() {
        return field;
    }

    /* 5. clones of mutable fields should be returned */
    public ObjectType getObjectType() throws CloneNotSupportedException {
        return (ObjectType) objectType.clone();
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "id=" + id +
                ", field='" + field + '\'' +
                ", objectType=" + objectType +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ImmutableClass myImmutableClass = new ImmutableClass(1,"melak", new ObjectType("a", "b"));
        System.out.println(myImmutableClass.getObjectType());
        myImmutableClass.getObjectType().setField1("x");
        System.out.println(myImmutableClass);
    }
}

class ObjectType{
    private String field1;
    private String field2;

    public ObjectType(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }


    /* 6. overwride the clone method to return a copy of the data of mutable object fields.*/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new ObjectType(field1,field2);
    }

    @Override
    public String toString() {
        return "ObjectType{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}