package com.company.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Readinghistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "readingid")
    private int readingid;
    @Basic
    @Column(name = "readdate")
    private Date readdate;

    @ManyToOne
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    private Students studentsByStudentid;
    @ManyToOne
    @JoinColumn(name = "bookid", referencedColumnName = "bookid")
    private Books booksByBookid;

    public int getReadingid() {
        return readingid;
    }

    public void setReadingid(int readingid) {
        this.readingid = readingid;
    }

    public Date getReaddate() {
        return readdate;
    }

    public void setReaddate(Date readdate) {
        this.readdate = readdate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Readinghistory that = (Readinghistory) o;
        return readingid == that.readingid && Objects.equals(readdate, that.readdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readingid, readdate);
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
