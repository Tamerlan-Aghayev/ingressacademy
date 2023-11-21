package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Subscriptions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subscriptionid")
    private long subscriptionid;
    @Basic
    @Column(name = "studentid")
    private Long studentid;
    @Basic
    @Column(name = "authorid")
    private Long authorid;
    @ManyToOne
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    private Students studentsByStudentid;
    @ManyToOne
    @JoinColumn(name = "authorid", referencedColumnName = "authorid")
    private Authors authorsByAuthorid;

    public long getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(long subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public Long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriptions that = (Subscriptions) o;
        return subscriptionid == that.subscriptionid && Objects.equals(studentid, that.studentid) && Objects.equals(authorid, that.authorid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionid, studentid, authorid);
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
