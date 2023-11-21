package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Studentbook {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;


    @ManyToOne
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    private Students studentsByStudentid;
    @ManyToOne
    @JoinColumn(name = "bookid", referencedColumnName = "bookid")
    private Books booksByBookid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studentbook that = (Studentbook) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Students getStudentsByStudentid() {
        return studentsByStudentid;
    }

    public void setStudentsByStudentid(Students studentsByStudentid) {
        this.studentsByStudentid = studentsByStudentid;
    }

    public Books getBooksByBookid() {
        return booksByBookid;
    }

    public void setBooksByBookid(Books booksByBookid) {
        this.booksByBookid = booksByBookid;
    }
}
