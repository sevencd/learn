package com.csz.domain;

public class Student {
    private int id;

    private String name;

    private Short sex;

    private Integer age;
    public Student(){
    }
    public Student(int id){
    	this.id=id;
    }
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public int hashCode(){
        return id;
    }
}