package com.company.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "send_date")
    private Timestamp sendDate;
    @ManyToOne
    @JoinColumn(name = "studentid", referencedColumnName = "studentid", nullable = false)
    private Students studentsByStudentid;
    @ManyToOne
    @JoinColumn(name = "authorid", referencedColumnName = "authorid", nullable = false)
    private Authors authorsByAuthorid;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,message, sendDate);
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
