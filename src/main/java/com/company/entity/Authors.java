package com.company.entity;

import javax.persistence.*;
import java.util.List;
import java.util.List;
import java.util.Objects;

@Entity
public class Authors {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "authorid")
    private long authorid;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Users usersByUserid;
    @OneToMany(mappedBy = "authorsByAuthorid")
    private List<Books> booksByAuthorid;
    @OneToMany(mappedBy = "authorsByAuthorid")
    private List<Notification> notificationsByAuthorid;
    @OneToMany(mappedBy = "authorsByAuthorid")
    private List<Subscriptions> subscriptionsByAuthorid;


    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authors authors = (Authors) o;
        return authorid == authors.authorid && Objects.equals(name, authors.name) && Objects.equals(age, authors.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorid, name, age);
    }

    public Users getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(Users usersByUserid) {
        this.usersByUserid = usersByUserid;
    }

    public List<Books> getBooksByAuthorid() {
        return booksByAuthorid;
    }

    public void setBooksByAuthorid(List<Books> booksByAuthorid) {
        this.booksByAuthorid = booksByAuthorid;
    }


    public List<Notification> getNotificationsByAuthorid() {
        return notificationsByAuthorid;
    }

    public void setNotificationsByAuthorid(List<Notification> notificationsByAuthorid) {
        this.notificationsByAuthorid = notificationsByAuthorid;
    }


    public List<Subscriptions> getSubscriptionsByAuthorid() {
        return subscriptionsByAuthorid;
    }



    public void setSubscriptionsByAuthorid(List<Subscriptions> subscriptionsByAuthorid) {
        this.subscriptionsByAuthorid = subscriptionsByAuthorid;
    }


}
