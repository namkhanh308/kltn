package com.kltn.enttities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client",catalog = "dmloc")
public class Client {

    @Id
    @Column(name = "id")
    private Integer userId;

    @Column(name = "name")
    private Integer name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private Integer gender;

    public Client(Integer userId, Integer name, Integer age, Integer gender) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Client() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
