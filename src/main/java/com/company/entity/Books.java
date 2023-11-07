package com.company.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Books {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bookid")
    private long bookid;
    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    private Students studentsByStudentid;
    @ManyToOne
    @JoinColumn(name = "authorid", referencedColumnName = "authorid")
    private Authors authorsByAuthorid;


    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return bookid == books.bookid && Objects.equals(name, books.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookid, name);
    }

    public Students getStudentsByStudentid() {
        return studentsByStudentid;
    }

    public void setStudentsByStudentid(Students studentsByStudentid) {
        this.studentsByStudentid = studentsByStudentid;
    }

    public Authors getAuthorsByAuthorid() {
        return authorsByAuthorid;
    }

    public void setAuthorsByAuthorid(Authors authorsByAuthorid) {
        this.authorsByAuthorid = authorsByAuthorid;
    }

}
