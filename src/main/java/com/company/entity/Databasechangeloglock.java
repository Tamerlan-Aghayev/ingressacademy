package com.company.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Databasechangeloglock {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "locked")
    private boolean locked;
    @Basic
    @Column(name = "lockgranted")
    private Timestamp lockgranted;
    @Basic
    @Column(name = "lockedby")
    private String lockedby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Timestamp getLockgranted() {
        return lockgranted;
    }

    public void setLockgranted(Timestamp lockgranted) {
        this.lockgranted = lockgranted;
    }

    public String getLockedby() {
        return lockedby;
    }

    public void setLockedby(String lockedby) {
        this.lockedby = lockedby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Databasechangeloglock that = (Databasechangeloglock) o;
        return id == that.id && locked == that.locked && Objects.equals(lockgranted, that.lockgranted) && Objects.equals(lockedby, that.lockedby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locked, lockgranted, lockedby);
    }
}
