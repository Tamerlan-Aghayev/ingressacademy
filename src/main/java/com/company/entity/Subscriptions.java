package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Subscriptions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subscriptionid")
    private long subscriptionid;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriptions that = (Subscriptions) o;
        return subscriptionid == that.subscriptionid ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionid);
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
