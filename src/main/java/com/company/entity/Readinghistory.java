package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Readinghistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "readingid")
    private long readingid;

    @ManyToOne
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    private Students studentsByStudentid;
    @ManyToOne
    @JoinColumn(name = "bookid", referencedColumnName = "bookid")
    private Books booksByBookid;

    public long getReadingid() {
        return readingid;
    }

    public void setReadingid(long readingid) {
        this.readingid = readingid;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Readinghistory that = (Readinghistory) o;
        return readingid == that.readingid ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(readingid);
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
