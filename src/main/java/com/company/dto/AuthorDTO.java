package com.company.dto;

import com.company.entity.Authors;

import java.util.List;

public class AuthorDTO {
    private String name;
    private int age;
    private List<BookDTO> bookDTOS;
    public AuthorDTO(){

    }

    public AuthorDTO(Authors author) {

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

    public List<BookDTO> getBookDTOS() {
        return bookDTOS;
    }

    public void setBookDTOS(List<BookDTO> bookDTOS) {
        this.bookDTOS = bookDTOS;
    }


}
