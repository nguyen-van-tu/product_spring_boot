package com.codegym.model;


import javax.persistence.*;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String password;

    @ManyToOne
    private com.codegym.demospringboot.model.AppRole role;

    public com.codegym.demospringboot.model.AppRole getRole() {
        return role;
    }

    public void setRole(com.codegym.demospringboot.model.AppRole role) {
        this.role = role;
    }

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
