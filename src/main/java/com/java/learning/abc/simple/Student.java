package com.java.learning.abc.simple;

/**
 * @instruction:
 * @author: lee
 * @date: 2019/2/20
 */
public class Student extends People {
    private double id;

    public Student(){
        super();
    }

    public Student(double id){
        super();
        this.id = id;
    }

    public Student(double id,String name,double weight){
        super(name,weight);
        this.id = id;
    }

    public void setId(double id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
