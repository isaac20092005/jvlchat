package com.jvlcode.jvlchat.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uname;

    private String phone;

    public User() {
    }

    public User(String uname, String phone) {
        this.uname = uname;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}