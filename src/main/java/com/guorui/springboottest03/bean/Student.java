package com.guorui.springboottest03.bean;

public class Student {

    private String ID;
    private String name;
    private String sex;
    private String password;

    public Student(String ID, String name, String sex, String password) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.password = password;
    }

    public Student(String ID){
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +

                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
