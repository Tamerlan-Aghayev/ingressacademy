package com.company.dto;

import com.company.entity.Students;

public class StudentDTO {
    private String name;
    private int age;

    public StudentDTO() {

    }

    public StudentDTO(Students student) {
        this.name = student.getName();
        this.age = student.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
