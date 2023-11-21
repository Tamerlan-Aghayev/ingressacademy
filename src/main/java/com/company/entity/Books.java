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
    @Basic
    @Column(name = "studentid")
    private Integer studentid;
    @Basic
    @Column(name = "authorid")
    private Integer authorid;
    @ManyToOne
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    private Students studentsByStudentid;
    @ManyToOne
    @JoinColumn(name = "authorid", referencedColumnName = "authorid")
    private Authors authorsByAuthorid;
    @OneToMany(mappedBy = "booksByBookid")
    private List<Readinghistory> readinghistoriesByBookid;

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

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return bookid == books.bookid && Objects.equals(name, books.name) && Objects.equals(studentid, books.studentid) && Objects.equals(authorid, books.authorid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookid, name, studentid, authorid);
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

    public List<Readinghistory> getReadinghistoriesByBookid() {
        return readinghistoriesByBookid;
    }

    public void setReadinghistoriesByBookid(List<Readinghistory> readinghistoriesByBookid) {
        this.readinghistoriesByBookid = readinghistoriesByBookid;
    }
}
