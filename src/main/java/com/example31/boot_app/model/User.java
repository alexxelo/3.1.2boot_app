package com.example31.boot_app.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;

    public User() {

    }

    public User(int id, int age, String model) {
        this.id = id;
        this.age = age;
        this.name = model;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                " id = " + id +
                ", age = " + age +
                ", name = '" + name + '\'' +
                "}";
    }


}
