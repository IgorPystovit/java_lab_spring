package com.epam.igorpystovit.model;

public class AnnotatedClass {
    @Print(value = 0)
    private int id;
    @Print(value = 1)
    private String name;
    private double age;
    public AnnotatedClass(){}
    public AnnotatedClass(int id,String name,double age){
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
