package com.company.dto;

import com.company.entity.Books;

public class BookDTO {
    private String name;
    private String authorName;
    private int authorAge;
    public BookDTO(){

    }

    public BookDTO(Books book) {
        this.name = book.getName();
        this.authorName = book.getAuthorsByAuthorid().getName();
        this.authorAge=book.getAuthorsByAuthorid().getAge();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
    }

}
