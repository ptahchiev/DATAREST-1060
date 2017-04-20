package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Petar Tahchiev
 * @since 1.5
 */
@Entity
public class ProductEntity {

    public static final String NAME = "product";

    @Id
    private long id;

    @Column
    private String test;

    @Column
    private Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
