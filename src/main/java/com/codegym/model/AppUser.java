package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    @NotEmpty(message = "Name not empty")
    private String name;
    @Size(min = 6, max=30, message = "Length from 6 to 30")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
